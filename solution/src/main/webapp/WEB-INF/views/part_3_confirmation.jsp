<%-- 
    Document   : order
    Created on : Nov 13, 2015, 2:32:40 PM
    Author     : Ivar Grimstad (ivar.grimstad@gmail.com)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
        <h1>Hello ${greeting.firstName} ${greeting.lastName} from ${greeting .country}</h1>
        <p>Your birthday is in ${greeting.daysToBirthday} days!</p>
        <p> greeting is registered with id: <font color="blue">A${greeting.uuid}</font></p>
    </body>

</html>
