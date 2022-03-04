<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.ArrayList"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/mainstyle.css">
<style type="text/css">
    @import url('https://fonts.googleapis.com/css2?family=Righteous&display=swap');
    @import url('http://fonts.cdnfonts.com/css/sf-distant-galaxy');
    h2{
        font-family: News Cycle;
        font-family: 'SF Distant Galaxy', sans-serif;
    }
    
    body{
        font-family: sans-serif;
        color: #ffffff;
        text-align: center;
        background-color: rgb(0, 0, 0);
    }
    
    * {
       box-sizing: border-box;
     }
    
    a:hover{
      color: #ffffff;
      background-color: brown;
    }
     
     /* Float four columns side by side */
     .column {
       float: left;
       width: 25%;
       padding: 10 10px;
     }
     
     /* Remove extra left and right margins, due to padding */
     .row {margin: 0 0px;}
     
     /* Clear floats after the columns */
     .row:after {
       content: "";
       display: table;
       clear: both;
     }
     
     /* Responsive columns */
     @media screen and (max-width: 830px) {
       .column {
         width: 100%;
         display: block;
         margin-bottom: 20px;
       }
     }
     
     /* Style the counter cards */
     .card {
       box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
       padding: 16px;
       text-align: center;
       background-color: rgb(222, 244, 248);
       box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 2px 0px;
       transition: all .2s ease;
     }
    
     .card:hover{
       box-shadow: rgba(0, 0, 0, 0.1) 0px 20px 25px -5px, rgba(0, 0, 0, 0.04) 0px 10px 10px -5px;
       background-color: rgb(180, 235, 248);
       transform: translateY(-5px);
       z-index: 1;
     }
    
     .btn-group button {
       background-color: #04AA6D; /* Green background */
       border: 2px solid green; /* Green border */
       color: white; /* White text */
       padding: 10px 24px; /* Some padding */
       cursor: pointer; /* Pointer/hand icon */
       float: left; /* Float the buttons side by side */
     }
     
     /* Clear floats (clearfix hack) */
     .btn-group:after {
       content: "";
       clear: both;
       display: table;
     }
     
     .btn-group button:not(:last-child) {
       border-right: none; /* Prevent double borders */
     }
     
     /* Add a background color on hover */
     .btn-group button:hover {
       background-color: #00eb08;
     }
    
     .center {
       margin: auto;
       width: 60%;
       padding: 10px;
     }
    
     .boton {
       background-color: #04AA6D; /* Green background */
       border: 2px solid black; /* Green border */
       color: white; /* White text */
       cursor: pointer; /* Pointer/hand icon */
       float: center; /* Float the buttons side by side */
     }
     /* Add a black background color to the top navigation */
     .topnav {
       background-color: rgb(0, 0, 0);
       overflow: hidden;
     }
    
     /* Style the links inside the navigation bar */
     .topnav a {
       float: left;
       color: #f2f2f2;
       text-align: center;
       padding: 14px 16px;
       text-decoration: none;
       font-size: 17px;
     }
    
     /* Change the color of links on hover */
     .topnav a:hover {
       background-color: #ddd;
       color: black;
     }
    
     /* Add a color to the active/current link */
     .topnav a.active {
       background-color: #04AA6D;
       color: white;
     }
     .description-container{
      background-color: rgb(0, 0, 0);
      border: 3px solid rgb(255, 255, 255);
      border-radius: 30px;
      width : 450px;
      padding-left: 15px;
      margin: auto;
      margin-bottom: 10px;
      font-family: "News Cycle", sans-serif;
      font-weight: 700;
      color: #ff6;
      text-align: justify;
      letter-spacing: .1em;
      line-height: 1.1em;
    }
    .párrafos {
      width: 100%;
      z-index: 1;
      transform-origin: 50%;
      transform: perspective(300px) rotateX(10deg);
    }
</style>

<html>
    <body style="background-image: url('https://i.pinimg.com/736x/ba/95/82/ba9582564fa4fa399d2b4ff0092e2a76.jpg');    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;">
        <div class="topnav">
            <a class="active" href="http://localhost:8080/">Inicio</a>
            <a class="inactive" href="http://localhost:8080/movies/">Movies</a>
            <a class="inactive" href="http://localhost:8080/people/">Characters</a>
            <a class="inactive" href="http://localhost:8080/planets/">Planets</a>
        </div>
    <!-- count: <span></span> ${films.count}
    <br />
    episode_id<span></span> : ${movies.get(0).title}
    <br />
    episode_id<span></span> : ${movies.get(1).title} -->
    <br />

    <c:forEach var="i" begin="0" end="${films.count-1}">
      <section class="párrafos">
      <!-- <button type="button" class="collapsible">${movies[i].title}</button> -->
      <!-- <div class="content"> -->
        <h2>
          <c:set var = "string1" value = "${movies[i].url}"/>
          <c:set var = "string2" value = "${fn:substring(string1, 28, 31)}" />   
        <a href="http://localhost:8080/movies/${string2}" style="text-decoration: none; color: #4bd5ee; ">${movies[i].title}</a>

        </h2>
        <div class="description-container">
          <p style="text-align: center; font-size: 20px; font-weight: bold; font-family: 'SF Distant Galaxy', sans-serif;">EPISODE ${movies[i].episode_id}</p>
          <p>${movies[i].opening_crawl}</p>
        </div>
      </section>
    </c:forEach>
        <!-- </div> -->


  </body>
</html>
