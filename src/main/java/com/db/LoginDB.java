package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Login;

public class LoginDB {

    public String validateUser(Login user)
    {
        Connection con = MySQLConnection.getConnection();

        String sql = "select password, role from Login where email = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                if(rs.getString(1).equals(user.getPassword()))
                    return rs.getString(2);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

}
