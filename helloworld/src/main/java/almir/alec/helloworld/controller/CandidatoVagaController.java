package almir.alec.helloworld.controller;

import almir.alec.helloworld.model.CandidatoVaga;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("candidato_vaga")
public class CandidatoVagaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CandidatoVaga candidato=new CandidatoVaga();
        candidato.setNome(request.getParameter("field_nome"));
        candidato.setDataNascimento(request.getParameter("field_data_nascimento"));
        candidato.setIdioma(request.getParameter("field_idioma"));
        candidato.setHabilidades(request.getParameterValues("field_habilidades"));

        request.setAttribute("attr_candidato_vaga",candidato);

        //3- encaminhar essas informacoes para quem melhor sabe o que fazer com ela
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("tela_confirmacao.jsp");

        requestDispatcher.forward(request,response);
    }
}
