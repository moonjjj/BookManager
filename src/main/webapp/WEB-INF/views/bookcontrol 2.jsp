<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<script src="../resource/js/jquery-3.5.1.js"></script>
<link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script" rel="stylesheet">

<div class="header" align="center"><h1>[관리모드 | 전체 책] 일조 도서관📗</h1></div>
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
    div.search{
    	
    }

   img{ 
    	margin-right:50px;
    	border:1px solid;
    	
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
	div.allDiv{
		display:flex;
		flex-direction:column;
		
	}
	div.allDiv>div{
		display:flex;
	}
  
    </style>
</head>
<body>
	<div class="menu">
		<ul class="menu-list">
			<a href="/bm/logout"><button>로그아웃</button></a><br><br><br>
			<li class="menu-item"><a class="menu-link">전체 책 관리</a></li><br>
			<li class="menu-item"><a href="rent.jsp" class="menu-link">대여/예약 관리</a></li><br>
			<li class="menu-item"><a href="homepageImage.jsp" class="menu-link">홈페이지 관리</a></li><br>
		</ul>
	</div>
	
	<div class="search">
		<form action="bookSearch" method="get">
		<input type="text" id="bname" name="bname" placeholder="책이름 검색" style="text-align:center; width:200px; height:45px;">
		<input type="submit" class="button" value="검색">
		</form>
		<button class="button">추가</button>
		<br><br>
	</div>
	<table class="result_search">
		 <c:forEach var="mylist" items="${list}">
	 	<tr>
	 		<td style="padding:50px 0;" rowspan="2" width="300" height="300"><img src="resources/thumbnail/${mylist.thumbnail}" width="300"></td>
			<td height="70" style="padding:50px 0 0 30px;">[${mylist.id}] ${mylist.name}
			<c:set var="rnum" value="${mylist.rnum}"/>
			<c:choose>
				<c:when test="${rnum==0}">
				<span style="color:blue">대여가능</span>
				</c:when>
				<c:when test="${rnum==1}">
				<span style="color:red">대여불가</span>
				</c:when>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td style="vertical-align:top;padding:50px 0 0 30px;">${mylist.content}</td>
		</tr>
	</c:forEach>
  </table>

</body>
</html>