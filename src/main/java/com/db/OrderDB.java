package com.db;

import com.model.Customer;
import com.model.Flight;
import com.model.Order;
import com.model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDB {

    public boolean addOrder(Order order)
    {
        String sql = "insert into order (total_amount, total_seats, flight_id, payment_id, customer_id ) values(?,?,?,?,?)";
        Connection con = MySQLConnection.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDouble(1, order.getTotalAmount());
            statement.setInt(2, order.getTotalSeats());
            statement.setObject(3,order.getFid());
            statement.setObject(4,order.getCid());
            statement.setObject(5,order.getPid());
            statement.execute();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteOrder(int oid)
    {
        String sql = "delete from order where oid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, oid);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateOrder(Order order)
    {
        String sql = "update flight set source = ?, destination = ?, date=?, price=?, aid=?, seats=? where fid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDouble(1, order.getTotalAmount());
            statement.setInt(2, order.getTotalSeats());
            statement.setObject(3,order.getFid());
            statement.setObject(4,order.getCid());
            statement.setObject(5,order.getPid());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
        return true;
    }

    public List<Order> getAllOrders()
    {
        List<Order> orders = new ArrayList<Order>();
        Connection con = MySQLConnection.getConnection();
        String sql = "select * from order";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Order order = new Order();
                order.setOid(rs.getInt(1));
                order.setTotalAmount(rs.getDouble(2));
                order.setTotalSeats(rs.getInt(3));
                order.setFid((Flight) rs.getObject(4));
                order.setCid((Customer) rs.getObject(5));
                order.setPid((Payment) rs.getObject(6));
                orders.add(order);
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
        return orders;
    }

    public Order getOrderById(int oid)
    {

        Connection con = MySQLConnection.getConnection();
        String sql = "select * from order where oid=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, oid);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                Order order = new Order();
                order.setOid(rs.getInt(1));
                order.setTotalAmount(rs.getDouble(2));
                order.setTotalSeats(rs.getInt(3));
                order.setFid((Flight) rs.getObject(4));
                order.setCid((Customer) rs.getObject(5));
                order.setPid((Payment) rs.getObject(6));
                return order;
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
