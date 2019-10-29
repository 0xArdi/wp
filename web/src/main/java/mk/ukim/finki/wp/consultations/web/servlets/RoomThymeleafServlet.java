package mk.ukim.finki.wp.consultations.web.servlets;

import mk.ukim.finki.wp.consultations.model.Room;
import mk.ukim.finki.wp.consultations.service.RoomService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/rooms")
public class RoomThymeleafServlet extends HttpServlet {

    private RoomService roomService;
    private SpringTemplateEngine springTemplateEngine;
    private WebContext webContext;

    public RoomThymeleafServlet(SpringTemplateEngine springTemplateEngine, RoomService roomService) {
        this.springTemplateEngine = springTemplateEngine;
        this.roomService = roomService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.webContext = new WebContext(req,resp,req.getServletContext());
        List<Room> rooms = roomService.getAllRooms();
        this.webContext.setVariable("rooms",rooms);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("rooms.html", this.webContext, resp.getWriter());
    }
}
