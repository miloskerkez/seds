<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUCCESS</title>
</head>
<body>
YEAAAAAAAAAAAAAAAAAAAA
<br>
${person.name}
<br>
${person.age}
</body>
</html>--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>
  </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Le styles -->
  <link href="assets/css/bootstrap.css" rel="stylesheet">
  <style>
    body { padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */ }
  </style>
  <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
  <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
  </script>
  <![endif]-->
  <!-- Le fav and touch icons -->
  <link rel="shortcut icon" href="assets/ico/favicon.ico">
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
  <style>
    .error {
      color: #ff0000;
    }

    .errorblock {
      color: #000;
      background-color: #ffEEEE;
      border: 3px solid #ff0000;
      padding: 8px;
      margin: 16px;
    }
  </style>
</head>
<body>
<div class="container">
  <div>
    <h1>
      Add Person
    </h1>
    <p>
      Add your person details
      <br>
      &nbsp;
    </p>
  </div>

  <form:form commandName="person">
    <form:errors path="*" cssClass="errorblock" element="div" />
    <label for="textinput1">
      Enter Age:
    </label>
    <form:input path="age" cssErrorClass="error" />
    <form:errors path="age" cssClass="error" />
    <br/>
    <label for="textinput1">
      Enter Name:
    </label>
    <form:input path="name" cssErrorClass="error"/>
    <form:errors path="name" cssClass="error"/>
    <br/>
    <input type="submit" class="btn" value="Add Person"/>
  </form:form>

  <div class="control-group">
  </div>
</div>

<script src="jquery-1.8.3.js">
</script>
<script src="assets/js/bootstrap.js">
</script>
</body>
</html>

