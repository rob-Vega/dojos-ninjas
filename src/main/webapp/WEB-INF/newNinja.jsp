<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<main class="container mt-5">
    <div class="row justify-content-center">
        <form:form class="mt-5 col-md-5" action="/ninjas/new" method="POST" modelAttribute="Ninja">
            <h1 class="mb-3">New License</h1>
            <div class="mb-3">
                <form:label class="form-label" path="dojo">Dojo</form:label>
                <form:select class="form-select" path="dojo">
                    <c:forEach items="${dojosList}" var="dojo">
                        <form:option value="${dojo.id} ">
                            ${dojo.name}
                        </form:option>
                    </c:forEach>
                </form:select>
                <form:errors class="text-danger" path="dojo"/>
            </div>
            <div class="mb-3">
                <form:label class="form-label" path="firstName">First Name</form:label>
                <form:input class="form-control" path="firstName"/>
                <form:errors class="text-danger" path="firstName"/>
            </div>
            <div class="mb-3">
                <form:label class="form-label" path="lastName">Last Name</form:label>
                <form:input class="form-control" path="lastName"/>
                <form:errors class="text-danger" path="lastName"/>
            </div>
            <div class="mb-3">
                <form:label class="form-label" path="age">Age</form:label>
                <form:input class="form-control" path="age" type="number"/>
                <form:errors class="text-danger" path="age"/>
            </div>
            <input class="btn btn-primary float-end" type="submit" value="Create"/>
        </form:form>
    </div>
</main>
</body>
</html>