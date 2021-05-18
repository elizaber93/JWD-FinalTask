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
  <fmt:message bundle="${loc}" key="local.loc_en" var="en_button"/>
  <fmt:message bundle="${loc}" key="local.loc_ru" var="ru_button"/>
  <fmt:message bundle="${loc}" key="local.login" var="login"/>
  <fmt:message bundle="${loc}" key="local.password" var="password"/>
  <fmt:message bundle="${loc}" key="local.sign_in" var="sign_in"/>
  <fmt:message bundle="${loc}" key="local.register" var="registration"/>
  <fmt:message bundle="${loc}" key="local.nav.home" var = "home"/>
<fmt:message bundle="${loc}" key="local.nav.produts" var = "products"/>
<fmt:message bundle="${loc}" key="local.nav.service" var = "services"/>
<fmt:message bundle="${loc}" key="local.nav.article" var = "articles"/>
<fmt:message bundle="${loc}" key="local.nav.contact" var = "contacts"/>
<fmt:message bundle="${loc}" key="local.footer.address" var="address"/>
<fmt:message bundle="${loc}" key="local.footer.category" var = "category"/>
<fmt:message bundle="${loc}" key="local.footer.info" var="info"/>
<fmt:message bundle="${loc}" key="local.footer.about" var = "about"/>
<fmt:message bundle="${loc}" key="local.footer.contact" var = "contact"/>

<fmt:message bundle="${loc}" key="local.copyright" var = "copyright"/>
<fmt:message bundle="${loc}" key="local.url" var = "url"/>

    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>${title}</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Place favicon.ico in the root directory -->
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
     
    <!-- All css files are included here. -->
    <!-- Bootstrap fremwork main css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Owl Carousel main css -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
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

<!-- Start Footer Area -->
        <footer>
            <div class="container">
			
                
                
                <!-- Start Copyright Area -->
                <div class="htc__copyright__area">
                    <div class="row">
                        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                            <div class="copyright__inner">
                                <div class="copyright">
                                    <p>© 2021 <a href="#">${url}</a>
                                    ${copyright}</p>
                                </div>
                                <ul class="footer__menu">
                                    <li><a href="Controller?command=goto&page=index">${home}</a></li>
                                    <li><a href="shop.html">${products}</a></li>
									<li><a href="shop.html">${services}</a></li>
                                    <li><a href="Controller?command=goto&page=contact">${contact}</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Copyright Area -->
            </div>
        </footer>
        <!-- End Footer Area -->
		</body>
		</html>