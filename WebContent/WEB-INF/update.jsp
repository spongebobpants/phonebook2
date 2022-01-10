<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import ="com.javaex.vo.PersonVo" %>
<%@ page import="com.javaex.dao.PhoneDao" %>

<%
	//phoneDao를 메모리에 올린다
	PhoneDao phoneDao = new PhoneDao();
	
	//parameter 4개 (name, hp, Company)
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String company = request.getParameter("company");
	int personId = Integer.parseInt(request.getParameter("id"));
	
	//전송된 파라미터를 vo객체로 만든다
	PersonVo personVo = new PersonVo(personId, name, hp, company);
	
	//수정
	phoneDao.personUpdate(personVo);
	
	//redirect
	response.sendRedirect("./list.jsp");