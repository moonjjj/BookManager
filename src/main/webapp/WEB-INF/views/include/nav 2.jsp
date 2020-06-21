<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<nav class="navbar navbar-light bg-light static-top" style="text-align:left;">
    <div class="container" style="width:150px;display:inline-block;margin:0;">
      <a class="navbar-brand" href="/bm"><i  style="color: palevioletred; padding-right: 5px;"class="fas fa-book"></i>츈도서관</a>
    </div>
    <form>
	<%
	if((Boolean)session.getAttribute("isLogon")==null){
	%>
      <a class="btn btn-primary" href="login">로그인</a>
      <a class="btn btn-primary" href="join">회원가입</a>
    <%
	}else{
    %>
    <% out.print(session.getAttribute("mid")); %> 님 환영합니다.
    <a class="btn btn-primary" href="myinfo">내 정보</a>
    <a class="btn btn-primary" href="logout">로그아웃</a>
    <%
	}
    %>
    </form>
  </nav>