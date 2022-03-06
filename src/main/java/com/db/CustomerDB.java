package com.db;

import com.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDB {
    public boolean addCustomer(Customer customer)
    {
        String sql = "insert into customer (cusName) values(?)";
        Connection con = MySQLConnection.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, customer.getCusName());
            statement.execute();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteCustomer(int cid)
    {
        String sql = "delete from customer where cid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, cid);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateCustomer(Customer customer)
    {
        String sql = "update customer set cusName = ? where cid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, customer.getCid());
            statement.setString(2, customer.getCusName());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
        return true;
    }

    public List<Customer> getAllCustomers()
    {
        List<Customer> customers = new ArrayList<Customer>();
        Connection con = MySQLConnection.getConnection();
        String sql = "select ª from customer";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Customer customer = new Customer();
                customer.setCid(rs.getInt(1));
                customer.setCusName(rs.getString(2));
                customers.add(customer);
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
        return customers;

    }

    public Customer getCustomerById(int cid)
    {

        Connection con = MySQLConnection.getConnection();
        String sql = "select * from customer where cid=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                Customer customer = new Customer();
                customer.setCid(rs.getInt(1));
                customer.setCusName(rs.getString(2));
                return customer;
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
