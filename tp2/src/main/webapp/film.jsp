<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Les films</title>
            <link rel="stylesheet" href="styles.css">
        </head>

        <body>
            <section>
                <h1>Liste des films</h1>
                <table border=1>
                    <tr style="background-color: lightgray;">
                        <th>Titre</th>
                        <th>Note</th>
                        <th>Acteur</th>
                        <th>Affiche</th>
                        <th>Sortie</th>
                    </tr>
                    <c:forEach items="${requestScope.FILM_LIST}" var="film">
                        <tr>
                            <td>${film.title}</td>
                            <td>${film.note}</td>
                            <td>${film.acteur}</td>
                            <td>${film.image}</td>
                            <td>${film.sortie}</td>
                        </tr>
                    </c:forEach>
                </table>
            </section>
        </body>
        </html>