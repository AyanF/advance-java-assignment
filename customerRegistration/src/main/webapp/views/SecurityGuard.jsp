<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
String value = (String)session.getAttribute("USERID");
 if(session == null)

    response.sendRedirect("Register.jsp");

if(value == null)
{
   response.sendRedirect("Register.jsp");
}

response.addHeader("Pragma", "no-Cache");
response.addHeader("Cache-Control","no-Store");

%>