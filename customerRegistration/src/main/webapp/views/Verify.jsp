  <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

 <link rel="stylesheet" href="css/login.css">
        <title>Verify Page</title>
    </head>
    <body>
    
    <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="verification-form" class="form" action="<%=request.getContextPath()%>/VerifyCode" method="post">
        
                            <div class="form-group">
                                <label for="username" class="text-info mt-5">Enter verification code:</label><br>
                                <input type="text" name="authcode" id="verificationCode" class="form-control mt-3" >
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Verify">
                            </div>
                            <div id="register-link" class="text-right">
                                <a href="Register.jsp" class="text-info">Register here</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    

</body>
</html>