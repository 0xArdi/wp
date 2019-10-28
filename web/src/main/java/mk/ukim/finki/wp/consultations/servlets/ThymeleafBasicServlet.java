package mk.ukim.finki.wp.consultations.servlets;

import org.springframework.context.ApplicationContext;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "thymeleaf", urlPatterns = "*.html")
public class ThymeleafBasicServlet extends HttpServlet {

    private SpringTemplateEngine springTemplateEngine;
    private WebContext webContext;

    public ThymeleafBasicServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        this.webContext = new WebContext(request, response, request.getServletContext());
        this.webContext.setVariable("recipient", session.getAttribute("username"));
        this.webContext.setVariable("ipaddress",request.getRemoteHost());
        this.springTemplateEngine.process("thymeleaf-index.html", this.webContext, response.getWriter());
    }



}
