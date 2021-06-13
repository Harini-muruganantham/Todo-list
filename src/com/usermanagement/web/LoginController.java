package com.usermanagement.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usermanagement.dao.LoginDao;
import com.usermanagment.bean.LoginBean;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        authenticate(request, response);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail(email);
        loginBean.setPassword(password);

        try {
            if (loginDao.validate(loginBean)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("todo-list.jsp");
                dispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
