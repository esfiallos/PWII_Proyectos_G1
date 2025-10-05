
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <title>Informe Final</title>
    <link rel="stylesheet" href="final.css">
</head>
<body>

<h1>Servlet Tarea 1</h1>
<h2>Emerson Barrientos Fiallos</h2>
<h2>Cuenta: 202410060972  </h2>

<h2>Juan Carlos Lopez Rodriguez </h2>
<h2>Cuenta: 241083029  </h2>


<table>

    <tr>
        <th>Ejercicio</th>
        <th>Entrada</th>
        <th>Resultado</th>
    </tr>

    <tr>
        <td> <%= request.getAttribute("ejercicio") %> </td>
        <td> <%= request.getAttribute("entrada") %> </td>
        <td> <%= request.getAttribute("result") %> </td>
    </tr>

</table>

<a href="index.jsp">Regresar al menu</a>

</body>
</html>
