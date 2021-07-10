<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado Usuarios</title>
  </head>
  <body>
    <h1>Listtado Usuarios</h1>
    <ul>
      <c:forEach items="${usuarios}" var="usuario">
        <li><b>Nombre:</b> ${usuario.nombre} ${usuario.apellido}</li>
      </c:forEach>
    </ul>
  </body>
</html>
