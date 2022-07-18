<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/principalcss.css" rel="stylesheet" type="text/css"/>
        <link  rel="shortcut icon"   href="imgs/icono.jpg" type="image/png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Sistema Almacen | Menu</title>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light" style="background-color:#26A07B">           
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <img src="imgs/tienda.png" alt="65" width="65"/>                   
                    <li class="nav-item">
                        <a class="btn btn-outline-light" href="ControladorProducto?menu=Producto&accion=Listar" target="myFrame">Productos</a>
                    </li>
                    
                    <li  class="nav-item">
                        <a class="btn btn-outline-light" href="ControladorProveedor?menu=Proveedor&accion=Listar" target="myFrame">Proveedores</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="btn btn-outline-light" href="ControladorEmpleado?menu=Empleado&accion=Listar" target="myFrame">Colaboradores Autorizados</a>
                    </li>
                   
                    <li  class="nav-item">
                        <a  class="btn btn-outline-light" href="ControladorRegistro?menu=Registro&accion=Listar" target="myFrame">Pedidos</a>
                    </li>
                    <li class="nav-item">
                        <a  class="btn btn-outline-light" href="ControladorUbicacion?menu=Ubicacion&accion=Listar" target="myFrame">Ubicación</a>
                    </li>
                    <li class="nav-item">
                        <a  class="btn btn-outline-light" href="Reporte.jsp" target="myFrame">Reportes</a>
                    </li>
                   <li class="nav-item">
                        <a  class="btn btn-outline-light" href="ControladorPedido?menu=NuevoPedido&accion=default" target="myFrame">Generar Pedido</a>
                    </li>

                </ul>                
            </div>
            <div class="dropdown">
                <button  class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getNom()}
                </button>
                <div class="dropdown-menu dropdown-menu-right text-center">

                    <a class="dropdown-item" href="#">
                        <img src="imgs/user1.jpg" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                    <a class="dropdown-item" href="#">${area.getArea()}</a>
                    <a class="dropdown-item" href="#">${cargo.getCargo()}</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Validar?accion=Salir">Salir</a>
                </div>
            </div>
        </nav>
       </header>
        <br/>
        <div class="embed-responsives m-4" style="height: 800px;">
             <iframe class="embed-responsive-item" name="myFrame"  style="height: 100%; width: 100%; border: none; "></iframe>
        </div>   
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
