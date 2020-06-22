<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

      <ul
        class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
        id="accordionSidebar"
      >
       <jsp:include page="/WEB-INF/views/admin/include/logo.jsp" flush="false" />
		
		<li>
	   		<hr class="sidebar-divider" />
		</li>
        <li class="nav-item">
          <a class="nav-link" href="./mm">
            <i class="fas fa-fw fa-table"></i>
            <span>회원관리</span></a
          >
        </li>

        <li class="nav-item">
          <a class="nav-link" href="./mb">
            <i class="fas fa-fw fa-table"></i>
            <span>도서관리</span></a
          >
        </li>
      	<li>
   	 		<hr class="sidebar-divider d-none d-md-block" />
      	</li>
        <li style="text-align:center;">
	        <div class="text-center d-none d-md-inline">
	        <button class="rounded-circle border-0" id="sidebarToggle"></button>
	     	</div>
        </li>
      </ul>
