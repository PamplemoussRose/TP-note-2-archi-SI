<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Les films</title>
            <link rel="stylesheet" href="styles.css">
            <style>
                .hidden {
                    display: none;
                }
            </style>
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
                            <td>${film.acteur}</td>
                            <td><img src="${film.image}" alt="Image du film" style="width: 100px; height: auto;" /></td>
                            <td>${film.sortie}</td>
                            <td>${film.note}</td>
                            <td class="hidden">${film.id}</td>
                        </tr>
                    </c:forEach>
                </table>
            </section>
        </body>

        </html>