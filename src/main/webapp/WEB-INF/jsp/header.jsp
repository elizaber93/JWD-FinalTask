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
<fmt:message bundle="${loc}" key="local.nav.products" var = "products"/>
<fmt:message bundle="${loc}" key="local.nav.service" var = "services"/>
<fmt:message bundle="${loc}" key="local.nav.article" var = "articles"/>
<fmt:message bundle="${loc}" key="local.nav.contact" var = "contacts"/>

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
    <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->  

    <!-- Body main wrapper start -->
    
        <!-- Start Header Style -->
        <header id="header" class="htc-header header--3 bg__white">
            <!-- Start Mainmenu Area -->
            <div id="sticky-header-with-topbar" class="mainmenu__area sticky__header">
                <div class="container">
                    <div class="row">
                        <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3">
                            <div class="logo">
                                <a href="Controller?command=goto&page=index">
                                    <img src="images/logo/logo.png" alt="logo">
                                </a>
                            </div>
                        </div>
                        <!-- Start MAinmenu Ares -->
                        <div>
                            <nav>
                                <ul class="main__menu">
                                    <li class="drop"><a href="Controller?command=goto&page=index">${home}</a>
									</li>
                                    <li class="drop"><a href="portfolio-gutter-box-3.html">${products}</a>
                                    </li>
                                    <li class="drop"><a href="blog.html">${services}</a>
                                    </li>
                                    <li class="drop"><a href="#">${articles}</a>
                                    </li>
                                    <li><a class="drop" href="Controller?command=goto&page=contacts">${contacts}</a>
									</li>
														
									<c:set var = "role" scope = "request" value="${sessionScope.role}"/>
									<c:if test="${role eq 'ADMIN'}">
										<li class="drop"><a href="#">Administration</a>
                                    
											<ul class="dropdown">
												<li><a href="Controller?command=goto&page=add_supplier">Add Supplier</a></li>
												<li><a href="Controller?command=supply_addition">Add Supply</a></li>
												<li><a href="Controller?command=see_suppliers">See Suppliers</a></li>
												<li><a href="Controller?command=goto&page=add_article">Add Article</a></li>		
												<li><a href="Controller?command=see_users">See Users</a></li>
												<li><a href="Controller?command=product_addition">Add Product</a></li>
												<li><a href="Controller?command=see_products">See Products</a></li>
												<li><a href="Controller?command=service_addition">Add Service</a></li>
												<li><a href="Controller?command=see_services">See Services</a></li>
												
											</ul>
										</li>
									</c:if>
								
									<li class="drop"><a class="ti-shopping-cart"></a></li>

									<li class="drop"><a class="ti-search"></a></li>
								                             
									<li class="drop"><a href="Controller?command=goto&page=login_register"><span class="ti-user"></span></a>
									<c:set var = "auth" scope = "request" value="${sessionScope.auth}"/>
									<c:if test="${auth == true}">
									<ul class="dropdown">
                                        <li><a href="Controller?command=goto_edit_profile">Edit profile</a></li>
                                        <li><a href="Controller?command=logout">Log out</a></li>
								    </ul>
									</c:if>
									
									
									
									
                                
                            </nav>
							
						
						</div>
						<ul>
							<li>
									<a class = "drop" href="Controller?command=changeloc&language=en&url=${requestScope.fullURL}">${en_button}</a>
									/
									<a  class = "drop" href="Controller?command=changeloc&language=ru&url=${requestScope.fullURL}">${ru_button}</a>
									</li>
							</ul>
                        <!-- End MAinmenu Ares -->
                    </div>
                 
                </div>
            </div>
            <!-- End Mainmenu Area -->
        </header>
		
	
        <!-- End Header Style -->
		</body>
		</html>