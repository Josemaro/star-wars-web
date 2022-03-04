<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.List"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<style type="text/css">
    @import url('https://fonts.googleapis.com/css2?family=Righteous&display=swap');
    h2{
        font-family: Righteous;
    }

    body{
        background-color: rgb(208, 247, 211);
    }

   * {
       box-sizing: border-box;
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
       background-color: #333;
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
</style>

<html>
    <body>
        <div class="topnav">
            <a class="active" href="index">Inicio</a>
            <form class="a" action="pokemon" align="right" style="margin-right: 10px;margin-top: 11px">
              <input type="text" id="name" name="name" placeholder="Nombre o Id" />
              <input type="submit" value="Buscar"/>
            </form>
        </div>
        <h2>${character.name}</h2>
        <h2>${character.height}</h2>
        <h2>${character.mass}</h2>
        <h2>${character.hair_color}</h2>
        <h2>${character.skin_color}</h2>
        <h2>${character.eye_color}</h2>
        <h2>${character.birth_year}</h2>
        <h2>${character.gender}</h2>
        <h2>${character.homeworld}</h2>
        <c:forEach var="i" begin="0" end="${films.size()-1}">
            <h2>${films[i].title}</h2>
            <c:set var = "string1" value = "${films[i].url}"/>
            <c:set var = "string2" value = "${fn:substring(string1, 28, 31)}" />                      
            <a href='http://localhost:8080/movies/${string2}' class="btn btn-info">Ver Detalle</a>
        </c:forEach>
    </body>
</html>