package com.handsome.product.api.bean;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 产品ID
	 */
	private String productId;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 产品类型
	 */
	private String productType;
	
	/**
	 * 产品描述
	 */
	private String desc;
	
	/**
	 * 产品价格
	 */
	private String price;
	
	/**
	 * 小图相对地址
	 */
	private String picSmall;
	
	/**
	 * 大图相对地址
	 */
	private String picBig;
	
	/**
	 * 产品状态，0：上线，1：下线，默认下线状态
	 */
	private String status;
	
	/**
	 * 归属企业名称
	 */
	private String ecName;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;

	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public String getProductType()
	{
		return productType;
	}

	public void setProductType(String productType)
	{
		this.productType = productType;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getPicSmall()
	{
		return picSmall;
	}

	public void setPicSmall(String picSmall)
	{
		this.picSmall = picSmall;
	}

	public String getPicBig()
	{
		return picBig;
	}

	public void setPicBig(String picBig)
	{
		this.picBig = picBig;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getEcName()
	{
		return ecName;
	}

	public void setEcName(String ecName)
	{
		this.ecName = ecName;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	@Override
	public String toString()
	{
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productType=" + productType + ", desc="
				+ desc + ", price=" + price + ", picSmall=" + picSmall
				+ ", picBig=" + picBig + ", status=" + status + ", ecName="
				+ ecName + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}


}
