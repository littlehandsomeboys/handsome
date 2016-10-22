package com.handsome.admin.siteuser.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handsome.common.bean.PageInfo;
import com.handsome.common.util.PropertiesHelper;
import com.handsome.common.util.TimeUtil;
import com.handsome.pic.api.bean.Pic;
import com.handsome.pic.api.service.PicService;
import com.handsome.siteuser.api.bean.SiteUser;
import com.handsome.siteuser.api.service.SiteUserService;

/**
 * 
 * @author dell
 *
 */
@Api("权限管理接口")
@RestController
@RequestMapping("/siteuser/api")
public class SiteUserApiController
{

	@Autowired
	@Qualifier(value = "siteUserServiceImpl")
	private SiteUserService siteUserService;

	@Autowired
	@Qualifier(value = "picServiceImpl")
	private PicService picService;

	@ApiOperation("查询用户列表")
	@RequestMapping(value = "/querySiteUsers.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String querySiteUsers(HttpServletRequest request)
	{
		SiteUser su = new SiteUser();

		su.setAccount(request.getParameter("account"));
		su.setReserve5(request.getParameter("reserve5"));
		su.setEcName("".equals(request.getParameter("ecName")) ? null : request
				.getParameter("ecName"));

		PageInfo pi = new PageInfo();
		pi.setPageNo(NumberUtils.toInt(request.getParameter("page")));
		pi.setPageSize(NumberUtils.toInt(request.getParameter("rows")));
		// List<SiteUser> sus = siteUserService.getSiteUserList(su, null);
		List<SiteUser> sus = siteUserService.getSiteUserList(su, pi);
		JSONArray rows = new JSONArray();
		for (SiteUser siteUser : sus)
		{
			JSONObject user = new JSONObject();
			user.put("account", siteUser.getAccount());
			user.put("authorities", siteUser.getAuthorities());
			user.put("createDate", siteUser.getCreateDate());
			user.put("ecName", siteUser.getEcName());
			user.put("enabled", siteUser.getEnabled());
			user.put("reserve0", siteUser.getReserve0());
			user.put("reserve1", siteUser.getReserve1());
			user.put("reserve2", siteUser.getReserve2());
			user.put("reserve3", siteUser.getReserve3());
			user.put("reserve4", siteUser.getReserve4());
			user.put("reserve5", siteUser.getReserve5());
			user.put("reserve6", siteUser.getReserve6());
			user.put("reserve7", siteUser.getReserve7());
			user.put("reserve8", siteUser.getReserve8());
			user.put("reserve9", siteUser.getReserve9());
			rows.add(user);
		}

		Integer total = siteUserService.countSiteUser();

		JSONObject res = new JSONObject();
		res.put("total", total);
		res.put("rows", rows);

		return res.toJSONString();
	}

	@ApiOperation("新增管理员")
	@RequestMapping(value = "/addSiteUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addSiteUser(HttpServletRequest request)
	{
		SiteUser su = new SiteUser();
		Map<String, String> res = new HashMap<String, String>();
		res.put("result", "1");
		res.put("mes", "失败");
		su = siteUserService.getSiteUserByUserName(request
				.getParameter("account"));
		if (null != su && StringUtils.isNotEmpty(su.getSiteUserId()))
		{
			res.put("result", "1");
			res.put("mes", "账号已存在，请重新输入！");
		}
		else
		{
			su = new SiteUser();
			su.setAccount(request.getParameter("account"));
			su.setAuthorities(request.getParameter("authorities"));
			su.setEcName(request.getParameter("ecName"));
			su.setPassword("12345");
			su.setReserve0(request.getParameter("reserve0"));
			su.setReserve1(request.getParameter("reserve1"));
			su.setReserve2(request.getParameter("reserve2"));
			su.setReserve3(request.getParameter("reserve3"));
			su.setReserve4(request.getParameter("reserve4"));
			su.setReserve5(request.getParameter("reserve5"));
			su.setReserve6(request.getParameter("reserve6"));
			su.setReserve7(request.getParameter("reserve7"));
			su.setReserve8(request.getParameter("reserve8"));
			su.setReserve9(request.getParameter("reserve9"));
			siteUserService.createSiteUser(su);
			res.put("result", "0");
			res.put("mes", "成功");
		}
		return res;
	}

	@ApiOperation("修改管理员")
	@RequestMapping(value = "/updateSiteUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateSiteUser(HttpServletRequest request)
	{
		SiteUser su = new SiteUser();
		Map<String, String> res = new HashMap<String, String>();
		res.put("result", "1");
		res.put("mes", "失败");
		su = siteUserService.getSiteUserByUserName(request
				.getParameter("account"));
		su.setReserve0(request.getParameter("reserve0"));
		su.setReserve1(request.getParameter("reserve1"));
		su.setReserve2(request.getParameter("reserve2"));
		su.setReserve3(request.getParameter("reserve3"));
		su.setReserve4(request.getParameter("reserve4"));
		su.setReserve5(request.getParameter("reserve5"));
		su.setReserve6(request.getParameter("reserve6"));
		su.setReserve7(request.getParameter("reserve7"));
		su.setReserve8(request.getParameter("reserve8"));
		su.setReserve9(request.getParameter("reserve9"));

		siteUserService.updateSiteUserInfo(su);
		res.put("result", "0");
		res.put("mes", "成功");
		return res;
	}

	@ApiOperation("删除管理员")
	@RequestMapping(value = "/deletSiteUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deletSiteUser(HttpServletRequest request)
	{

		SiteUser su = new SiteUser();
		Map<String, String> res = new HashMap<String, String>();
		res.put("result", "1");
		res.put("mes", "失败");
		su = siteUserService.getSiteUserByUserName(request
				.getParameter("account"));
		siteUserService.deleteUser(su.getSiteUserId());
		res.put("result", "0");
		res.put("mes", "成功");
		return res;
	}

	@ApiOperation("上传图片")
	@RequestMapping(value = "/uploadPic.do", method = RequestMethod.POST)
	public void uploadPic(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false) MultipartFile[] picFile)
	{
		String param = request.getParameter("param");
		String res = "ok";
		Pic pic = new Pic();
		if (0 == picFile[0].getSize())
		{
			res = "empty";
			// return res;
		}
		else if (StringUtils.isNotEmpty(param))
		{
			String picRootUrl = PropertiesHelper.getProperties("picRootUrl");
			String picRootDir = PropertiesHelper.getProperties("picRootDir");

			String fileName = picFile[0].getOriginalFilename();
			fileName = TimeUtil.getTimeStamp() + "_" + fileName;
			FileOutputStream fop = null;
			File file = null;
			
			try
			{
				//头像
				if ("reserve1".equals(param))
				{
					file = new File(picRootDir + "head/" + fileName);
					pic.setDir(picRootDir + "head/" + fileName);
					pic.setUrl(picRootUrl + "head/" + fileName);
					File dir = new File(picRootDir + "head/");
					if (!dir.exists())
					{
						dir.mkdirs();
					}
				}
				//生活照
				else if ("reserve2".equals(param))
				{
					file = new File(picRootDir + "pic/" + fileName);
					pic.setDir(picRootDir + "pic/" + fileName);
					pic.setUrl(picRootUrl + "pic/" + fileName);
					File dir = new File(picRootDir + "pic/");
					if (!dir.exists())
					{
						dir.mkdirs();
					}
				}
				fop = new FileOutputStream(file);
				if (!file.exists())
				{
					file.createNewFile();
				}
				fop.write(picFile[0].getBytes());
				fop.flush();
				 picService.createPic(pic);

			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if (null != fop)
					{
						fop.close();
					}

				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			res = res + "\",\"url\":\"" + pic.getUrl();
			// res = res +
			// "\",\"url\":\""+"http://avatar.csdn.net/8/6/9/1_u014639561.jpg";
		}
		else
		{
			res = "empty";
		}
		// res.put("status", "ok");
		// return res;
		ServletOutputStream out = null;
		OutputStreamWriter ow = null;
		try
		{
			out = response.getOutputStream();
			ow = new OutputStreamWriter(out, "utf8");
			ow.write("{\"res\":\"" + res + "\"}");
			ow.flush();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (null != ow)
				{
					ow.close();
				}
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
