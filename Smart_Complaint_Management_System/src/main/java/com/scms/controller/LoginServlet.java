package com.scms.controller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import com.scms.dao.UserDAO;
import com.scms.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; 

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
    String email=req.getParameter("email"); String password=req.getParameter("password");
    UserDAO dao=new UserDAO(); User user=dao.loginUser(email,password);
    if(user!=null){
      HttpSession session=req.getSession(); session.setAttribute("user",user);
      if("admin".equals(user.getRole())) resp.sendRedirect("adminDashboard");
      else resp.sendRedirect("myComplaints");
    }else{
      req.setAttribute("error","Invalid credentials"); req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
  }
}