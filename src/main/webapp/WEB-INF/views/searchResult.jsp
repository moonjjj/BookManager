<%@page import="org.springframework.ui.Model"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>도서대여</title>
  <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.9.0/css/all.css"
    />
  <!-- Bootstrap core CSS -->
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="resources/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="resources/css/landing-page.min.css" rel="stylesheet">
  
  <!-- Main CSS -->
  <link rel="stylesheet" href="resources/css/maincss.css">
</head>
<script>
  const slideList = document.querySelector(".slide-container");
  const slideContents = document.querySelectorAll(".col-lg-4");
  const slideBtnNext = document.querySelector('.right'); // next button
  const slideBtnPrev = document.querySelector('.left'); // prev button
</script>
<body>

  <!-- Navigation -->
<jsp:include page="/WEB-INF/views/include/nav.jsp" flush="false" />
  

  <!-- Masthead -->
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />
 

  <!-- Search Result -->
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
  
  
  <!-- Footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="false" />

  <!-- Bootstrap core JavaScript -->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
