package com.sber_tech.controller;

import com.sber_tech.service.ContactService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-contact")
public class DeleteContact extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactService contactService = new ContactService();
        contactService.deleteContact(request.getParameter("id"));
        RequestDispatcher rd = request.getRequestDispatcher("home");
        rd.forward(request, response);

    }

}
