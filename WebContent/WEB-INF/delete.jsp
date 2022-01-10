<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import ="com.javaex.dao.PhoneDao" %>

<%
//phoneDao를 메모리에 올린다
PhoneDao phoneDao = new PhoneDao();

//parameter 1개 (id)
int personId = Integer.parseInt(request.getParameter("id"));


//삭제
phoneDao.personDelete(personId);

//redirect
response.sendRedirect("./list.jsp");