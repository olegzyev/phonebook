package com.sber_tech.controller;

import com.sber_tech.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(description = "/", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactService contactService = new ContactService();
        HttpSession session = request.getSession();
        session.setAttribute("contactList", contactService.getAllContacts());
        response.sendRedirect("index.jsp");

    }

}
