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

   
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>${title}
	</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Place favicon.ico in the root directory -->
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    

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
<div class="wrapper fixed__footer">
  <jsp:include page="/WEB-INF/jsp/header.jsp"/>
        
            
        <!-- End Offset Wrapper -->
        <!-- Start Bradcaump area -->
        <div class="ht__bradcaump__area" style="background: rgba(0, 0, 0, 0) url(images/bg/2.jpg) no-repeat scroll center center / cover ;">
            <div class="ht__bradcaump__wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="bradcaump__inner text-center">
                                <h2 class="bradcaump-title">About Us</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.html">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">About Us</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Bradcaump area --> 
        <!-- Start Our Store Area -->
        <section class="htc__store__area ptb--120 bg__white">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section__title section__title--2 text-center">
                            <h2 class="title__line">Welcome To Tmart Store</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore gna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat.</p>
                        </div>
                        <div class="store__btn">
                            <a href="#">contact us</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Our Store Area -->
        <!-- Start Choose Us Area -->
        <section class="htc__choose__us__ares bg__white">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                        <div class="video__wrap bg--3" data--black__overlay="5">
                            <div class="video__inner">
                                <a class="video__trigger video-popup" href="https://www.youtube.com/watch?v=cDDWvj_q-o8">
                                    <i class="zmdi zmdi-play"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                        <div class="htc__choose__wrap bg__cat--4">
                            <h2 class="choose__title">Why Choose Us?</h2>
                            <div class="choose__container">
                                <div class="single__chooose">
                                    <div class="choose__us">
                                        <div class="choose__icon">
                                            <span class="ti-heart"></span>
                                        </div>
                                        <div class="choose__details">
                                            <h4>Free Gift Box</h4>
                                            <p>Lorem ipsum dolor sit amet consect adipisic elit sed do. </p>
                                        </div>
                                    </div>
                                    <div class="choose__us">
                                        <div class="choose__icon">
                                            <span class="ti-truck"></span>
                                        </div>
                                        <div class="choose__details">
                                            <h4>Free Delivery</h4>
                                            <p>Lorem ipsum dolor sit amet consect adipisic elit sed do. </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="single__chooose">
                                    <div class="choose__us">
                                        <div class="choose__icon">
                                            <span class="ti-reload"></span>
                                        </div>
                                        <div class="choose__details">
                                            <h4>Money Back</h4>
                                            <p>Lorem ipsum dolor sit amet consect adipisic elit sed do. </p>
                                        </div>
                                    </div>
                                    <div class="choose__us">
                                        <div class="choose__icon">
                                            <span class="ti-time"></span>
                                        </div>
                                        <div class="choose__details">
                                            <h4>Support 24/7</h4>
                                            <p>Lorem ipsum dolor sit amet consect adipisic elit sed do. </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Choose Us Area -->
        <!-- Start Our Team Area -->
        <section class="htc__team__area bg__white ptb--120">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section__title section__title--2 text-center">
                            <h2 class="title__line">Our Staff</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit sed do eiusmod tempor incididunt ut labo.</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="team__wrap clearfix mt--60">
                        <!-- Start Single Team -->
                        <div class="col-md-4 col-lg-4 col-sm-6 col-xs-12">
                            <div class="team foo">
                                <div class="team__thumb">
                                    <a href="#">
                                        <img src="images/team/1.jpg" alt="team images">
                                    </a>
                                </div>
                                <div class="team__bg__color"></div>
                                <div class="team__hover__info">
                                    <div class="team__hover__action">
                                        <h2><a href="#">Robiul siddikee</a></h2>
                                        <ul class="social__icon">
                                            <li><a href="#"><i class="zmdi zmdi-twitter"></i></a></li>
                                            <li><a href="#"><i class="zmdi zmdi-instagram"></i></a></li>
                                            <li><a href="#"><i class="zmdi zmdi-facebook"></i></a></li>
                                            <li><a href="#"><i class="zmdi zmdi-google-plus"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Single Team -->
                        <!-- Start Single Team -->
                        <div class="col-md-4 col-lg-4 col-sm-6 col-xs-12 xmt-30">
                            <div class="team foo">
                                <div class="team__thumb">
                                    <a href="#">
                                        <img src="images/team/2.jpg" alt="team images">
                                    </a>
                                </div>
                                <div class="team__bg__color"></div>
                                <div class="team__hover__info">
                                    <div class="team__hover__action">
                                        <h2><a href="#">Robiul siddikee</a></h2>
                                        <ul class="social__icon">
                                            <li><a href="#"><i class="zmdi zmdi-twitter"></i></a></li>
                                            <li><a href="#"><i class="zmdi zmdi-instagram"></i></a></li>
                                            <li><a href="#"><i class="zmdi zmdi-facebook"></i></a></li>
                                            <li><a href="#"><i class="zmdi zmdi-google-plus"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Single Team -->
                        <!-- Start Single Team -->
                        <div class="col-md-4 col-lg-4 hidden-sm col-xs-12 xmt-30">
                            <div class="team foo">
                                <div class="team__thumb">
                                    <a href="#">
                                        <img src="images/team/4.jpg" alt="team images">
                                    </a>
                                </div>
                                <div class="team__bg__color"></div>
                                <div class="team__hover__info">
                                    <div class="team__hover__action">
                                        <h2><a href="#">Robiul siddikee</a></h2>
                                        <ul class="social__icon">
                                            <li><a href="#"><i class="zmdi zmdi-twitter"></i></a></li>
                                            <li><a href="#"><i class="zmdi zmdi-instagram"></i></a></li>
                                            <li><a href="#"><i class="zmdi zmdi-facebook"></i></a></li>
                                            <li><a href="#"><i class="zmdi zmdi-google-plus"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Single Team -->
                    </div>
                </div>
            </div>
        </section>
        <!-- End Our Team Area -->
        <!-- Start Testimonial Area -->
        <div class="htc__testimonial__area ptb--120" style="background: rgba(0, 0, 0, 0) url(images/bg/4.jpg) no-repeat scroll center center / cover ;" data--black__overlay="6">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                        <div class="testimonial__wrap owl-carousel owl-theme clearfix">
                            <!-- Start Single Testimonial -->
                            <div class="testimonial">
                                <div class="testimonial__thumb">
                                    <img src="images/test/client/1.png" alt="testimonial images">
                                </div>
                                <div class="testimonial__details">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit sed do eiusmod teincidi dunt ut labore et dolore gna aliqua. Ut enim ad minim veniam,</p>
                                    <div class="test__info">
                                        <span><a href="#">Robiul siddikee</a></span>
                                        <span> - </span>
                                        <span>Customer</span>
                                    </div>
                                </div>
                            </div>
                            <!-- End Single Testimonial -->
                            <!-- Start Single Testimonial -->
                            <div class="testimonial">
                                <div class="testimonial__thumb">
                                    <img src="images/test/client/2.png" alt="testimonial images">
                                </div>
                                <div class="testimonial__details">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit sed do eiusmod teincidi dunt ut labore et dolore gna aliqua. Ut enim ad minim veniam,</p>
                                    <div class="test__info">
                                        <span><a href="#">Robiul siddikee</a></span>
                                        <span> - </span>
                                        <span>Customer</span>
                                    </div>
                                </div>
                            </div>
                            <!-- End Single Testimonial -->
                            <!-- Start Single Testimonial -->
                            <div class="testimonial">
                                <div class="testimonial__thumb">
                                    <img src="images/test/client/3.png" alt="testimonial images">
                                </div>
                                <div class="testimonial__details">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit sed do eiusmod teincidi dunt ut labore et dolore gna aliqua. Ut enim ad minim veniam,</p>
                                    <div class="test__info">
                                        <span><a href="#">Robiul siddikee</a></span>
                                        <span> - </span>
                                        <span>Customer</span>
                                    </div>
                                </div>
                            </div>
                            <!-- End Single Testimonial -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Testimonial Area -->
        <!-- Start brand Area -->
        <div class="htc__brand__area bg__white ptb--120">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="brand__list">
                            <li><a href="#">
                                <img src="images/brand/1.png" alt="brand images">
                            </a></li>
                            <li><a href="#">
                                <img src="images/brand/2.png" alt="brand images">
                            </a></li>
                            <li><a href="#">
                                <img src="images/brand/3.png" alt="brand images">
                            </a></li>
                            <li><a href="#">
                                <img src="images/brand/4.png" alt="brand images">
                            </a></li>
                            <li class="hidden-sm"><a href="#">
                                <img src="images/brand/5.png" alt="brand images">
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- End brand Area -->
        <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
    </div>
    <!-- Body main wrapper end -->
    <!-- Placed js at the end of the document so the pages load faster -->

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