<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link  rel="shortcut icon"   href="imgs/icono.jpg" type="image/png" />
        <title>Minimarket</title>
    </head>
    <body>
        <div>
            <div >
                <div>
                    <form action="Validar" method="POST" id="form">
                        <div class="form">
                            <h1>Minimarket Almacen</h1>
                            <h1>Iniciar Sesion</h1>
                            <h1></h1>
                            <img src="imgs/systemV.png" alt="Login">
                            <div class="grupo">
                                <input type="text" name="txtuser" required placeholder=""><span class="barra"></span>
                                <label for=""> Usuario</label>
                            </div>
                            <div class="grupo">
                                <input type="password" name="txtpass" maxlength="8" required placeholder=""><span class="barra"></span>
                                <label for=""> Password</label>
                            </div>

                            <input type="submit" name="accion" value="Ingresar">
                            </br>
                            <% if (request.getAttribute("Error") != null) {
                                    out.println("<center><span  style='font-weight: 900; padding: 10px;'>");
                                    out.println(request.getAttribute("Error"));
                                    out.println("</span></center>");
                                }%>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>