package com.uth.servlets_g1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Hipotenusa", value = "/Hipotenusa")
public class Hipotenusa extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        double a = Double.parseDouble(req.getParameter("a"));
        double b = Double.parseDouble(req.getParameter("b"));

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado C</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; text-align: center; background-color: #f3f3f3; padding: 40px; }");
        out.println("table { margin: 0 auto; border-collapse: collapse; width: 60%; background: white; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
        out.println("th, td { padding: 10px; border: 1px solid #ccc; }");
        out.println("th { background-color: #4CAF50; color: white; }");
        out.println("button { padding: 10px 20px; background-color: #2e8b57; color: white; border: none; border-radius: 6px; cursor: pointer; margin-top: 10px;}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Nombre: JONATHAN ORTIZ</h2>");
        out.println("<h2>Número de cuenta: 202210030176</h2>");
        out.println("<h3>SERVLET 3 - RESULTADOS</h3>");

        if (a < b) {
            out.println("<p style='color:red;'>Error: El cateto A debe ser mayor al cateto B</p>");
        } else {
            double c= Math.sqrt(Math.pow(a,2)-Math.pow(b,2));
            out.println("<table>");
            out.println("<tr><th>Operación</th><th>a</th><th>b</th><th>c</th></tr>");
            out.println("<tr>");
            out.println("<td>c = √(a² - b²)</td>");
            out.println("<td>" + a + "</td>");
            out.println("<td>" + b + "</td>");
            out.println("<td>" + String.format("%.2f", c) + "</td>");
            out.println("</tr>");
            out.println("</table>");
        }

        out.println("<br>");
        out.println("<br>");
        out.println("<form method='get' action='index.jsp'>");
        out.println("<button type='submit'>Volver al menu</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }

}
