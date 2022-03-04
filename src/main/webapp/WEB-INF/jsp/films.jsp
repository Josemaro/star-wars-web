<style type="text/css"> 
    @import url('//db.onlinewebfonts.com/c/0c724f6aa457310440cf8949c615cbd7?family=Star+Jedi');
    p{
        font-family: Star Jedi;
        font-size: 24px;
    }
    h2{
        font-family: consolas;
    }
</style>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>

    <body style="background-color: rgb(208, 247, 211);">
        count: <span></span> ${films.count}
        <br>
        episode_id<span></span>  : ${movies.get(0).title}
        <br>
        episode_id<span></span>  : ${movies.get(1).title}
        <br>
    </body>
</html>