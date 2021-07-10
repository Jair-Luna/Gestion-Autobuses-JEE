<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado Buses</title>
  </head>
  <body>
    <h1>Listado Buses</h1>
    <ul>
      <c:forEach items="${autobuses}" var="autobus">
        <li><b>Marca:</b> ${autobus.marca} <b>Modelo:</b> ${autobus.modelo}</li>
      </c:forEach>
    </ul>
  </body>
</html>
