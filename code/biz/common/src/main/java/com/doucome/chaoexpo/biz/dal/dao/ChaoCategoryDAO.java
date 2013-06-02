package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCategoryDO;

/**
 * 类BopsAdminDAO.java的实现描述：后台帐号相关的DAO
 * 
 * @author ib 2012-4-21 下午02:22:52
 */
public interface ChaoCategoryDAO {
	/**
	 * 
	 * @param category
	 * @return
	 */
    Long insertCategory(ChaoCategoryDO category);
    /**
     * 
     * @param id
     * @return
     */
    ChaoCategoryDO queryCategory(Long id);
    /**
     * 
     * @param status
     * @param start
     * @param size
     * @return
     */
    List<ChaoCategoryDO> queryCategoryPage(String status, int start, int size);
    /**
     * 
     * @param status
     * @return
     */
    int countCategory(String status);
    /**
     * 
     * @param category
     * @return
     */
    int updateCategory(ChaoCategoryDO category);
    /**
     * 
     * @param categoryDO
     * @return
     */
    int updateCategoryName(Long id, String name);
    /**
     * 
     * @param id
     * @param status
     * @return
     */
    int updateCategoryStatus(Long id, String status);
    /**
     * 
     * @param id
     * @return
     */
    int deleteCategory(Long id);
}
