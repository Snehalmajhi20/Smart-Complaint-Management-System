package com.scms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scms.model.Department;
import com.scms.util.DB_Connection;


public class DepartmentDAO {
	public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM departments ORDER BY name";
        try (Connection con = DB_Connection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Department d = new Department();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setEmail(rs.getString("email"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
