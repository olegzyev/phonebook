package com.sber_tech.controller;

import com.sber_tech.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/update-contact")
public class UpdateContact extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactService contactService = new ContactService();
        HttpSession session = request.getSession();
        session.setAttribute("contactById", contactService.getContactById(request.getParameter("id")));
        response.sendRedirect("index.jsp?update=true");

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactService contactService = new ContactService();
        String id = request.getParameter("id");
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String number = request.getParameter("number");
        contactService.updateContact(id, fullname, address, number);
        response.sendRedirect("home");
    }

}
