<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>



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
  <fmt:message bundle="${loc}" key="local.profile.edit" var = "edit"/>
  <fmt:message bundle="${loc}" key="local.user_detail.firstname" var = "firstname"/>
<fmt:message bundle="${loc}" key="local.user_detail.lastname" var = "lastname"/>
<fmt:message bundle="${loc}" key="local.user_detail.e-mail" var = "email"/>
<fmt:message bundle="${loc}" key="local.user_detail.address" var = "address"/>
<fmt:message bundle="${loc}" key="local.user_detail.phone" var = "phone"/>

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

<c:set target="${by.epam.training.javaWEB.finalTask.bean.UserDetail}" var = "detail" value="${requestScope.userDetail}" scope="page" />
<div class="wrapper fixed__footer">
                   <jsp:include page="/WEB-INF/jsp/header.jsp"/>
        <!-- End Header Style -->
        <!-- Start Bradcaump area -->
        <div class="ht__bradcaump__area" style="background: SkyBlue no-repeat scroll center center / cover ;">
            
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="bradcaump__inner text-center">
                                <h2 class="bradcaump-title">${edit}</h2>
                            </div>
                        </div>
                    </div>
                </div>
            
        </div>
        <!-- End Bradcaump area -->
        <!-- Start Login Register Area -->
        <div class="htc__login__register bg__white ptb--20">
            
                
                <!-- Start Login Register Content -->
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="htc__login__register__wrap">
                            <!-- Start Single Content -->
							
								 
                            
                                <form id= "detail_form" action="Controller" class="login" method="post">
									<input type="hidden" name="command" value="save_user_detail"/>
									<p>${firstname}</p>
                                    <input type="text" name="firstname" value="${detail.firstName}">
                                    <p>${lastname}</p>
									<input type="text" name="lastname" value="${detail.lastName}">
									<p>${phone}
									<input type="text" name="phone" value="${detail.phone}">
									${email}</p>
									<input type="text" name="email" value="${detail.email}">
									<p>${address}</p>
									<input type="text" name="address" value="${detail.address}">
									
									
                                </form>
                               <div class="htc__login__btn mt--30">
                                    <a href="#" onclick="document.getElementById('detail_form').submit();return false" >SAVE</a>
							        <a href="Controller?command=goto&page=index">CANCEL</a>
                                </div>
                                
                                
                            <!-- End Single Content -->
                            <!-- Start Single Content -->
                            
                            <!-- End Single Content -->
                        </div>
                    </div>
                
                <!-- End Login Register Content -->
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