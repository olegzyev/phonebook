package com.sber_tech.service;

import com.sber_tech.dao.JDBCConnection;
import com.sber_tech.domain.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private JDBCConnection jdbcConnection;
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public ContactService() {
        jdbcConnection = new JDBCConnection();
    }

    public void addContact(String fullname, String address, String number) {
        try {
            Contact contact = new Contact(fullname, address, number);
            conn = jdbcConnection.getConnection();
            String sql = "INSERT INTO phonebook(fullname, address, number) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, contact.getFullname());
            pstmt.setString(2, contact.getAddress());
            pstmt.setString(3, contact.getNumber());
            System.out.println(contact);
            System.out.println("sql =" + sql);
            pstmt.executeUpdate();
            System.out.println("Inserted records into the table...");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public Map<Integer, Contact> getAllContacts() {
        try {
            Map<Integer, Contact> map = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM phonebook";
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact(rs.getString(2), rs.getString(3), rs.getString(4));
                map.put(rs.getInt(1), contact);
            }
            System.out.println(map);
            return map;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return null;
    }

    public Map<Integer, Contact> getContactById(String id) {
        try {
            Map<Integer, Contact> mapWithId = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM phonebook WHERE id = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact(rs.getString(2), rs.getString(3), rs.getString(4));
                mapWithId.put(Integer.parseInt(id), contact);
            }
            return mapWithId;

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return null;
    }

    public Map<Integer, Contact> searchContact(String arg) {
        try {
            Map<Integer, Contact> mapWithResult = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM phonebook WHERE id = ? OR fullname = ? OR phone = ? OR address = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setInt(1, Integer.parseInt(arg));
            pstmt.setString(2, arg);
            pstmt.setString(3, arg);
            pstmt.setString(4, arg);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact(rs.getString(2), rs.getString(3), rs.getString(4));
                mapWithResult.put(Integer.parseInt(arg), contact);
            }
            return mapWithResult;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteContact(String id) {
        try {
            conn = jdbcConnection.getConnection();
            String query = "DELETE FROM phonebook WHERE id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.executeUpdate();
            System.out.println("Record is deleted!");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public void updateContact(String id, String fullname, String address, String number) {
        try {
            conn = jdbcConnection.getConnection();
            String query = "UPDATE phonebook SET name = ?, address = ?, phoneno = ? " + " WHERE id = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setString(1, fullname);
            pstmt.setString(2, address);
            pstmt.setString(3, number);
            pstmt.setInt(4, Integer.parseInt(id));
            pstmt.executeUpdate();
            System.out.println("Record is Updated!");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

}
