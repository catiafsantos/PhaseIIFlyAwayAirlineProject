package com.db;

import com.model.Place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceDB {

    public boolean addPlace(Place place) {
        String sql = "insert into place (country, city, airportName) values(?,?,?)";
        Connection con = MySQLConnection.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, place.getCountry());
            statement.setString(1, place.getCity());
            statement.setString(1, place.getAirportName());
            statement.execute();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deletePlace(int plid)
    {
        String sql = "delete from place where plid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, plid);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updatePlace(Place place)
    {
        String sql = "update place set country, city, airportName = ?,?,? where plid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, place.getPlid());
            statement.setString(2, place.getCountry());
            statement.setString(3, place.getCity());
            statement.setString(4, place.getAirportName());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
        return true;
    }

    public List<Place> getAllPlaces()
    {
        List<Place> places = new ArrayList<Place>();
        Connection con = MySQLConnection.getConnection();
        String sql = "select ª from place";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Place place = new Place();
                place.setPlid(rs.getInt(1));
                place.setCountry(rs.getString(2));
                place.setCity(rs.getString(3));
                place.setAirportName(rs.getString(4));
                places.add(place);
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
        return places;

    }

    public Place getPlaceById(int plid)
    {
        Connection con = MySQLConnection.getConnection();
        String sql = "select * from place where plid=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, plid);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                Place place = new Place();
                place.setPlid(rs.getInt(1));
                place.setCountry(rs.getString(2));
                place.setCity(rs.getString(3));
                place.setAirportName(rs.getString(4));

                return place;
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
