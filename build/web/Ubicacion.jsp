

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="config.Conexion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="shortcut icon"   href="img/log.jpg" type="image/png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Ubicaciones</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap');
            body{
                background-color: #DCF0E9;
            }
            *{
                font-family: 'Montserrat', Arial;
                font-weight: bold;
            }
            input[type="text"], input[type="submit"]{
                font-family: 'Montserrat', sans-serif;
                font-weight: bold;
                color: black;
                letter-spacing: 1px;
            }
            .buscar{
                display: flex;
                padding-bottom: 20px;
            }

            .form{
                display: flex;
            }
            a[type="submit"]{
                font-family: 'Montserrat', Arial;
                font-weight: bold;
                color: black;
                letter-spacing: 1px;
            }

        </style>
    </head>
    <body>
        <br/>
        <h1 style="text-align: center;margin-bottom: 25px;font-weight: bold;">UBICACIONES DE PRODUCTOS</h1>
        <div class="d-flex">           
            <div class="col-sm-4"> 
                <% if (request.getAttribute("Error") != null) {
                                    out.print("<div class='alert alert-danger'><button class='close' data-dismiss='alert'><span>");
                                    out.print("&times;");
                                    out.print("</span></button>");
                                    out.print("Alerta!");
                                    out.println("<center><span  style='font-weight: 900; padding: 10px;'>");
                                    out.println(request.getAttribute("Error"));
                                    out.println("</span></center></div>");
                                }%>
                <div class="card">                    
                    <div class="card-body">
                        <form action="ControladorUbicacion?menu=Ubicacion" method="POST">
                            <div class="form-group">
                                <label>Datos de la Ubicacion</label>
                            </div>
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" value="${ubicacion.getNom()}" name="txtNombre" required="" class="form-control">
                            </div>
                            <br>
                            
                            <div class="text-center">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                            </div>                         
                        </form>
                    </div>                         
                </div>
            </div>                     
            <div class="col-sm-8">
                <div class="card">

                    <div class="card-body">

                        <table class="table table-hover">
                            <thead>
                                <tr class="thead-dark">
                                    <th>ID</th>
                                    <th>NOMBRE</th>                                
                                    <th>ACCIONES</th>
                                </tr>

                            </thead>
                            <tbody> 
                                <c:forEach var="em" items="${ubicaciones}">
                                    <tr>
                                        <td>${em.getId()}</td>
                                        <td>${em.getNom()}</td>                                     
                                        <td>
                                            <a type="submit" class="btn btn-warning" href="ControladorUbicacion?menu=Ubicacion&accion=Editar&id=${em.getId()}">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                                </svg> 
                                            </a>                                          
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>      
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
