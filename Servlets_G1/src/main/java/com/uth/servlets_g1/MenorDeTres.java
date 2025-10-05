package com.uth.servlets_g1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    try {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int num3 = Integer.parseInt(request.getParameter("num3"));

        int menor = num1;
        if (num2 < menor) menor = num2;
        if (num3 < menor) menor = num3;

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background: linear-gradient(135deg, #4facfe, #00f2fe); height:100vh; display:flex; justify-content:center; align-items:center; margin:0; }");
        out.println(".result { background:#fff; padding:30px; border-radius:15px; text-align:center; box-shadow:0 4px 15px rgba(0,0,0,0.2); width:320px; }");
        out.println("h2 { color:#333; }");
        out.println("p { font-size:18px; margin:10px 0; }");
        out.println(".highlight { font-size:22px; font-weight:bold; color:#4facfe; }");
        out.println("a { display:inline-block; margin-top:20px; padding:10px 20px; background:#4facfe; color:white; text-decoration:none; border-radius:8px; transition:background 0.3s; }");
        out.println("a:hover { background:#00c6ff; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='result'>");
        out.println("<h2>Resultado del cálculo</h2>");
        out.println("<p>Número 1: " + num1 + "</p>");
        out.println("<p>Número 2: " + num2 + "</p>");
        out.println("<p>Número 3: " + num3 + "</p>");
        out.println("<p class='highlight'>El menor número es: " + menor + "</p>");
        out.println("<a href='index.html'>Volver</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    } catch (NumberFormatException e) {
        out.println("<p>Error: Ingrese solo números válidos.</p>");
    }
    }
}