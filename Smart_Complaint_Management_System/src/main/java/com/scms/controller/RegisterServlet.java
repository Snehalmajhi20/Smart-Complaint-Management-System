package com.scms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.scms.dao.UserDAO;
import com.scms.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
    String name=req.getParameter("name");
    String email=req.getParameter("email");
    String password=req.getParameter("password");
    User u=new User(name,email,password,"user");
    UserDAO dao=new UserDAO();
    if(dao.registerUser(u)) resp.sendRedirect("login.jsp?msg=registered");
    else resp.sendRedirect("register.jsp?msg=error");
  }
}
