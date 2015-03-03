<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
  <title>All Dogs</title>
</head>
<body>

<table>
  <tr>
    <th>Dogs Name</th><th>Owners Name</th>
  </tr>
  <c:forEach items="${viewDogs}" var="vd">
    <tr>
      <td>${vd.dogName}</td>
      <td>${vd.dogOwner}</td>
    </tr>
  </c:forEach>

</table>
</body>
</html>