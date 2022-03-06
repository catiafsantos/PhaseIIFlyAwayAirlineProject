package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Airline;
import com.model.Flight;
import com.model.Place;

public class FlightDB {

    public boolean addFlight(Flight flight)
    {
        String sql = "insert into flight(source,destination,date,price, airline, seats,) values(?,?,?,?,?,?)";
        Connection con = MySQLConnection.getConnection();
        try {
            con.setAutoCommit(false);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, flight.getFid());
            statement.setObject(2, flight.getSource());
            statement.setObject(3, flight.getDestination());
            statement.setDate(4, flight.getDate());
            statement.setDouble(5, flight.getPrice());
            statement.setObject(6, flight.getAid());
            statement.setInt(7, flight.getSeats());
            statement.execute();
            con.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public boolean deleteFlight(int fid)
    {
        String sql = "delete from flight where fid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, fid);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateFlight(Flight flight)
    {
        String sql = "update flight set source = ?, destination = ?, date=?, price=?, aid=?, seats=? where fid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, flight.getFid());
            statement.setObject(2, flight.getSource());
            statement.setObject(3, flight.getDestination());
            statement.setDate(4, flight.getDate());
            statement.setDouble(5, flight.getPrice());
            statement.setObject(6, flight.getAid());
            statement.setInt(7, flight.getSeats());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
        return true;
    }

    public List<Flight> getAllFlights()
    {
        List<Flight> flights = new ArrayList<Flight>();
        Connection con = MySQLConnection.getConnection();
        String sql = "select * from flight";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Flight flight = new Flight();
                flight.setFid(rs.getInt(1));
                flight.setSource((Place) rs.getObject(2));
                flight.setDestination((Place) rs.getObject(3));
                flight.setDate(rs.getDate(4));
                flight.setAid((Airline) rs.getObject(5));
                flight.setPrice(rs.getInt(6));
                flight.setSeats(rs.getInt(7));
                flights.add(flight);
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
        return flights;
    }

    public Flight getFlightById(int id)
    {

        Connection con = MySQLConnection.getConnection();
        String sql = "select * from flight where fid=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                Flight flight = new Flight();
                flight.setFid(rs.getInt(1));
                flight.setSource((Place) rs.getObject(2));
                flight.setDestination((Place) rs.getObject(3));
                flight.setDate(rs.getDate(4));
                flight.setAid((Airline) rs.getObject(5));
                flight.setPrice(rs.getInt(6));
                flight.setSeats(rs.getInt(7));
                return flight;
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
