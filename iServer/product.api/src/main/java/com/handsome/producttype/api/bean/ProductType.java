package com.handsome.producttype.api.bean;

import java.io.Serializable;
import java.util.Date;

public class ProductType implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 产品类型ID
	 */
	private String productTypeId;
	
	/**
	 * 产品类型名称
	 */
	private String productTypeName;
	
	/**
	 * 父产品name，是根类型填root，否则填写对应父类型的productTypeId
	 */
	private String parentTypeId;
	
	/**
	 * 是否是根类型，0：是，1否
	 */
	private String isRoot;
	
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

	public String getProductTypeId()
	{
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId)
	{
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName()
	{
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName)
	{
		this.productTypeName = productTypeName;
	}

	public String getParentTypeId()
	{
		return parentTypeId;
	}

	public void setParentTypeId(String parentTypeId)
	{
		this.parentTypeId = parentTypeId;
	}

	public String getIsRoot()
	{
		return isRoot;
	}

	public void setIsRoot(String isRoot)
	{
		this.isRoot = isRoot;
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
		return "ProductType [productTypeId=" + productTypeId
				+ ", productTypeName=" + productTypeName + ", parentTypeId="
				+ parentTypeId + ", isRoot=" + isRoot + ", ecName=" + ecName
				+ ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}

}
