package com.scms.controller;

import java.io.IOException;
import java.util.List;

import com.scms.dao.ComplaintDAO;
import com.scms.dao.DepartmentDAO;
import com.scms.model.Complaint;
import com.scms.model.Department;
import com.scms.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
    HttpSession s=req.getSession(false);
    if(s==null||s.getAttribute("user")==null){ resp.sendRedirect("login.jsp"); return; }
    User u=(User)s.getAttribute("user");
    if(!"admin".equals(u.getRole())){ resp.sendRedirect("myComplaints"); return; }
    req.setAttribute("complaints", new ComplaintDAO().getAllComplaints());
    req.setAttribute("departments", new DepartmentDAO().getAllDepartments());
    req.getRequestDispatcher("admindashboard.jsp").forward(req,resp);
  }
}