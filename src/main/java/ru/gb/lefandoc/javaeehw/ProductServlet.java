package ru.gb.lefandoc.javaeehw;

import ru.gb.lefandoc.javaeehw.model.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ru.gb.lefandoc.javaeehw.utils.ProductGen.fillProducts;

@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet {

    private static final int PRODUCTS_AMOUNT = 10;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // если убрать в init(), то список не будет меняться при нажатии на кнопку
        List<Product> products = new ArrayList<>();
        fillProducts(products, PRODUCTS_AMOUNT);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<style>" +
                "* {" +
                "text-align: left;" +
                "margin: 20px;" +
                "margin-left: 160px" +
                "}" +
                "</style>");
        out.println("<h1>" + "Product list" + "</h1>");
        out.println("<h3>" +
                products.stream()
                        .map(Product::toString)
                        .collect(Collectors.joining("<br><br>")) +
                "</h3>");
        out.println("<button onclick=\"myFunction()\">Get new products list</button>");
        out.println("<a href=\"javascript:history.back()\">Go back to main page</a>");
        out.println(
                "<script type=\"text/javascript\">" +
                        "function myFunction() {" +
                        "location.reload()" + //перезагрузка страницы в следствии чего обновление списка
                        "}" +
                        "</script>"
        );
    }

}
