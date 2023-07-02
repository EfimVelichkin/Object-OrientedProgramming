package org.example;

import java.util.ArrayList;
import java.util.List;

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
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

class Basket {
    private List<Product> products;

    public Basket() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

class User {
    private String username;
    private String password;
    private Basket basket;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        basket = new Basket();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Basket getBasket() {
        return basket;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание категорий
        Category electronicsCategory = new Category("Electronics");
        Category clothingCategory = new Category("Clothing");

        // Создание товаров
        Product tv = new Product("TV", 1000, 5);
        Product phone = new Product("Phone", 500, 4);
        Product shirt = new Product("Shirt", 50, 3);

        // Добавление товаров в категории
        electronicsCategory.addProduct(tv);
        electronicsCategory.addProduct(phone);
        clothingCategory.addProduct(shirt);

        // Вывод каталога продуктов
        System.out.println("Catalog:");
        System.out.println("Electronics:");
        for (Product product : electronicsCategory.getProducts()) {
            System.out.println(product.getName() + " - $" + product.getPrice() + " - Rating: " + product.getRating());
        }
        System.out.println("Clothing:");
        for (Product product : clothingCategory.getProducts()) {
            System.out.println(product.getName() + " - $" + product.getPrice() + " - Rating: " + product.getRating());
        }

        // Создание пользователей
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        // Добавление товаров в корзину пользователей
        user1.getBasket().addProduct(tv);
        user1.getBasket().addProduct(shirt);
        user2.getBasket().addProduct(phone);

        // Вывод покупок пользователей
        System.out.println("\nUser purchases:");
        System.out.println(user1.getUsername() + "'s basket:");
        for (Product product : user1.getBasket().getProducts()) {
            System.out.println(product.getName() + " - $" + product.getPrice() + " - Rating: " + product.getRating());
        }
        System.out.println(user2.getUsername() + "'s basket:");
        for (Product product : user2.getBasket().getProducts()) {
            System.out.println(product.getName() + " - $" + product.getPrice() + " - Rating: " + product.getRating());
        }
    }
}