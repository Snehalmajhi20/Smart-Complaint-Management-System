package com.scms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.scms.model.User;
import com.scms.util.DB_Connection;

public class UserDAO {
    public boolean registerUser(User user){
    	
        String sql="INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)";
        
        try(Connection con=DB_Connection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getRole());
            return ps.executeUpdate()>0;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	}
        return false;
    }

    public User loginUser(String email,String password){
    	
        String sql="SELECT * FROM users WHERE email=? AND password=?";
        
        try(Connection con=DB_Connection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql))
        {
            ps.setString(1,email); ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                User u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                return u;
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	}
        return null;
    }
}