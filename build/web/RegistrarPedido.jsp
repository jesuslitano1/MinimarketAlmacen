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
        <title>Nuevo Pedido</title>
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
            input[type="text"], input[type="submit"],input[type="number"]{
                font-family: 'Montserrat', Arial;
                font-weight: bold;
                color: black;
                letter-spacing: 1px;
            }
            .card h1{
                font-family: 'Montserrat', Arial;
                font-weight: bold;
                color: black;
                letter-spacing: 1px;
                text-align: center;
                padding: 10px;
            }
            thead th:nth-child(7) {
                background-color: #414140;
                color: white;
                border-radius: 20px;
            }
        </style>

    </head>
    <body>
        <br/>
        <h1 style="text-align: center;margin-bottom: 25px;font-weight: bold;">INGRESAR PEDIDO NUEVO</h1>
        <div class="d-flex">
            <div class="col-lg-5 parte01">
                <div class="card">
                    <form id="generarPedido" onSubmit="return validarCantidad(event);" action="ControladorPedido?menu=NuevoPedido" method="POST">
                        <div class="card-body">
                            <% if (request.getAttribute("Error") != null) {
                                    out.print("<div class='alert alert-danger'><button class='close' data-dismiss='alert'><span>");
                                    out.print("&times;");
                                    out.print("</span></button>");
                                    out.print("Alerta!");
                                    out.println("<center><span  style='font-weight: 900; padding: 10px;'>");
                                    out.println(request.getAttribute("Error"));
                                    out.println("</span></center></div>");
                                }%>
                            <!--DATOS DEL PRODUCTO-->
                            <div class="form-group">
                                <label>Datos del Proveedor</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="number" id="idProveedor" name="codigoproveedor" value="${proveedor.getId()}" class="form-control" placeholder="ID PROVEEDOR">
                                    <button type="submit" name="accion" value="BuscarProveedor" class="btn btn-outline-success"><ion-icon name="search"></ion-icon></button>
                                </div>                           
                                <div class="col-sm-6">
                                    <input type="text" id="nombreDelProveedor" name="nombresProveedor" value="${proveedor.getNom()}" placeholder="Datos proveedor" class="form-control" readonly="" style="background: #fff;">
                                </div>                           
                            </div>
                            <!--DATOS DEL PRODUCTO-->
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div id="buscarProducto" class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="number" id="codProducto" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-success"><ion-icon name="search"></ion-icon></button>
                                </div>                           
                                <div class="col-sm-6">
                                    <input type="text" name="nomproducto" value="${producto.getNom()}" placeholder="Datos Producto" class="form-control" readonly="" style="background: #fff;">
                                </div>  
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-2 d-flex">
                                    <input type="text" class="form-control" placeholder="S/" readonly="" style="background: #fff;">                                
                                </div>
                                <div class="col-sm-4 d-flex">
                                    <input type="text" name="precio" value="${producto.getPre()}" class="form-control" placeholder="0.00" readonly="" style="background: #fff;">                                
                                </div>
                                <div class="col-sm-3">
                                    <input id="cant" type="number" value="1" name="cant" placeholder="" class="form-control ">
                                </div>  
                                <div class="col-sm-3">
                                    <input id="stock" type="text" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control" readonly="" style="background: #fff;">
                                </div>  
                            </div>
                            <!--BOTON AGREGAR PRODUCTO AL REGISTRO-->
                            <div class="form-group">
                                <div class="text-center">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-success">Agregar Producto</button>
                                    <button type="submit" name="accion" value="Listar" class="btn btn-outline-warning">Refrescar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card parte02">                    
                    <div class="card-body">
                        <div class="form-group">
                            <label>Solicitud de pedido</label>
                        </div>
                        <div class="d-flex ml-auto col-sm-12">
                            <label class="text-right mt-2 col-sm-6">NRO. PEDIDO</label>
                            <input readonly="" type="text" name="numeroserie" class="form-control text-center" value="${nserie}" style="font-weight: bold;font-size: 18px">
                        </div>                      
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr class="text-center">
                                    <th>Nro</th>
                                    <th>IDPRODUCTO</th>
                                    <th>PRODUCTO</th>
                                    <th>PRECIO</th>
                                    <th>CANTIDAD</th>
                                    <th>SUBTOTAL</th> 
                                    <th>EDITAR CANTIDAD</th>   
                                    <th class="accion">ACCION</th>                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr class="text-center">
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcionP()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td><input id="cant" type="number" value="${list.getCantidad()}" name="cant" placeholder="" class="form-control"></td>
                                        <td>${list.getSubtotal()}</td>
                                        <td>        
                                            <input type="hidden" id="item1" value="${list.getIdproducto()}">
                                            <input type="number" min="1" max="10"  id="Cant" class=" form-control text-center" value="${list.getCantidad()}">
                                        </td>
                                        <td class="d-flex">
                                            <input type="hidden" id="item2" value="${list.getIdproducto()}">
                                            <a id="btnDeleteItem" href="#" class="btn btn-danger" >Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer" >
                        <div class="row">
                            <div class="col-sm-6">
                                <a href="ControladorPedido?menu=NuevoPedido&accion=GenerarPedido" onclick="print()" class="btn btn-success">Generar Pedido</a>
                                <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                            </div>
                            <div class="col-sm-6 ml-auto d-flex">                                
                                <label class=" col-sm-6 text-right mt-2">Total a Pagar</label>                                                       
                                <input type="text" name="txtTotal" value="S/. ${totalpagar}0" class="form-control text-center font-weight-bold" style="font-size: 18px;">
                            </div>
                        </div>                        
                    </div>
                </div>

            </div>
        </div>
        <!--        </br>
                </br>
                <div class="d-flex">
                    <div class="col-lg-12">
                        <div class="card">
                            <h1>Ventas Recientes</h1>
                            <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>IDEMPLEADO</th>
                                            <th>NUMERO DE SERIE</th>
                                            <th>FECHA</th>
                                            <th>MONTO</th>    
                                            <th>ESTADO</th>
                                        </tr>
        
                                    </thead>
                                    <tbody> 
        <c:forEach var="em" items="${pedido}">
            <tr>
                <td>${em.getId()}</td>
                <td>${em.getIdProveedor()}</td>
                <td>${em.getIdEmpleado()}</td> 
                <td>${em.getNumserie()}</td>
                <td>${em.getFecha()}</td>
                <td>${em.getMonto()}</td>     
                <td>${em.getEstado()}</td>   
            </tr>
        </c:forEach>

    </tbody>
</table>
</div>
</div>
</div>-->


        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script type="text/javascript">

                                    // Funcion para validar cantidad y stock
                                    function validarCantidad(e) {
                                        var cant = parseInt(document.getElementById("cant").value);
                                        var stock = parseInt(document.getElementById("stock").value);
                                        var formulario = document.getElementById("generarPedido");
                                        var idProveedor = document.getElementById("idProveedor").value;
                                        var nombreDelProveedor = document.getElementById("nombreDelProveedor").value;
                                        if (stock < cant || stock == 0) {
                                            alert("Este producto no posee stock o la cantidad solicitada es mayor al stock disponible");
                                            document.getElementById("cant").value = "0";
                                            document.getElementById("stock").value = "";
                                            document.getElementById("idProveedor").value = idProveedor;
                                            document.getElementById("nombreDelProveedor").value = nombreDelProveedor
                                            e.preventDefault();
                                            return false;
                                        } else {
                                            formulario.submit();
                                            return true;
                                        }
                                    }
        </script>
        <script src="js/funciones.js" type="text/javascript"></script>
    </body>
</html>
