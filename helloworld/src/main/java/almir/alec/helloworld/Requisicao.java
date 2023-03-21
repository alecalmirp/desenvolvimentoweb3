package almir.alec.helloworld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Requisicao", value = "/Requisicao")
public class Requisicao extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String method     = req.getMethod();
        String requestURI = req.getRequestURI();
        String protocol   = req.getProtocol();
        String remoteAddr = req.getRemoteAddr();


        PrintWriter out = resp.getWriter();

        out.println(method);
        out.println(requestURI);
        out.println(protocol);
        out.println(remoteAddr);
    }

    public void destroy() {
    }
}