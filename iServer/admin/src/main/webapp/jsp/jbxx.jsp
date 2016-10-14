<%--
    Document   : jbxx.jsp
    Created on : 2011-2-20, 23:57:40
    Author     : hkm
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
            //路径、上下文等基本信息
            StringBuffer cc = request.getRequestURL();
            String ccc = cc.toString();
            String xieyi = ccc.substring(0, ccc.indexOf("//") + 2);
            String yuming = ccc.substring(ccc.indexOf("//") + 2);
            yuming = yuming.substring(0, yuming.indexOf("/"));
            yuming = xieyi + yuming;
            out.println("pvo.SITE = '" + yuming + "';");
            out.println("pvo.ROOTPATH = '" + request.getContextPath() + "';");
            String subPath = request.getSession().getServletContext().getInitParameter("subPath");
            out.println("pvo.SUBPATH = '" + subPath + "';");
%>
