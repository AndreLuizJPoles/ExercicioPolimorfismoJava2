package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        System.out.print("Enter the number of products: ");
        int numberOfProducts = sc.nextInt();
        for(int i=0; i<numberOfProducts;i++){
            System.out.println("Product #" + (i+1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char typeProduct = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if(typeProduct == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String manufactureDate = sc.next();
                products.add(new UsedProduct(name, price, LocalDate.parse(manufactureDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            }
            else if(typeProduct == 'i'){
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }
            else {
                products.add(new Product(name, price));
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for(Product product : products){
            System.out.println(product.priceTag());
        }
    }
}