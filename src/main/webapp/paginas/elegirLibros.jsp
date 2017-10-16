<%-- 
    Document   : elegirLibros
    Created on : 15-oct-2017, 19:18:52
    Author     : tomlu
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title name="titulo">Tienda on-line</title>

    </head>
    <body>
        <form method="post" action="../ElegirLibros">
            <table >
                <tr >
                    <td colspan="2"><h1>Libros On-Line</h1></td>
                    <td>
                        <img src="../resources/carrito.png" alt="Libros on-line" width="100">
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <%
                            String mensaje = "";
                            String color = "black";
                            if (session.getAttribute("mensaje") != null) {
                                mensaje = (String) session.getAttribute("mensaje");
                                if (session.getAttribute("error") != null && (Boolean) session.getAttribute("error")) {
                                    color = "red";
                                }
                            }
                        %>
                        <label style="color: <%= color%>">

                            <%= mensaje%>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><label>Seleccione un libro</label></td>
                </tr>
                <tr>
                    <td colspan="3"> 
                        <%
                            ArrayList listaLibros = new ArrayList();
                            int size = 1;
                            if (request.getSession().getAttribute("libros") != null) {
                                listaLibros = (ArrayList) request.getSession().getAttribute("libros");
                                size = listaLibros.size() > 10 ? 10 : listaLibros.size();
                            }
                        %>    
                        <select name="libro" id="libro" size="<%=size%>">
                            <%
                                for (int i = 0; i < listaLibros.size(); i++) {%>
                                    <option value="<%=listaLibros.get(i)%>">
                                <%=listaLibros.get(i)%>
                            </option>
                            <% }%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><label>Cantidad: </label><input name="cantidad"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="accion" value="Añadir a la cesta" /></td>
                    <td><input type="submit" name="accion" value="Limpiar" /></td>
                    <td><input type="submit" name="accion" value="Finalizar compra" /></td>
                </tr>
            </table>

        </form>
    </body>
</html>
