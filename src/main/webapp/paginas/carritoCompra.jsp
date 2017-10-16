<%@page import="es.albarregas.models.Libro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title name="titulo">Tienda on-line</title>

    </head>
    <body>
        <table >
            <tr >
                <td colspan="2"><h1>Libros On-Line</h1></td>
                <td>
                    <img src="../resources/carrito.png" alt="Libros on-line" width="100">
                </td>
                <%
                    ArrayList<Libro> cesta = (ArrayList<Libro>) session.getAttribute("cesta");
                    if (cesta.isEmpty()) {%>
                <td colspan="3"><label>No ha seleccionado ningún producto.</label></td>
                        <%} else {%>
                <td colspan="3"><label>Este es el detalle de su pedido:</label></td>
                <td colspan="3">
                    <table>
                        <tr style="align-content: center">
                        <strong>
                            <td>Cantidad</td>
                            <td>Título</td>
                        </strong>
            </tr>
            <%
                for (int i = 0; i < cesta.size(); i++) {
            %>
            <tr style="align-content: center">
                <% Libro libro = cesta.get(i);%>
                        <td><%=libro.getCantidad()%></td>
                <td><%=libro.getTitulo()%></td>
            </tr>
        </option>
        <% }%>


        <td>
            </tr>
    </table>
</td>
<%}%>
%>
</tr>
</table>
</body>
</html>
