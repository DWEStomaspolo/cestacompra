/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas;

import es.albarregas.models.Libro;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tomlu
 */
@WebServlet(name = "ElegirLibros", urlPatterns = {"/ElegirLibros"})
public class ElegirLibrosAction extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("libros", crearListaLibros());
        request.getSession().setAttribute("mensaje", null);
        request.getSession().setAttribute("cesta", new ArrayList<>());
        response.sendRedirect("paginas/elegirLibros.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("libros", crearListaLibros());
        String accion = request.getParameter("accion");
        if (accion.contains("cesta")) {
            String titulo = request.getParameter("libro");
            String cantidad = request.getParameter("cantidad");
            String mensaje = "";
            Boolean error = false;
            if (titulo == null) {
                mensaje = "Seleccione un libro por favor ...";
                error = true;
            } else {
                if (cantidad == null) {
                    cantidad = "1";
                }
                try {
                    int cantInt = new Integer(cantidad);
                    if (cantInt < 1) {
                        mensaje = "La cantidad de entrada no puede ser 0 o negativo";
                        error = true;
                    } else {
                        mensaje = "Añadido a la cesta " + cantidad + " unidades del libro " + titulo;
                        ArrayList<Libro> cesta = (ArrayList<Libro>) request.getSession().getAttribute("cesta");
                        Libro nuevo = new Libro(cantInt, titulo);
                        Libro existe = null;
                        for (Libro libro : cesta) {
                            if (libro.getTitulo().equals(nuevo.getTitulo())) {
                                existe = libro;
                                nuevo.setCantidad(nuevo.getCantidad() + libro.getCantidad());
                                break;
                            }
                        }
                        if (existe != null) {
                            cesta.remove(existe);
                        }
                        cesta.add(nuevo);
                    }
                } catch (NumberFormatException nFEx) {
                    mensaje = "La cantidad de entrada no es un número válido";
                    error = true;
                }

            }
            request.getSession().setAttribute("error", error);
            request.getSession().setAttribute("mensaje", mensaje);

            response.sendRedirect("paginas/elegirLibros.jsp");
        } else if (accion.contains("Limpiar")) {
            request.getSession().setAttribute("libros", crearListaLibros());
            request.getSession().setAttribute("mensaje", null);
            request.getSession().setAttribute("cesta", new ArrayList<>());
            response.sendRedirect("paginas/elegirLibros.jsp");
        } else {
            response.sendRedirect("paginas/carritoCompra.jsp");
        }
    }

    private ArrayList<String> crearListaLibros() {
        ArrayList<String> libros = new ArrayList<>();
        libros.add("LA MUERTE LLEGA A PEMBERLEY");
        libros.add("LA CONJURA DE CORTES");
        libros.add("BUENOS DIAS, PRINCESA");
        libros.add("EMOCIONES TOXICAS");
        libros.add("JUEGO DE TRONOS");
        libros.add("LA ORDEN DEL TEMPLE");
        libros.add("OTRO MAS QUE MUERDE EL POLVO");
        return libros;
    }
}
