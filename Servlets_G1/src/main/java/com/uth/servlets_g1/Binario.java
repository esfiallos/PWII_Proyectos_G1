package com.uth.servlets_g1;

//Importaciones necesarias
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Stack;

import static java.lang.System.out;

@WebServlet(name = "binario", value = "/binario")
public class Binario extends HttpServlet {

    public void init() {}
    public void destroy() {}

    public int conversorBinario_Decimal(String binario) {
        int decimal = 0;
        int l = 1;

        for (int i = binario.length() - 1; i >= 0; i--) {
            int digito = binario.charAt(i) - '0';
            decimal += digito * l;
            l *= 2;
        }
        return decimal;
    }

    public String conversorDecimal_Binario(int decimal) {
        String binario = "";
        Stack<String> orden= new Stack<>();

        while(decimal>=1) {
            orden.push( String.valueOf(decimal % 2) );
            decimal = decimal / 2;
        }

        while (!orden.isEmpty()) {
            binario += orden.pop();
        }

        return binario;
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException {
        String operacion = request.getParameter("operacion");
        String numero_extraido = request.getParameter("numero");


        String resultado = "";
        try {

            if(operacion.equals("B1")) {
                resultado = String.valueOf(conversorBinario_Decimal(numero_extraido));
                request.setAttribute("ejercicio", "Binacio a Decimal");
            }

            if(operacion.equals("B2")) {
                int numero = Integer.parseInt(numero_extraido);
                resultado = conversorDecimal_Binario(numero);
                 request.setAttribute("ejercicio", "Decimal a Binario");
            }

            request.setAttribute("entrada", numero_extraido);
            request.setAttribute("result", resultado);
            request.getRequestDispatcher("final.jsp").forward(request, response);

        } catch (ServletException | IOException e) {
            out.println("<h1>Error: No se pudo realizar el proceso</h1>");
        }

    }


}
