package com.example.demo;

import entities.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "index6", value = "/index6")
public class CustomerManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("tam", LocalDate.now(),"khoong ai biet", "images/cc.jpg"));
        customers.add(new Customer("tam1", LocalDate.now(),"khoong ai biet", "images/cc.jpg"));
        customers.add(new Customer("tam2", LocalDate.now(),"khoong ai biet", "images/cc.jpg"));
        customers.add(new Customer("tam3", LocalDate.now(),"khoong ai biet", "images/cc.jpg"));

        request.setAttribute("customers", customers);

        request.getRequestDispatcher("/index6.jsp").forward(request,response);


    }
}
