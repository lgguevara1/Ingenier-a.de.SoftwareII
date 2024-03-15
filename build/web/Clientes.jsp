<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>Hello, world!</title>
    </head>
    <body>
        <div class="row">
            <div class="card col-md-4">
                <div class="card-body">
                    <h5 class="card-title">Clientes</h5>
                    <h6 class="card-subtitle mb-2 text-muted">En este panel podrás gestionar los datos de los clientes del sistema</h6>
                    <div>
                        <form action="Controlador?menu=Clientes" method="POST">
                            <div class="form-group">
                                <label>DNI</label>
                                <input type="number" class="form-control" name="txtdocumento" value="${clienteSeleccionado.getDni()}">
                                <small class="form-text text-muted">Ingrese el número de DNI sin espacios ni caracteres especiales</small>
                            </div>
                            <div class="form-group">
                                <label>Nombres</label>
                                <input type="text" class="form-control" name="txtnombres" value="${clienteSeleccionado.getNombres()}">
                            </div>
                            <div class="form-group">
                                <label>Dirección</label>
                                <input type="text" class="form-control" name="txtdireccion" value="${clienteSeleccionado.getDireccion()}">
                            </div>
                            <div class="form-group">
                                <label>Estado</label>
                                <select class="form-control form-control-sm" name="txtestado">
                                    <option>Activo</option>
                                    <option>Inactivo</option>
                                </select>
                            </div>

                            <input type="submit" class="btn btn-primary" name="accion" value="Agregar" >
                            <input type="submit" class="btn btn-success" name="accion" value="Actualizar" >
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">idCliente</th>
                            <th scope="col">DNI</th>
                            <th scope="col">Nombres</th>
                            <th scope="col">Dirección</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${clientes}">

                            <tr>
                                <th scope="row">${cliente.getIdCliente()}</th>
                                <td>${cliente.getDni()}</td>
                                <td>${cliente.getNombres()}</td>
                                <td>${cliente.getDireccion()}</td>
                                <td>${cliente.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Clientes&accion=Cargar&id=${cliente.getIdCliente()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Clientes&accion=Eliminar&id=${cliente.getIdCliente()}">Eliminar</a>
                                </td>

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>

            <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
