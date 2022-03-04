<%@ page session="false"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %> <%@ page import="java.util.List"%>
<style type="text/css">
  @import url("//db.onlinewebfonts.com/c/0c724f6aa457310440cf8949c615cbd7?family=Star+Jedi");
  h2 {
    font-family: Star Jedi;
    font-family: consolas;
  }
</style>

<html>
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
  </head>

  <body style="background-color: rgb(208, 247, 211)">
    count: <span></span> ${films.count}
    <br />
    episode_id<span></span> : ${movies.get(0).title}
    <br />
    episode_id<span></span> : ${movies.get(1).title}
    <br />
    <c:forEach var="i" begin="0" end="${films.count-1}">
        <!-- <button type="button" class="collapsible">${movies[i].title}</button> -->
        <!-- <div class="content"> -->
            <h2><a href="http://localhost:8080/movies/${i+1}">${movies[i].title}></a></h2>
            <p>"${movies[i].opening_crawl}</p>
        <!-- </div> -->
    </c:forEach>
  </body>
</html>
