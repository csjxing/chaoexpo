package com.doucome.chaoexpo.biz.core.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.doucome.chaoexpo.biz.core.enums.PictureSizeEnums;
import com.doucome.chaoexpo.biz.core.utils.ArrayStringUtils;
import com.doucome.chaoexpo.biz.core.utils.PictureUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivityDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoActivityDTO extends AbstractModel {
	
	private static final Log log = LogFactory.getLog(ChaoActivityDTO.class) ;
	
	private static final long serialVersionUID = 1L;

	private ChaoActivityDO activity ;
	
	private ChaoSubjectDTO subject ;
	
	private Boolean isUserFollowed ;

	public ChaoActivityDTO() {
		this(null);
	}
	
	public ChaoActivityDTO(ChaoActivityDO activity) {
		if(activity == null) {
			activity = new ChaoActivityDO() ;
		}
		this.activity = activity ;
	}
	
	public List<PicModel> getPicModelList() {
		List<String> picList = getPicUrlList() ;
		return PictureUtils.toModelList(picList) ;
	}
	
	public List<PicModel> getStandPicModelList() {
		List<String> standPicList = getStandPicUrlList() ;
		return PictureUtils.toModelList(standPicList) ;
	}
	
	/**
	 * 
	 * @param index
	 * @param sizeType
	 * @return
	 */
	public String getPicAbsoluteUrl(int index, String sizeType) {
		PictureSizeEnums sizeEnum = PictureSizeEnums.toEnum(sizeType);
		List<String> picUrls = getPicUrlList();
		if (index >= picUrls.size()) {
			return "";
		}
		return PictureUtils.getPicAbsoluteUrl(picUrls.get(index), sizeEnum);
	}
	
	/**
	 * 
	 * @param index
	 * @param sizeType
	 * @return
	 */
	public String getPicPath(int index, String sizeType) {
		PictureSizeEnums sizeEnum = PictureSizeEnums.toEnum(sizeType);
		List<String> picUrls = getPicUrlList();
		if (index >= picUrls.size()) {
			return "";
		}
		return PictureUtils.getPicPath(picUrls.get(index), sizeEnum);
	}
	/**
	 * 
	 * @param index
	 * @param sizeType
	 * @return
	 */
	public String getStandPicAbsoluteUrl(int index, String sizeType) {
		PictureSizeEnums sizeEnum = PictureSizeEnums.toEnum(sizeType);
		List<String> picUrls = getStandPicUrlList();
		if (index >= picUrls.size()) {
			return "";
		}
		return PictureUtils.getPicAbsoluteUrl(picUrls.get(index), sizeEnum);
	}
	
	/**
	 * 
	 * @param index
	 * @param sizeType
	 * @return
	 */
	public String getStandPicPath(int index, String sizeType) {
		PictureSizeEnums sizeEnum = PictureSizeEnums.toEnum(sizeType);
		List<String> picUrls = getStandPicUrlList();
		if (index >= picUrls.size()) {
			return "";
		}
		return PictureUtils.getPicPath(picUrls.get(index), sizeEnum);
	}
	
	public Long getId() {
		return activity.getId();
	}
	
	public void setId(Long id) {
		activity.setId(id);
	}

	public String getName() {
		return activity.getName();
	}
	
	public void setName(String name) {
		activity.setName(name);
	}
	
	public String getLocation() {
		return activity.getLocation();
	}

	public void setLocation(String location) {
		activity.setLocation(location);
	}
	
	public String getContactName() {
		return activity.getContactName();
	}
	
	public void setContactName(String contactName) {
		activity.setContactName(contactName);
	}

	public String getContactPhone() {
		return activity.getContactPhone();
	}

	public void setContactPhone(String contactPhone) {
		activity.setContactPhone(contactPhone);
	}

	public String getIntro() {
		return activity.getIntro();
	}
	
	public void setIntro(String intro) {
		activity.setIntro(intro);
	}

	public String getPicUrls() {
		return activity.getPicUrls();
	}
	
	public List<String> getPicUrlList() {
		return ArrayStringUtils.toList(getPicUrls());
	}
	
	public void setPicUrlList(List<String> picUrlList) {
		activity.setPicUrls(ArrayStringUtils.toString(picUrlList));
	}

	public String getNotice() {
		return activity.getNotice();
	}
	
	public void setNotice(String notice) {
		activity.setNotice(notice);
	}

	public String getCountesyReminder() {
		return activity.getCountesyReminder();
	}
	
	public void setCountesyReminder(String countesyReminder) {
		activity.setCountesyReminder(countesyReminder);
	}

	public String getStandPicUrls() {
		return activity.getStandPicUrls();
	}
	
	public List<String> getStandPicUrlList() {
		return ArrayStringUtils.toList(getStandPicUrls());
	}
	
	public void setStandPicUrlList(List<String> standPicUrlList) {
		activity.setStandPicUrls(ArrayStringUtils.toString(standPicUrlList));
	}

	public Long getSubjectId() {
		return activity.getSubjectId();
	}
	
	public void setSubjectId(Long subjectId) {
		activity.setSubjectId(subjectId);
	}
	
	public Integer getFollowCount() {
		return activity.getFollowCount();
	}
	
	public void setFollowCount(Integer followCount) {
		activity.setFollowCount(followCount);
	}

	public Integer getCommentCount() {
		return activity.getCommentCount();
	}
	
	public Integer getCheckinCount() {
		return activity.getCheckinCount() ;
	}
	
	public void setCommentCount(Integer commentCount) {
		activity.setCommentCount(commentCount);
	}

	public Date getGmtCreate() {
		return activity.getGmtCreate();
	}

	public Date getGmtModified() {
		return activity.getGmtModified();
	}
	
	public Date getGmtActivityStart() {
		return activity.getGmtActivityStart();
	}
	
	public Date getGmtActivityEnd() {
		return activity.getGmtActivityEnd();
	}
	
	public void setGmtActivityStart(String gmtActivityStart) {
		try {
			activity.setGmtActivityStart(SimpleDateFormat.getDateInstance().parse(gmtActivityStart));
		} catch (ParseException e) {
			log.error("input dateStr [" + gmtActivityStart + "] error " + e.getMessage() , e) ;
		}
	}
	
	public void setGmtActivityStart(Date gmtActivityStart) {
		activity.setGmtActivityStart(gmtActivityStart);
	}
	
	public void setGmtActivityEnd(String gmtActivityEnd) {
		try {
			activity.setGmtActivityEnd(SimpleDateFormat.getDateInstance().parse(gmtActivityEnd));
		} catch (ParseException e) {
			log.error("input dateStr [" + gmtActivityEnd + "] error " + e.getMessage() , e) ;
		}
	}
	
	public void setGmtActivityEnd(Date gmtActivityEnd) {
		activity.setGmtActivityEnd(gmtActivityEnd);
	}

	
	
	public ChaoSubjectDTO getSubject() {
		return subject;
	}

	public void setSubject(ChaoSubjectDTO subject) {
		this.subject = subject;
	}
	
	public ChaoActivityDO toDO() {
		return activity;
	}
	public Boolean getIsUserFollowed() {
		return isUserFollowed;
	}

	public void setIsUserFollowed(Boolean isUserFollowed) {
		this.isUserFollowed = isUserFollowed;
	}
	
	public String getStatus() {
		return activity.getStatus();
	}
	
	public void setStatus(String status) {
		activity.setStatus(status);
	}
	
	public String getCanSignup() {
		return activity.getCanSignup();
	}


	public Integer getSignupCount() {
		return activity.getSignupCount();
	}
}
