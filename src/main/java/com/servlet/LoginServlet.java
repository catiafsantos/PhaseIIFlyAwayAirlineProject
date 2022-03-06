package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        if(email.equals("catia.santos3@vodafone.com") && pwd.equals("password"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("admin.jsp");
        }
        else {
            response.sendRedirect("login.jsp?error=Invalid Credentials");
        }
    }
}
