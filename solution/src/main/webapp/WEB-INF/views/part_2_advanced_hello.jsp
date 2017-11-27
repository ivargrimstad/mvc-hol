<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="${mvc.contextPath}/img/favicon.ico" type="image/x-icon" />
        <title>Simple MVC 1.0 Sample</title>
    </head>
    <body>
        <h1>Hello ${greetings.firstName} ${greetings.lastName} from ${greetings.country}</h1>
        <p>Your birthday is in ${greetings.daysToBirthday} days!</p>
        <p> greeting is registered with id: <font color="blue">A${greetings.uuid}</font></p>
    </body>
</html>
