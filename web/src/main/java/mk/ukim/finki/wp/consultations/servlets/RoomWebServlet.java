package mk.ukim.finki.wp.consultations.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="room-web-servlet",urlPatterns = "/servlet/room")
public class RoomWebServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ipAddress = req.getRemoteHost();
        String clientAgent = req.getHeader("User-Agent");
        PrintWriter writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<head>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>");
        writer.write("Hi "+clientAgent);
        writer.write("</h1>");
        writer.write("<div>");
        writer.write("Your IP address is:");
        writer.write(ipAddress);
        writer.write("</div>");
        writer.write("</body>");
        writer.write("</html>");


    }
}
