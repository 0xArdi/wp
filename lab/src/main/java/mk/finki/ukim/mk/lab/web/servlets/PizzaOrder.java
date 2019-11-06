package mk.finki.ukim.mk.lab.web.servlets;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/pizzaOrder")
public class PizzaOrder extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public PizzaOrder(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String size = req.getParameter("size");
        req.getSession().setAttribute("size", size);
        resp.sendRedirect("/pizzaOrder");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        this.springTemplateEngine.process("delivery-info.html", webContext, resp.getWriter());
    }
}
