package org.example;

import java.sql.*;
import java.util.List;

public class PhoneBook extends Metods{

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:phonebook.db");
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        PhoneBook phonebook = new PhoneBook();
        phonebook.createTable();
        phonebook.addContact( "Alex", "8-888-888-88-88", "efefeefefeefe@gmail.com");
        phonebook.getContacts();
        List<Contact> contacts = phonebook.getContacts();
        phonebook.exportContacts(contacts, "phoneBook.csv");
        phonebook.importContacts("PhoneBook.csv");
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