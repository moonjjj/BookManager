<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  <jsp:include page="/WEB-INF/views/admin/include/head.jsp" flush="false" />

  </head>

<body id="page-top">
  <!-- Page Wrapper -->
<div id="wrapper">

	 <!-- Side bar -->
	<jsp:include page="/WEB-INF/views/admin/include/sidebar.jsp" flush="false" />
	
	<div id="content-wrapper" class="d-flex flex-column">
		<div id="content">
		
			<!-- Top bar -->
			<jsp:include page="/WEB-INF/views/admin/include/topbar.jsp" flush="false" />
			
			<!-- Footer -->
			<jsp:include page="/WEB-INF/views/admin/include/footer.jsp" flush="false" />
		</div>
	</div>
</div>
   <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>
    
	<!-- script File -->
	<jsp:include page="/WEB-INF/views/admin/include/scripts.jsp" flush="false" />
  </body>
</html>
