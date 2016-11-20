package com.handsome.pic.api.service;

import java.util.List;

import com.handsome.common.bean.PageInfo;
import com.handsome.pic.api.bean.Pic;

/**
 * 
 * @author dell
 *
 */
public interface PicService
{

	/**
	 * 添加图片
	 * @param pic
	 */
	String createPic(Pic pic);

	/**
	 * 修改图片
	 * @param pic
	 */
	void updatePic(Pic pic);
	
	/**
	 * 查询图片
	 * 
	 * @param pic
	 * @return
	 */
	Pic getPic(Pic picId);

	/**
	 * 查询图片列表  支持分页 PageInfo为空时查询所有
	 * @param pic
	 * @param pi
	 * @return
	 */
	List<Pic> getPicList(Pic pic, PageInfo pi);
	
	/**
	 * 图片总数
	 * @return
	 */
	int countPic();
	
	/**
	 * 根据Id删除图片
	 * 
	 * @param picId
	 * @return
	 */
	int deletePic(String picId);
	
}
