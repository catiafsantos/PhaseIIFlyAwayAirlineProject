package com.db;

import com.model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDB {

    public boolean addPayment(Payment payment)
    {
        String sql = "insert into payment (method, paymentDetails) values(?,?)";
        Connection con = MySQLConnection.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, payment.getMethod());
            statement.setString(2, payment.getPaymentDetails());
            statement.execute();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deletePayment(int pid)
    {
        String sql = "delete from payment where pid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, pid);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updatePayment(Payment payment)
    {
        String sql = "update payment set method = ?, paymentDetails = ? where pid=?";
        Connection con = MySQLConnection.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, payment.getPid());
            statement.setString(2, payment.getMethod());
            statement.setString(3, payment.getPaymentDetails());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
        return true;
    }

    public List<Payment> getAllPayments()
    {
        List<Payment> payments = new ArrayList<Payment>();
        Connection con = MySQLConnection.getConnection();
        String sql = "select ª from payment";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Payment payment = new Payment();
                payment.setPid(rs.getInt(1));
                payment.setMethod(rs.getString(2));
                payment.setPaymentDetails(rs.getString(3));
                payments.add(payment);
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
        return payments;

    }

    public Payment getPaymentById(int pid)
    {

        Connection con = MySQLConnection.getConnection();
        String sql = "select * from payment where pid=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, pid);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                Payment payment = new Payment();
                payment.setPid(rs.getInt(1));
                payment.setMethod(rs.getString(2));
                payment.setPaymentDetails(rs.getString(2));
                return payment;
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
