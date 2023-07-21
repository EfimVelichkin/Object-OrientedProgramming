package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Metods {
    public static void addContact(String name, String phone, String email) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:phonebook.db");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO contacts (name, phone, email) VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, email);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:phonebook.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Contact contact = new Contact(id, name, phone, email);
                contacts.add(contact);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return contacts;
    }

    public void exportContacts(List<Contact> contacts, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Contact contact : contacts) {
                writer.write(contact.getId() + "," + contact.getName() + "," + contact.getPhone() + "," + contact.getEmail() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> importContacts(String fileName) {
        List<Contact> contacts = new ArrayList<>();
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String phone = data[2];
                String email = data[3];
                Contact contact = new Contact(id, name, phone, email);
                contacts.add(contact);
            }
            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public void createTable() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:phonebook.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS contacts (id INTEGER PRIMARY KEY, name TEXT, phone TEXT, email TEXT)");
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}
