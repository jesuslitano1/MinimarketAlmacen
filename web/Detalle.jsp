<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="shortcut icon"   href="img/log.jpg" type="image/png" />
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap" rel="stylesheet">   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>PEDIDO</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap');
            @media print{
                .parte01,img, .btn, .accion{
                    display: none;
                }
            }

            body{
                background-color: #DCF0E9;
            }
            *{
                font-family: 'Montserrat', Arial;
                font-weight: bold;
            }
            .card h1{
                font-family: 'Montserrat', Arial;
                font-weight: bold;
                color: black;
                letter-spacing: 1px;
                text-align: center;
                padding: 10px;
            }
            input[type="text"], input[type="submit"],input[type="number"]{
                font-family: 'Montserrat', Arial;
                font-weight: bold;
                color: black;
                letter-spacing: 1px;
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
        <br/>
        
        <div class="col-sm-12">
            <div class="card parte02">                    
            <div class="card-body">
                    </br>

                    <div class="form-group">
                        <h1>DETALLE DE PEDIDO</h1>
                    </div>

                    </br>
                    <table class="table table-hover" >
                        <thead class="thead-dark">
                            <tr class="text-center">
                                <th>ID DETALLES</th>
                                <th>ID Pedido</th>
                                <th>ID PRODUCTO</th>
                                <th>NOMBRE PRODUCTO</th>
                                <th>CANTIDAD</th>  
                                <th>ACCION</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="em" items="${detalles}">
                                <tr class="text-center">
                                    <td>${em.getId()}</td>
                                    <td>${em.getIdpedido()}</td>
                                    <td>${em.getIdproducto()}</td>
                                    <td>${em.getDescripcionP()}</td>
                                    <td>${em.getCantidad()}</td>
                                    <td>
                                        <a class="btn btn-success"  href = "ControladorStock?menu=Stock&accion=AumentarStock&id=${em.getId()}" > Actualizar Stock </a>                                      
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>

            </div>
            </br>

            <div align="center">
                <a type="submit" class="btn btn-warning" href = "ControladorRegistro?menu=Registro&accion=Listar" >
                    <svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
                        <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
                    </svg>
                </a>
            </div>
            

        </div>
    
    

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
