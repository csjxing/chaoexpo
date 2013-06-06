package com.doucome.chaoexpo.biz.core.bo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.doucome.chaoexpo.biz.core.exception.UpyunException;
import com.doucome.chaoexpo.biz.core.model.PicModel;
import com.doucome.chaoexpo.biz.core.model.param.ResultModel;
import com.doucome.chaoexpo.biz.core.service.upyun.UpYunService;
import com.doucome.chaoexpo.biz.core.service.upyun.UpYunUtils;
import com.doucome.chaoexpo.biz.core.service.upyun.model.UpyunDataEntity;
import com.doucome.chaoexpo.biz.core.utils.CalendarUtils;

/**
 * 图片上传.
 * @author ze2200
 *
 */
public class ImageUploadBO {
	
	private static final Log logger = LogFactory.getLog(ImageUploadBO.class) ;

	/**
	 * 图片最大5M
	 */
	private static final int IMAGE_MAX_SIZE = 5 * 1024 * 1024;
	
	private List<String> allowExtensions;
	
	private String uploadRoot;
	
	private String imgBucketname;
	
	@Autowired
	private UpYunService upYunService;
	
	/**
	 * 上传本地图片.
	 * @param file
	 * @param fileName
	 * @return
	 */
	public ResultModel<PicModel> uploadPicture(File file, String extName) {
		ResultModel<PicModel> result = new ResultModel<PicModel>();
		if(file == null){
			result.setFail("file.null");
			return result;
		}
		if(!isAllowExtension(extName)){
			result.setFail("file.ext.reject");
			return result;
		}
		long fileSize = file.length();
		if(fileSize > IMAGE_MAX_SIZE || fileSize <= 0){
			result.setFail("file.size.over");
			return result;
		}
		try {		
			byte[] data = FileUtils.readFileToByteArray(file);
			Calendar cal = Calendar.getInstance() ;
			StringBuilder sb = new StringBuilder("/product/").append(CalendarUtils.getYear(cal))
			    .append(CalendarUtils.format00(CalendarUtils.getMonth(cal))).append("/")
				.append(CalendarUtils.format00(CalendarUtils.getDay(cal))).append("/");
			//文件名
			String imageName = genFileName(cal, file.getPath(), extName) ;
			sb.append(imageName) ;
			String toPath = buildUploadPath(sb.toString());
			
			//调用又拍上传
			UpyunDataEntity upyunEntity = new UpyunDataEntity() ;
			upyunEntity.setBucketname(imgBucketname);
			upyunEntity.setData(data) ;
			upyunEntity.setToPath(toPath) ;
			upYunService.upload(upyunEntity) ;
			PicModel picModel = new PicModel(toPath);
			result.setSuccess(picModel);
		}catch (UpyunException e) {
			logger.error(e);
			result.setFail(ResultModel.CODE_EXCEPTION, "file.upload.exception");
		}catch(Exception e){
			logger.error(e);
			result.setFail(ResultModel.CODE_EXCEPTION, "file.upload.exception");
		}
		return result;
    }

	/**
	 * 上传网络图片.
	 * @param pictureUrl
	 * @return
	 */
	public ResultModel<PicModel> uploadPicture(String pictureUrl){
		ResultModel<PicModel> result = new ResultModel<PicModel>();
		if(StringUtils.isBlank(pictureUrl)){
			result.setFail("file.url.empty");
			return result;
		}
		String ext = FilenameUtils.getExtension(pictureUrl);
		if(!isAllowExtension(ext)){
			result.setFail("file.ext.reject");
			return result;
		}
		
		HttpClient client = new DefaultHttpClient() ;
		HttpEntity entry = null ;
		try {		
			HttpGet get = new HttpGet(pictureUrl) ;
			HttpResponse response = client.execute(get) ;
			int statusCode = response.getStatusLine().getStatusCode() ;
			if(statusCode != 200){
				result.setFail("file.request.fail");
				return result;
			}
			entry = response.getEntity() ;
			long len = entry.getContentLength() ;
			if(len > IMAGE_MAX_SIZE){
				result.setFail("file.size.over");
				return result;
			}
			InputStream input = entry.getContent();
			byte[] imgBuffer = UpYunUtils.inputStream2Buf(input, (int)entry.getContentLength());
			if(imgBuffer == null){
				result.setFail("file.null");
				return result;
			}
			Calendar cal = Calendar.getInstance() ;
			StringBuilder sb = new StringBuilder("/product/").append(CalendarUtils.getYear(cal))
			    .append(CalendarUtils.format00(CalendarUtils.getMonth(cal))).append("/")
				.append(CalendarUtils.format00(CalendarUtils.getDay(cal))).append("/");
			String imageName = genFileName(cal , pictureUrl , ext);
			sb.append(imageName);
			String toPath = buildUploadPath(sb.toString());
			UpyunDataEntity upyunEntity = new UpyunDataEntity() ;
			upyunEntity.setBucketname(imgBucketname) ;
			upyunEntity.setData(imgBuffer) ;
			upyunEntity.setToPath(toPath) ;
			upYunService.upload(upyunEntity) ;
			
			PicModel picModel = new PicModel(toPath);
			picModel.setPath(toPath) ;
			result.setSuccess(picModel);
		}catch (UpyunException e) {
			logger.error(e);
			result.setFail(ResultModel.CODE_EXCEPTION, "file.upload.exception");
		}catch(Exception e){
			logger.error(e);
			result.setFail(ResultModel.CODE_EXCEPTION, "file.upload.exception");
		} finally {
			try {
				EntityUtils.consume(entry);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private boolean isAllowExtension(String ext) {
		ext = StringUtils.lowerCase(ext) ;
		for(String temp: allowExtensions){
			if(StringUtils.equals(temp, ext)){
				return true ;
			}
		}
		return false ;
	}
	
	private String genFileName(Calendar time , String hashObject , String ext){
		StringBuilder sb = new StringBuilder() ;
		int hash = hashObject.hashCode() ;
		if(hash < 0){
			hash = hash * - 1;
		}
		sb.append(CalendarUtils.format00(CalendarUtils.getHour(time))).append(CalendarUtils.format00(CalendarUtils.getMinute(time))).append(CalendarUtils.format00(CalendarUtils.getSecond(time))).append(hash) ;
		sb.append(".").append(ext) ;
		return sb.toString() ;
	}
	
	private String buildUploadPath(String toPath){
		return uploadRoot + toPath ;
	}

	public List<String> getAllowExtensions() {
		return allowExtensions;
	}

	public void setAllowExtensions(List<String> allowExtensions) {
		this.allowExtensions = allowExtensions;
	}

	public String getUploadRoot() {
		return uploadRoot;
	}

	public void setUploadRoot(String uploadRoot) {
		this.uploadRoot = uploadRoot;
	}

	public String getImgBucketname() {
		return imgBucketname;
	}

	public void setImgBucketname(String imgBucketname) {
		this.imgBucketname = imgBucketname;
	}
}
