<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.List"%>
<style type="text/css"> 
    @import url('//db.onlinewebfonts.com/c/0c724f6aa457310440cf8949c615cbd7?family=Star+Jedi');
    p{
        font-family: Star Jedi;
        font-size: 24px;
    }
    h2{
        font-family: consolas;
    }
    .card {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        padding: 16px;
        text-align: center;
        background-color: rgb(222, 244, 248);
        box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 2px 0px;
        transition: all .2s ease;
    }
</style>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>

    <body style="background-color: rgb(208, 247, 211);">
        title<span></span>  : ${movie.title}
        <br>
        episode_id<span></span>  : ${movie.episode_id}
        <br>
        opening_crawl<span></span>  : ${movie.opening_crawl}
        <br>
        directorspan</span>  : ${movie.director}
        <br>
        producerspan</span>  : ${movie.producer}
        <br>
        <br>
        characters<span></span>  : ${movie.characters}
        characters<span></span>  : ${people.get(0)}
        \n\n
        characters<span></span>  : ${people.get(1)}
        \n\n
        <c:forEach var="i" begin="0" end="${people.size()}">
                <div class="row">
                    <div class="column">
                        <div class="card">
                            <h2>${people[i].name}</h2>

                        </div>
                        <!-- ${i} -->
                        <!-- ${pokePage.count/pokePage.results.size()} -->
                    </div>
            </c:forEach>
    </body>
</html>