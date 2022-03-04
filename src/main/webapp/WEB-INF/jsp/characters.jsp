<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.ArrayList"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<style type="text/css">
    @import url('https://fonts.googleapis.com/css2?family=Righteous&display=swap');
</style>

<html>
    <body>
        <p>${pageable.results.size()}</p>
        <c:forEach var="i" begin="0" end="${pageable.count}">
            ${people[i].name}
            <br>
        </c:forEach>
    </body>
</html>