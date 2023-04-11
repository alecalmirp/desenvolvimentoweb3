package almir.alec.helloworld;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("processa_vaga")
public class ProcessaVagaServlet extends HttpServlet {

    private DateTimeFormatter formatter;

    @Override
    public void init() throws ServletException {
        formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1-obter essas informacoes de uma submissao
        String fieldNome = request.getParameter("field_nome");



        System.out.println(fieldNome);

        String stringDate= request.getParameter("field_data_nascimento");

        LocalDate fieldDataNascimento = LocalDate.parse(stringDate, formatter);

        String fieldIdioma = request.getParameter("field_idioma");

        String[] fieldHabilidades = request.getParameterValues("field_habilidades");

        //2- adicionar essas informacoes a requisicao
        request.setAttribute("attr_nome",fieldNome);
        request.setAttribute("attr_data",fieldDataNascimento);
        request.setAttribute("attr_idioma",fieldIdioma);
        request.setAttribute("attr_habilidades",fieldHabilidades);

        if(fieldNome.equals("")){
            response.sendRedirect("http://localhost:8080/index.jsp?msg=campo nome esta em branco");
        }else{
            //3- encaminhar essas informacoes para quem melhor sabe o que fazer com ela
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("tela_confirmacao.jsp");

            requestDispatcher.forward(request,response);
        }


    }
}
