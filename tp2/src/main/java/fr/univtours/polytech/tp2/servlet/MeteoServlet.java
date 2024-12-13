package fr.univtours.polytech.tp2.servlet;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.tp2.business.TestBusiness;
import fr.univtours.polytech.tp2.model.TestBean;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "meteoServlet", urlPatterns ={"/meteo"})
public class MeteoServlet extends HttpServlet {

    @Inject
    private TestBusiness business;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<TestBean> list = this.business.getTests(false, null);

        request.setAttribute("FILM_LIST", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("film.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        if ("increase".equals(action)) {
            this.business.updateNote(id, true);
        } else if ("decrease".equals(action)) {
            this.business.updateNote(id, false);
        }

        response.sendRedirect("meteo");
    }
}
