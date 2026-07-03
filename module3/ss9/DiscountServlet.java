package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/display-discount")
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String description = request.getParameter("description");

        double price = Double.parseDouble(request.getParameter("price"));

        double percent = Double.parseDouble(request.getParameter("percent"));

        double discountAmount = price * percent * 0.01;

        double discountPrice = price - discountAmount;

        request.setAttribute("description", description);
        request.setAttribute("price", price);
        request.setAttribute("percent", percent);
        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("discountPrice", discountPrice);

        request.getRequestDispatcher("result.jsp")
                .forward(request, response);
    }
}