package com.sber_tech.controller;

import com.sber_tech.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/search-contact")
public class SearchContact extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactService contactService = new ContactService();
        HttpSession session = request.getSession();
        String arg = request.getParameter("searchArg");
        session.setAttribute("contactList", contactService.searchContact(arg));
        response.sendRedirect("index.jsp");

    }
}
