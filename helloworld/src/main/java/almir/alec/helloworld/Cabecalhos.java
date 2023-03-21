package almir.alec.helloworld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cabecalhos", value = "/Cabecalhos")
public class Cabecalhos extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRemoteHost();
        req.getRemoteUser();
        

        PrintWriter out = resp.getWriter();

        out.println(method);
        out.println(requestURI);
        out.println(protocol);
        out.println(remoteAddr);
    }

    public void destroy() {
    }
}