package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ProductDTO;
import services.LoginService;
import services.ProductService;
import services.impl.LoginServiceImpl;
import services.impl.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service = new ProductServiceImpl();
        List<ProductDTO> products = service.getProducts();

        LoginService loginService = new LoginServiceImpl();
        Optional<String> cookieOptional = loginService.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head");
            out.println("       <meta charset=\"UTF-8\">");
            out.println("       <title>Listado de productos</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Listado de productos</h1>");
            cookieOptional.ifPresent(s ->
                    out.println("       <div>Hola " + s + " Bienvenido</div>")
            );
            out.println("       <table>");
            out.println("       <tr>");
            out.println("       <th>id</th>");
            out.println("       <th>nombre</th>");
            if (cookieOptional.isPresent()) {
                out.println("       <th>precio</th>");
            }
            out.println("       </tr>");

            products.forEach(p -> {
                out.println("       <tr>");
                out.println("       <td>" + p.getId() +"</td>");
                out.println("       <td>" + p.getName() +"</td>");
                if (cookieOptional.isPresent()) {
                    out.println("       <td>" + p.getPrice() + "</td>");
                }
                out.println("       </tr>");
            });

            out.println("       </table>");
            out.println("   </body>");
            out.println("</html>");
        }

    }
}
