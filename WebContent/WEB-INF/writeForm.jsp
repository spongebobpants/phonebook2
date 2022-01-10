<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>[Phonebook2]</h1>

	<h2>전화번호 등록폼</h2>

	<p>
		전화번호를 등록하려면<br>
	   	아래 항목을 기입하고 "등록" 버튼을 클릭하세요
	</p>
	
	<form action="/phonebook2/pbc" method="get">
	<!-- 절대 경로 : /package/controller -->
		이름(name): <input type="text" name="name" value=""> <br>
		핸드폰(hp): <input type="text" name="hp" value=""> <br>
		회사(company): <input type="text" name="company" value=""> <br>
		<input type="text" name="action" value="write">
		<button type="submit">submit</button>
	</form>
	
</body>
</html>