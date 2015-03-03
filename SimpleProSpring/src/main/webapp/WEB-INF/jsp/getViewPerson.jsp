<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
  <title>ViewPerson Report</title>
</head>
<body>

<table>
  <tr>
    <th>Person Name</th><th>Person Age</th><th>Names of dogs</th>
  </tr>
  <c:forEach items="${vp}" var="vp">
    <tr>
      <td>${vp.personName}</td>
      <td>${vp.personAge}</td>
      <td>
        <c:forEach items="${vp.dogs}" var="dog">
      <br/>
      ${dog.name}
      </c:forEach>
      </td>
    </tr>
  </c:forEach>

</table>
</body>
</html>