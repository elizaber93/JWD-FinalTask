<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!doctype html>
<html class="no-js" lang="en">
<head>

<meta charset="utf-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

  <fmt:setLocale value="${sessionScope.locale}"/>
  <fmt:setBundle basename="local" var="loc"/>
  
  <fmt:message bundle="${loc}" key="local.title.name" var="title"/>
  <fmt:message bundle="${loc}" key="local.login" var="login"/>
  <fmt:message bundle="${loc}" key="local.password" var="password"/>
  <fmt:message bundle="${loc}" key="local.sign_in" var="sign_in"/>
  <fmt:message bundle="${loc}" key="local.reg" var="reg"/>
  <fmt:message bundle="${loc}" key="local.nav.home" var = "home"/>
  

    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>${title}</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Place favicon.ico in the root directory -->
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    

    <!-- All css files are included here. -->
    <!-- Bootstrap fremwork main css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- This core.css file contents all plugings css file. -->
    <link rel="stylesheet" href="css/core.css">
    <!-- Theme shortcodes/elements style -->
    <link rel="stylesheet" href="css/shortcode/shortcodes.css">
    <!-- Theme main style -->
    <link rel="stylesheet" href="style.css">
    <!-- Responsive css -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- User style -->
    <link rel="stylesheet" href="css/custom.css">


    <!-- Modernizr JS -->
    <script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
<div class="wrapper fixed__footer">
                   <jsp:include page="/WEB-INF/jsp/header.jsp"/>
        <!-- End Header Style -->
		<div class="ht__bradcaump__area" style="background: SkyBlue no-repeat scroll center center / cover ;">
            
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="bradcaump__inner text-center">
                                <h2 class="bradcaump-title">Suppliers</h2>
                            </div>
                        </div>
                    </div>
                </div>
            
        </div>
        
        
        <!-- Start Login Register Area -->
        <div class="htc__login__register bg__white ptb--20">
            <div class="container">
                      <!-- Start Login Register Content -->
                <div class="row">
                     <!-- Start Single Content -->
							<c:set target="${java.util.ArrayList}" var="suppliers" value="${requestScope.supplierList}"/>
							
                            <table>
								<tr><td></td>
									<td>Name</td>
									<td>Requisites</td>
								</tr>
								<c:forEach var="supplier" items="${suppliers}">
										<c:set target="${Supplier}" var="supp" value="${supplier}"/> 
									<form id="${supp.idSupplier}">
							<tr>
							
							<td>
							<input type= "hidden" name="command" value="update_supplier"/>
							<input type="hidden" name="id" value="${supp.idSupplier}"/></td>
							<td><input type="text" name="name" value="${supp.name}" disabled="true"/></td>
							<td><input type="text" name="requisites" value="${supp.requisites}" disabled="true"/></td>
							
							<td><a href="#" onclick="document.getElementById('${supp.idSupplier}').name.disabled=false;
													document.getElementById('${supp.idSupplier}').requisites.disabled=false;return false">Edit</a>
                            </td>
							<td>/</td>
							<td><a href="#" onclick="document.getElementById('${supp.idSupplier}').submit();return false">Save</a>
                            </td>
							</tr>
							</form>
									</c:forEach>
								
						</table>
                          
				    
				</div>
				<a href="Controller?command=goto&page=add_supplier">Add supplier</a>
             
            </div>
        </div>
        <!-- End Login Register Area -->
        <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
		</div>

    <!-- jquery latest version -->
    <script src="js/vendor/jquery-1.12.0.min.js"></script>
    <!-- Bootstrap framework js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- All js plugins included in this file. -->
    <script src="js/plugins.js"></script>
    <script src="js/slick.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <!-- Waypoints.min.js. -->
    <script src="js/waypoints.min.js"></script>
    <!-- Main js file that contents all jQuery plugins activation. -->
    <script src="js/main.js"></script>

</body>

</html>