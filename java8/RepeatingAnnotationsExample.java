package java8;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Products.class)
@interface Product {
    String name();
    String category();
}
        
// Declaring container for repeatable annotation type
@Retention(RetentionPolicy.RUNTIME)
@interface Products {
    Product[] value();
}
        
// Repeating annotation for products
@Product(name = "Laptop", category = "Electronics")
@Product(name = "Shoes", category = "Fashion")
@Product(name = "Book", category = "Education")
public class RepeatingAnnotationsExample {
    public static void main(String[] args) {
        // Getting annotations by type into an array
        Product[] products = RepeatingAnnotationsExample.class.getAnnotationsByType(Product.class);
        for (Product product : products) {
            // Iterating and displaying product names and categories
            System.out.println(product.name() + " - Category: " + product.category());
        }
    }
}

        

        