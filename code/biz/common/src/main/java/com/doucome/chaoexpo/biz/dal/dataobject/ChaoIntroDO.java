package com.doucome.chaoexpo.biz.dal.dataobject;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

/**
 * 海宁，潮博会介绍
 * @author langben 2013-6-19
 *
 */
public class ChaoIntroDO extends AbstractModel {

	private Long id ;
	
	/**
	 * 海宁地图
	 */
	private String hnMapPicUrls ;
	
	/**
	 * 海宁简介
	 */
	private String hnIntro ;
	
	/**
	 * 潮博会简介
	 */
	private String chaoExpoIntro ;
	
	private Date gmtCreate ;
	
	private Date gmtModified ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHnMapPicUrls() {
		return hnMapPicUrls;
	}

	public void setHnMapPicUrls(String hnMapPicUrls) {
		this.hnMapPicUrls = hnMapPicUrls;
	}

	public String getHnIntro() {
		return hnIntro;
	}

	public void setHnIntro(String hnIntro) {
		this.hnIntro = hnIntro;
	}

	public String getChaoExpoIntro() {
		return chaoExpoIntro;
	}

	public void setChaoExpoIntro(String chaoExpoIntro) {
		this.chaoExpoIntro = chaoExpoIntro;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
}
