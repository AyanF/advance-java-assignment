<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp : useBean id='partyBean' class="DTO.Party" scope='request'>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src ="js/Register.js" ></script>
<link rel="stylesheet" href="css/Register.css">

<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!--<a class="navbar-brand" href="#">Navbar w/ text</a>  -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Login.jsp">Login</a>
      </li>
    </ul>
    <span class="navbar-text">
      Navbar text with an inline element
    </span>
  </div>
</nav>

<div id="register" class="container mt-5 mb-4">
    <div class="row justify-content-md-center">
        <div class="col-sm-4 border border-primary shadow rounded pt-2">
            <div class="text-center"><img src="https://placehold.it/80x80" class="rounded-circle border p-1"></div>
            <div class="col-sm-12">
                <form method="post" action="<%=request.getContextPath()%>/AddUser" id="singnupFrom" onSubmit="return validation();">
                    <div class="form-group">
                        <label class="font-weight-bold">Email</label>
                        <div class="input-group">
                            <input type="email" name="userLoginId" id="userLoginId" class="form-control" placeholder="Enter valid email">
                            <div class="input-group-append"><button type="button" class="btn btn-primary" onClick="return emailCheck();"><i class="fa fa-envelope"></i></button></div>
                        </div>
                    </div>
                    <div id="next-form" class="collapse">
                        <div class="form-group">
                            <label class="font-weight-bold">First Name <small class="text-danger"></small></label>
                            <input type="text" name="firstName" id="firstName" class="form-control" placeholder="Enter your first name">
                        </div>
                        <div class="form-group">
                            <label class="font-weight-bold">Last Name <small class="text-danger"></small></label>
                            <input type="text" name="lastName" id="lastName" class="form-control" placeholder="Enter your last name">
                        </div>
                        <div class="form-group">
                            <label class="font-weight-bold">Address <small class="text-danger"></small></label>
                            <input type="text" name="address" id="address" class="form-control" placeholder="Enter address">
                        </div>
                        <div class="form-group">
                            <label class="font-weight-bold">City <small class="text-danger"></small></label>
                            <input type="text" name="city1" id="city1" class="form-control" placeholder="Enter City">
                        </div>
                        <div class="form-group">
                            <label class="font-weight-bold">State <small class="text-danger"></small></label>
                            <input type="text" name="state" id="state" class="form-control" placeholder="Enter State/UT">
                        </div>
                        <div class="form-group">
                            <label class="font-weight-bold">Country <small class="text-danger"></small></label>
                            <input type="text" name="country" id="country" class="form-control" placeholder="Enter country">
                        </div>
                        <div class="form-group">
                            <label class="font-weight-bold">ZIP Code <small class="text-danger"></small></label>
                            <input type="text" name="zip" id="zip" class="form-control" placeholder="Enter postal code">
                        </div>
                        
                        <div class="form-group">
                            <label class="font-weight-bold">Phone #</label>
                            <input type="text" name="phone" id="phone" class="form-control" placeholder="(000)-(0000000)">
                        </div>
                        <div class="form-group">
                            <label class="font-weight-bold">Password</label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="***********">
                        </div>
                        <div class="form-group">
                            <label class="font-weight-bold">Confirm Password</label>
                            <input type="password" name="cpassword" id="cpassword" class="form-control" placeholder="***********">
                            <em id="cp"></em>
                        </div>
                        <div class="form-group">
                            <label><input type="checkbox" name="condition" id="condition"> I agree with the <a href="javascript:;">Terms & Conditions</a> for Registration.</label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" value="Sign Up" class="btn btn-block btn-danger">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>