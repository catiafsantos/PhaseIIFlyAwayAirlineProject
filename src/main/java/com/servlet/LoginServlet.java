package com.servlet;

import com.db.LoginDB;
import com.model.Login;

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


    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginDB logindb = new LoginDB();
        String role = logindb.validateUser(new Login(email, password, null));
        if (role != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            if (role.equals("admin")) {
                response.sendRedirect("mainAdminPage.jsp");
            }
            else
            {
                response.sendRedirect("login.jsp?error=Invalid Credentials");
            }
        }
    }
}
