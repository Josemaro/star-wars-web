<style type="text/css">
    .center {
      margin: auto;
      padding: 10px;
      text-align: center;
    }
    .centertext {
      margin: auto;
      width: 50%;
      padding: 10px;
      align-content: center;
    }
    img {
      display: block;
      margin-left: auto;
      margin-right: auto;
    }
    form.a {
      display: flexbox;
      margin-top: 10px;
      align-content: flex-end;
    }
    
    /* Add a black background color to the top navigation */
    .topnav {
      background-color: #333;
      overflow: hidden;
    }
    ul {
        padding: 0;
        width: 100%;
    }

    .boton-personalizado-5 {
        text-decoration:none;
        height: 120;
        font-weight: 600;
        font-size: 20px;
        color:#ffffff;
        padding-top:15px;
        padding-bottom:15px;
        padding-left:40px;
        padding-right:40px;
        background-color: transparent;
        border-width: 5px;
        border-style: solid;
        border-color: #ffffff;
        transition: all .2s ease;
    }

    .boton-personalizado-5:hover {
        box-shadow: rgba(255, 116, 61, 0.1) 0px 20px 25px -5px, rgba(231, 26, 180, 0.04) 0px 10px 10px -5px;
        background-color: #c75a5a;
        transform: translateY(-5px);
        z-index: 1;
        text-decoration: none;
        color: #000;
        cursor: pointer;
    }
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<html>
    <body style="background-color: black;"">
        <div class="center">
            <img src="https://cdn.worldvectorlogo.com/logos/star-wars-2.svg"  width="450" />
            <div class="centertext">
                    <a class="boton-personalizado-5" href="http://localhost:8080/movies/">MOVIES</a>
                    <a class="boton-personalizado-5" href="http://localhost:8080/people/">CHARACTERS</a>
                    <a class="boton-personalizado-5" href="http://localhost:8080/planets/">PLANETS</a>
            </div>
        </div>
    </body>
</html>