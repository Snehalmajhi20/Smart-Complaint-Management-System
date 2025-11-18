package com.scms.controller;

import java.io.IOException;

import com.scms.dao.ComplaintDAO;
import com.scms.model.Complaint;
import com.scms.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addComplaint")
public class AddComplaintServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
    HttpSession s=req.getSession(false);
    if(s==null || s.getAttribute("user")==null){ resp.sendRedirect("login.jsp"); return; }
    User u=(User)s.getAttribute("user");
    String category=req.getParameter("category"), description=req.getParameter("description");
    Complaint c=new Complaint(u.getId(),category,description);
    boolean ok=new ComplaintDAO().addComplaint(c);
    if(ok) resp.sendRedirect("myComplaints");
    else resp.sendRedirect("addcomplaint.jsp?msg=error");
  }
}
