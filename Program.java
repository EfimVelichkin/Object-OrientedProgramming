package org.example;

import java.util.ArrayList;

public class Program {
    class Product {
        private String name;
        private double price;
        private int rating;

        public Product(String name, double price, int rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getRating() {
            return rating;
        }
    }

    class Category {
        private String name;
        private ArrayList<Product> products;

        public Category(String name) {
            this.name = name;
            this.products = new ArrayList<>();
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public void removeProduct(Product product) {
            products.remove(product);
        }

        public ArrayList<Product> getProducts() {
            return products;
        }
    }

    class Basket {
        private ArrayList<Product> purchasedProducts;

        public Basket() {
            this.purchasedProducts = new ArrayList<>();
        }

        public void addProduct(Product product) {
            purchasedProducts.add(product);
        }

        public void removeProduct(Product product) {
            purchasedProducts.remove(product);
        }

        public ArrayList<Product> getPurchasedProducts() {
            return purchasedProducts;
        }
    }

    class User {
        private String login;
        private String password;
        private Basket basket;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
            this.basket = new Basket();
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public Basket getBasket() {
            return basket;
        }
    }
}
