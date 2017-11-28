<%-- 
    Document   : form
    Created on : Mar 29, 2017, 10:27:24 AM
    Author     : Ivar Grimstad (ivar.grimstad@gmail.com)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="${mvc.contextPath}/img/favicon.ico" type="image/x-icon" />
        <title>Simple MVC 1.0 Form</title>
    </head>
    <body>
        <h1>Simple Form</h1>

        <form method="post" action="">
            <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}"/>
            <p>
                <label id="item">First Name:</label>
                <input type="text" name="firstName" value="${hello.firstName}" />
                <font color="red">${mvc.encoders.html(messages.getMessage("firstName"))}</font>
            </p>
            <p>
                <label id="item">Last Name:</label>
                <input type="text" name="lastName" value="${hello.lastName}" />
                <font color="red">${mvc.encoders.html(messages.getMessage("lastName"))}</font>
            </p>
            <p>
                <label id="date">Birth Date</label>
                <input type="date" name="birthDate" value="${hello.birthDate}"/>
                <font color="red">${mvc.encoders.html(messages.getMessage("birthDate"))}</font>
            </p>
            <p>
                <input type="submit" value="Save" name="button"/>
            </p>
        </form>
    </body>
</html>
