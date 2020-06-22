<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>도서관리</title>

    <!-- Custom fonts for this template -->
    <link
      href="../resources/admin/vendor/fontawesome-free/css/all.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet"
    />

    <!-- Custom styles for this template -->
    <link href="../resources/admin/css/sb-admin-2.min.css" rel="stylesheet" />

    <!-- Custom styles for this page -->
    <link
      href="../resources/admin/vendor/datatables/dataTables.bootstrap4.min.css"
      rel="stylesheet"
    />
    <style>
    	.crudButton{
    		
    	}
    </style>
  </head>

  <body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
      <!-- Sidebar -->
      <jsp:include page="/WEB-INF/views/admin/include/sidebar.jsp" flush="false" />

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
        	<jsp:include page="/WEB-INF/views/admin/include/topbar.jsp" flush="false" />

          <!-- Begin Page Content -->
          <div class="container-fluid">
            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">도서관리</h1>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">
                 도서관리 
                </h6>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                 <table
                    class="table table-bordered"
                    id="dataTable"
                    width="100%"
                    cellspacing="0"
                  >
                    <thead>
                      <tr>
                        <th>Book ID</th>
                        <th>Book Name</th>
                        <th>Content</th>
                        <th>Rental Info</th>
                        <th>Thumbnail Info</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>Book ID</th>
                        <th>Book Name</th>
                        <th>Content</th>
                        <th>Rental Info</th>
                        <th>Thumbnail Info</th>
                      </tr>
                    </tfoot>
                    <tbody>
                      <c:forEach var="mylist" items="${list}">
               		<form action="./mbUpdate" method="get">
					 	<tr>
							<td>
							<input style="display:none;" name="bid" value="${mylist.id}">
							[${mylist.id}]
							</td>
							<td>
							<input style="display:none;" name="bname" value="${mylist.name}">
							 ${mylist.name}
							 </td>
							<td>
							<input style="display:none;" name="bcontent" value="${mylist.content}">
							${mylist.content}
							</td>
							<c:set var="rnum" value="${mylist.rnum}"/>
							<td>
							<input style="display:none;" name="rnum" value="${mylist.rnum}">
							<c:choose>
								<c:when test="${mylist.rnum==0}">
								<span style="color:blue">대여가능</span>
								</c:when>
								<c:when test="${mylist.rnum==1}">
								<span style="color:red">대여불가</span>
								</c:when>
							</c:choose>
							</td>
					 		<td>
					 		<input style="display:none;" name="thumbnail" value="${mylist.thumbnail}">
					 		${mylist.thumbnail}
					 		</td>
					 		<td>
					 		<input type="submit" class="crudButton" value="수정">
					 		</td>
						</tr>
	                </form>
					</c:forEach>
                  </table>
                 
                </div>
              </div>
            </div>
          </div>
          <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright &copy; Your Website 2019</span>
            </div>
          </div>
        </footer>
        <!-- End of Footer -->
      </div>
      <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="../resources/admin/vendor/jquery/jquery.min.js"></script>
    <script src="../resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="../resources/admin/javascripts/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="../resources/admin/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="../resources/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="../resources/admin/javascripts/demo/datatables-demo.js"></script>
  </body>
</html>
