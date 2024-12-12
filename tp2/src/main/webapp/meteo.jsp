<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html lang="fr">

        <head>
            <meta charset="UTF-8">
            <title>Météo</title>
        </head>

        <body>
            <h1>Météo</h1>
            <c:if test="${not empty meteo}">
                <h2>Meteo de Tours</h2>
                <p>${meteo}</p>
            </c:if>
        </body>

        </html>