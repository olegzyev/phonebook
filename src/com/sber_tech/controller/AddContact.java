package com.sber_tech.controller;

import com.sber_tech.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add-contact")
public class AddContact extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String number = request.getParameter("number");
        ContactService contactService = new ContactService();
        contactService.addContact(fullname, address, number);
        HttpSession session = request.getSession();
        session.setAttribute("contactList", contactService.getAllContacts());
        response.sendRedirect("index.jsp");

    }

}
