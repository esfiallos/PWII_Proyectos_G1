package com.uth.servlets_g1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "MenorDeTres", value = "/MenorDeTres")
public class MenorDeTres extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    try {
        // === ENTRADAS ===
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int num3 = Integer.parseInt(request.getParameter("num3"));

        // Operación seleccionada (menor | mayor | repetido). Por defecto "menor"
        String op = request.getParameter("op");
        if (op == null || op.isBlank()) op = "menor";

        // === CÁLCULOS ===
        // Menor (lo que ya tenían)
        int menor = num1;
        if (num2 < menor) menor = num2;
        if (num3 < menor) menor = num3;

        // Mayor (nuevo)
        int mayor = num1;
        if (num2 > mayor) mayor = num2;
        if (num3 > mayor) mayor = num3;

        // Según operación, armamos descripción y resultado a mostrar
        String opDesc;
        int opResultado;

        if ("mayor".equalsIgnoreCase(op)) {
            opDesc = "El mayor número es";
            opResultado = mayor;
        } else if ("repetido".equalsIgnoreCase(op)) {
            opDesc = "El número que más se repite es";
            opResultado = masRepetido(num1, num2, num3);
        } else { // "menor" (default)
            opDesc = "El menor número es";
            opResultado = menor;
        }

        // === SALIDA HTML (se conserva el estilo de tu compañero) ===
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
        out.println("<h2>Nombre: Daniel de jesus Montoya Rodríguez</h2>");
        out.println("<h2>Cuenta: 202330060138</h2>");
        out.println("<h2>Nombre: Ingrid Lisbeth Garay Velasquez</h2>");
        out.println("<h2>Cuenta: 202310040339</h2>");
        out.println("<p>Número 1: " + num1 + "</p>");
        out.println("<p>Número 2: " + num2 + "</p>");
        out.println("<p>Número 3: " + num3 + "</p>");

        //  muestra el resultado según la operación elegida
        out.println("<p class='highlight'>" + opDesc + ": " + opResultado + "</p>");

        out.println("<a href='MenorDeTres.html'>Volver Ejercicio</a>");
        out.println("<a href='index.jsp'>Volver al Menu</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    } catch (NumberFormatException e) {
        out.println("<p>Error: Ingrese solo números válidos.</p>");
    }
}

    // ==== NUEVO: calcula el número más repetido entre tres ====
    private int masRepetido(int a, int b, int c) {
        int[] nums = {a, b, c};
        int mejor = nums[0], max = 0;
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) if (nums[i] == nums[j]) cnt++;
            if (cnt > max) {
                max = cnt;
                mejor = nums[i]; // si hay empate, se queda el primero que alcanzó el máximo
            }
        }
        return mejor;
    }
}