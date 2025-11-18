package com.scms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scms.model.Complaint;
import com.scms.util.DB_Connection;

public class ComplaintDAO {
    public boolean addComplaint(Complaint c){
        String sql="INSERT INTO complaints(user_id,category,description,status,assigned_to) VALUES(?,?,?,?,?)";
        try(Connection con=DB_Connection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,c.getUserId());
            ps.setString(2,c.getCategory());
            ps.setString(3,c.getDescription());
            ps.setString(4,c.getStatus());
            ps.setString(5,c.getAssignedTo());
            return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace();}
        return false;
    }

    public List<Complaint> getComplaintsByUserId(int userId){
        List<Complaint> list=new ArrayList<>();
        String sql="SELECT * FROM complaints WHERE user_id=? ORDER BY created_at DESC";
        try(Connection con=DB_Connection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,userId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) list.add(mapRow(rs));
        }catch(Exception e){e.printStackTrace();}
        return list;
    }

    public List<Complaint> getAllComplaints(){
        List<Complaint> list=new ArrayList<>();
        String sql="SELECT * FROM complaints ORDER BY created_at DESC";
        try(Connection con=DB_Connection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){
            while(rs.next()) list.add(mapRow(rs));
        }catch(Exception e){e.printStackTrace();}
        return list;
    }

    public boolean updateComplaintStatus(int id,String status,String assignedTo){
        String sql="UPDATE complaints SET status=?, assigned_to=? WHERE id=?";
        try(Connection con=DB_Connection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,status); ps.setString(2,assignedTo); ps.setInt(3,id);
            return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace();}
        return false;
    }

    private Complaint mapRow(ResultSet rs) throws SQLException {
        Complaint c=new Complaint();
        c.setId(rs.getInt("id"));
        c.setUserId(rs.getInt("user_id"));
        c.setCategory(rs.getString("category"));
        c.setDescription(rs.getString("description"));
        c.setStatus(rs.getString("status"));
        c.setAssignedTo(rs.getString("assigned_to"));
        c.setCreatedAt(rs.getTimestamp("created_at"));
        return c;
    }
}