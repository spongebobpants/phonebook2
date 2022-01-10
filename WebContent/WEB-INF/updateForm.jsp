<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[Phonebook2]</title>
</head>
<body>
	<h1>[Phonebook2]</h1>

	<h2>전화번호 update폼</h2>

<form action="/phonebook2/pbc" method="get">
	<!-- 절대 경로 : /package/controller -->
		이름(name): <input type="text" name="name" value=""> <br>
		핸드폰(hp): <input type="text" name="hp" value=""> <br>
		회사(company): <input type="text" name="company" value=""> <br>
		코드(id): <input type="text" name="id" value=""><br>
		<button type="submit">update</button>
	</form>
	
</body>
</html>