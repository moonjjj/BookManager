<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script" rel="stylesheet">
<div class="header" align="center"><h1>[관리모드 | 홈페이지] 일조 도서관📙</h1></div>
<style>
	div.header{
		background:#86E57F;
	}
    body{
   		font-family: 'Nanum Brush Script', cursive;
		background:#F6F6F6;
		font-size:25px;
    }
    div.menu{
		float:left;
		margin-right: 50px;
		height: 1000px;
		width:200px;
		background:#CEFBC9;
    }
    p{
		display:inline-block;
		
		margin: 0;
  		padding: 0;
    }
    div>div{
    	margin-bottom:50px;
    	
    }
    button {
		background-color: green;
		border: none;
		color: white;
		padding: 14px 30px;
		text-align: center;
		display: inline-block;
		font-size: 16px;
		border-radius: 5px;
	}
	div.member{
		display:flex;
		justify-content:space-between;
	}
	table{
		width:"400";
		height:"300";
		border:1;
	}
    </style>
</head>
<body>
	<input type="text" name="search" placeholder="회원 검색" style="text-align:center; width:200px; height:45px;">
		<button type="submit" class="button">회원 검색</button>
	
	<div class="menu">
		<ul class="menu-list">
			<a href="/bm/logout"><button>로그아웃</button></a><br><br><br>
			<li class="menu-item"><a href="bookControl" class="menu-link">전체 책 관리</a></li><br>
			<li class="menu-item"><a href="rent.jsp" class="menu-link">대여/예약 관리</a></li><br>
			<li class="menu-item"><a class="menu-link">홈페이지 관리</a></li><br>
		</ul>
	</div>
	
				<h4>회원 정보 관리</h4><br>
	<div class="member">
				<table border="1" width="400" height="300">
				<tr align="center">
					<td>ID</td>
					<td width="180">공란</td>
				</tr>
				<tr align="center">
					<td>비밀번호</td>
					<td>1</td>
				</tr>
				<tr align="center">
					<td>대여가능여부</td>
					<td>가능</td>
				</tr>
				<tr align="center">
					<td>대여일자</td>
					<td>day</td>
				</tr>
				<tr align="center">
					<td>대여자</td>
					<td>who</td>
				</tr>
				</table>
				
				<table border="1" width="400" height="300">
				<tr align="center">
					<td>ID</td>
					<td width="180">공란</td>
				</tr>
				<tr align="center">
					<td>비밀번호</td>
					<td>2</td>
				</tr>
				<tr align="center">
					<td>대여가능여부</td>
					<td>가능</td>
				</tr>
				<tr align="center">
					<td>대여일자</td>
					<td>day</td>
				</tr>
				<tr align="center">
					<td>대여자</td>
					<td>who</td>
				</tr>
				</table>
				
				<table border="1" width="400" height="300">
				<tr align="center">
					<td>ID</td>
					<td width="180">공란</td>
				</tr>
				<tr align="center">
					<td>비밀번호</td>
					<td>3</td>
				</tr>
				<tr align="center">
					<td>대여가능여부</td>
					<td>가능</td>
				</tr>
				<tr align="center">
					<td>대여일자</td>
					<td>day</td>
				</tr>
				<tr align="center">
					<td>대여자</td>
					<td>who</td>
				</tr>
				</table>
					
	</div>
		
              
</body>
</html>