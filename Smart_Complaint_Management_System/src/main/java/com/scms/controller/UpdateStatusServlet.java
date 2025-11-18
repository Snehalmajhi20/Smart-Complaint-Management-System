package com.scms.controller;

import java.io.IOException;

import com.scms.dao.ComplaintDAO; 
import com.scms.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
    HttpSession s=req.getSession(false);
    if(s==null||s.getAttribute("user")==null){ resp.sendRedirect("login.jsp"); return; }
    User u=(User)s.getAttribute("user"); if(!"admin".equals(u.getRole())){ resp.sendRedirect("myComplaints"); return; }
    int id=Integer.parseInt(req.getParameter("complaintId"));
    String status=req.getParameter("status"), assigned=req.getParameter("assignedTo");
    new ComplaintDAO().updateComplaintStatus(id,status,assigned);
    resp.sendRedirect("adminDashboard");
  }
}
