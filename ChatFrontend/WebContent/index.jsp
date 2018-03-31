<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1">  

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/.7.0/css/font-awesome.min.css">

<script src="MyRouteConfig.js"></script>
<script src="c_blog/BlogController.js"></script>

<style>
li{
display:inline;list-style-type:none;}
</style>
</head>
<body ng-app="myApp">

<jsp:include page="header.html"></jsp:include>
<nav id="navbar-red" class="navbar navbar-default navbar-static-top" role="navigation">
<div class="container">
<ul class="nav navbar-nav" >
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="bs-demo-navbar-collapse-1">
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>
</ul>
</div>

<div class="collapse navbar-collapse" id="bs-demo-navbar-collapse-1">
<ul style="text-align:right;margin-right:25px;">
<li><a href="/home">Home<i class="fa fa-home"></i></a></li>
<li><a href="#/register">Register<i class="fa fa-registered" ></i></a></li>
<li><a href="#/login">Login<i class="fa fa-sign-in"></i></a></li>
<li><a href="#/blog">Blog<i class="fa fa-sign-in"></i></a></li>
<li><a href="#/contactus">Contact Us<i class="fa fa-sign-in"></i></a></li>
<li><a href="#/aboutus">About Us<i class="fa fa-sign-in"></i></a></li>
</ul>
</div>
</nav>

<body  ng-app="myApp">
<table width="100%" cellspacing="5" cellpadding="2">
<tr bgcolor="lightblue"><td colspan="2" >LetsChat</td></tr>
<tr bgcolor="pink" ><td height="250"><div ng-view> </div></td></tr>
<jsp:include page="footer.html"></jsp:include>

</table>
</body>
</html>