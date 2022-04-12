<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="SecurityGuard.jsp" %>    
<!DOCTYPE html>+
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/Search.css">
<title>Insert title here</title>
</head>

<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#"><%=session.getAttribute("USERID") %></a>  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/DisplayAll">Display All</a>
      </li>
    </ul>
    <span class="navbar-text">
      Navbar text with an inline element
    </span>
  </div>
</nav>

<div class='row ml-5'>

<div class="text-center text-white pt-5 mb-5">
<form action="<%=request.getContextPath()%>/SearchUser" method="post">
  <div class="row justify-content-md-center">
    <div class="col mt-mx-md-5">
      <input type="text" class="form-control" name="firstName" placeholder="First name">
    </div>
    <div class="col mt-mx-md-5">
      <input type="text" class="form-control" name= "lastName" placeholder="Last name">
    </div>
    <div class="col ">
	 <button type="submit" class="btn btn-primary" ><i class="fa fa-search"></i></button>
    </div>
  </div>
 </form>
 </div>
<div id ="dispAllBtn" class="col-md-mb-3">

<%-- <a href="<%=request.getContextPath()%>/DisplayAll">Display ALl</a> --%>
</div>

<table class="table">
  <tbody>
	<tr>
      <td >${fname }</td>
      <td >${lname }</td>
      <td >${address }</td>
      <td >${city }</td>
	  <td >${phone }</td>
    </tr>
</tbody>
</table>
<div><a href="<%=request.getContextPath()%>/DestroySession"><button class='btn btn-primary'>Log Out</button></a></div>
</div>

</body>
</html>