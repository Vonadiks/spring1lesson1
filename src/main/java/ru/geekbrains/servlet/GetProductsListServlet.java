package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetProductsListServlet", urlPatterns = "/get_products_list")
public class GetProductsListServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(BasicServlet.class);
    private List<Product> productsList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().printf("<html><body>");
        for (Product p : productsList) {
            resp.getWriter().printf("<h3>" + p.toString() + "</h3>");
        }
        resp.getWriter().printf("</body></html>");
    }

    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    public void init() throws ServletException {
        productsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productsList.add(new Product(i, "Product" + i, BigDecimal.valueOf(Math.random() * 10).setScale(2, BigDecimal.ROUND_HALF_UP)));
        }
    }
}
