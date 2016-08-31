package com.handsome.admin.auth.bean;

/**
 * 
 * @author dell
 *
 */
public class SiteUser
{
	/**
	 * 用户id
	 */
	private String id;

	/**
	 * 账号
	 */
	private String userName;

	/**
	 * 昵称
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 权限
	 */
	private String authorities;

	/**
	 * 状态
	 */
	private String enabled;

	/**
	 * 年龄
	 */
	private String age;

	/**
	 * 性别
	 */
	private String sex;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
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

	public String getAuthorities()
	{
		return authorities;
	}

	public void setAuthorities(String authorities)
	{
		this.authorities = authorities;
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

	@Override
	public String toString()
	{
		return "SiteUser [id=" + id + ", userName=" + userName + ", name="
				+ name + ", password=" + password + ", authorities="
				+ authorities + ", enabled=" + enabled + ", age=" + age
				+ ", sex=" + sex + "]";
	}
}
