package com.doucome.chaoexpo.biz.core.model.param;

import java.awt.Dimension;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

/**
 * 
 * @author ze2200
 * 
 */
public class PictureModel extends AbstractModel {
	
	private static final long serialVersionUID = 1L;

	private String path;
	
	private int height;
	
	private int width;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setDimension(Dimension dimension) {
		if (dimension == null) {
			return ;
		}
		width = (int) dimension.getWidth();
		height = (int) dimension.getHeight();
	}
}
