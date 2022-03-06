package com.db;

import com.model.Airline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlineDB {

    public boolean addAirline(Airline airline)
    {
        String sql = "insert into airline (airline) values(?)";
        Connection con = MySQLConnection.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, airline.getAirline());
            statement.execute();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteAirline(int aid)
    {
        String sql = "delete from airline where aid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, aid);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateAirline(Airline airline)
    {
        String sql = "update airline set airline = ? where aid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, airline.getAid());
            statement.setString(2, airline.getAirline());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
        return true;
    }

    public List<Airline> getAllAirlines()
    {
        List<Airline> airlines = new ArrayList<Airline>();
        Connection con = MySQLConnection.getConnection();
        String sql = "select ª from airline";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Airline airline = new Airline();
                airline.setAid(rs.getInt(1));
                airline.setAirline(rs.getString(2));
                airlines.add(airline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return airlines;

    }

    public Airline getAirlineById(int aid)
    {

        Connection con = MySQLConnection.getConnection();
        String sql = "select * from airline where aid=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, aid);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                Airline airline = new Airline();
                airline.setAid(rs.getInt(1));
                airline.setAirline(rs.getString(2));
                return airline;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

}
