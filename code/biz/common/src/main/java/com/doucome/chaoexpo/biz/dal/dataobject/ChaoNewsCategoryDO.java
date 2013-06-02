package com.doucome.chaoexpo.biz.dal.dataobject;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

/**
 * 资讯分类
 * @author langben 2013-6-2
 *
 */
public class ChaoNewsCategoryDO extends AbstractModel {

	private Long id ;
	
	private String catName ;
	
	private Date gmtCreate ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
}
