<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="shortcut icon"   href="img/logo.jpg" type="image/png" />
        <script src="js/BuscadorTabla.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Empleados</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap');
            body{
                background-color: #DCF0E9;
            }
            *{
                font-family: 'Montserrat', Arial;
                font-weight: bold;
            }
            input[type="text"], input[type="submit"],input[type="number"]{
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
    <body >
        <br/>
        <h1 style="text-align: center;margin-bottom: 25px;font-weight: bold;"><svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" class="bi bi-file-earmark-minus" viewBox="0 0 16 16">
  <path d="M5.5 9a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1H6a.5.5 0 0 1-.5-.5z"/>
  <path d="M14 4.5V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h5.5L14 4.5zm-3 0A1.5 1.5 0 0 1 9.5 3V1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h-2z"/>
</svg> LISTA DE EMPLEADOS</h1>
        <div class="d-flex">
            <div class="col-sm-3">
                <div class="card">
                    <div class="card-body">
                        <form action="ControladorEmpleado?menu=Empleado" method="POST">
                            <div class="form-group">
                                <label>DATOS DEL EMPLEADO</label>
                            </div>
                            <div class="form-group">
                                <label>DNI</label>
                                <input type="number" value="${empleado.getDni()}" maxlength="8" minlength="8" name="txtDni" required="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" value="${empleado.getNom()}" name="txtNombres" required="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Telefono</label>
                                <input type="number" value="${empleado.getTel()}" maxlength="9" minlength="9" name="txtTel" required="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Estado</label>
                                <select value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                                    <option value="Activo">Activo</option>
                                    <option value="Inactivo">Inactivo</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Usuario</label>
                                <input type="text" value="${empleado.getUser()}" name="txtUser" required="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Area</label>
                                <input type="text" value="${empleado.getArea()}" name="txtArea" required="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Cargo</label>
                                <input type="text" value="${empleado.getCargo()}" name="txtCargo" required="" class="form-control">
                            </div>

                            <div class="text-center">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                            </div>
                        </form>
                    </div>                         
                </div>
            </div> 
                           
            <div class="col-sm-9">
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
                        <label style="background: #B6E7D8; padding: 10px; border-radius: 15px;color:black;"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
</svg> BUSCAR: </label>
                        <input style="border-radius: 5px;padding:5px;" id="searchTerm" type="text" onkeyup="doSearch()" />
                        <div class="datagrid">
                        <table class="table table-hover" id="datos">
                            <thead class="thead-dark">
                                <tr class="text-center">
                                    <th>ID</th>
                                    <th>DNI</th>
                                    <th>NOMBRE</th>
                                    <th>TELEFONO</th>
                                    <th>ESTADO</th>
                                    <th>USER</th>
                                    <th>AREA</th>
                                    <th>CARGO</th>
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody> 
                                <c:forEach var="em" items="${empleados}">
                                    <tr>
                                        <td>${em.getId()}</td>
                                        <td>${em.getDni()}</td>
                                        <td>${em.getNom()}</td>
                                        <td>${em.getTel()}</td>
                                        <td>${em.getEstado()}</td>
                                        <td>${em.getUser()}</td>
                                        <td>${em.getArea()}</td>
                                        <td>${em.getCargo()}</td>
                                        <td>
                                            <a type="submit" class="btn btn-warning" href="ControladorEmpleado?menu=Empleado&accion=Editar&id=${em.getId()}">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                                </svg> 
                                            </a>
                                            <a class="btn btn-danger" href="ControladorEmpleado?menu=Empleado&accion=Delete&id=${em.getId()}">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                                                    <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
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
            
        </div>      
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
