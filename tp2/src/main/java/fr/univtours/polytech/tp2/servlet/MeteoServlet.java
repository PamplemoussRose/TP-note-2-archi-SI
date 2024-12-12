package fr.univtours.polytech.tp2.servlet;

import java.io.IOException;

import fr.univtours.polytech.tp2.business.MeteoBusiness;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/meteo")
public class MeteoServlet extends HttpServlet {

    @Inject
    private MeteoBusiness meteoBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Coordonnées de Tours
        String lat = "47.383333";
        String lon = "0.683333";
        // JSON contenant les informations météo
        String meteo = this.meteoBusiness.getMeteo(lat, lon);
        // Ajout du JSON à la réponse
        request.setAttribute("meteo", meteo);
        // Redirection vers la page JSP
        request.getRequestDispatcher("meteo.jsp").forward(request, response);
        
    }

}
