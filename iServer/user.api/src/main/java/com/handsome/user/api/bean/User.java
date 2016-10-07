package com.handsome.user.api.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 用户名(昵称)
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 使能：1 启用 2 禁用，默认启用
	 */
	private String enabled;

	/**
	 * 年龄
	 */
	private String age;

	/**
	 * 性别，0：男，1：女，默认0
	 */
	private String sex;

	/**
	 * 联系电话
	 */
	private String phone;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getAccount()
	{
		return account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEnabled()
	{
		return enabled;
	}

	public void setEnabled(String enabled)
	{
		this.enabled = enabled;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
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
		return "User [userId=" + userId + ", account=" + account + ", name="
				+ name + ", password=" + password + ", enabled=" + enabled
				+ ", age=" + age + ", sex=" + sex + ", phone=" + phone
				+ ", email=" + email + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
