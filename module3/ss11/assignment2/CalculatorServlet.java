package com.assignment2.demo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "calculator" ,value = "/index")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double num1 = Double.parseDouble(req.getParameter("num1"));
        Double num2 =  Double.parseDouble(req.getParameter("num2"));
        String  operator = req.getParameter("operator");

        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num2 != 0 ? num1 / num2 : 0;
                break;
        }

        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);
        req.setAttribute("operator", operator);
        req.setAttribute("result", result);

        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}
