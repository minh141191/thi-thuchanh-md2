package bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManage implements IOFile<Product> {
    private List<Product> products;
    private static Scanner scanner;

    public ProductManage() {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);
        products = read();
        checkDefaultIndex();
    }


    private void checkDefaultIndex() {
        if (products.isEmpty()) {
            Product.INDEX = 0;
        } else {
            Product.INDEX = products.get(products.size() - 1).getId();
        }
    }


    public void displayAll() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
    public Product getById() {
        displayAll();
        int id;
        do {
            try {
                System.out.println("Input id you want to find: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Have error, please try again!");
            }
        } while (true);

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static int inputNum() {
        int x;
        do {
            try {
                x = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error : " + e.getMessage());
            }
        } while (true);
        return x;
    }

    public Product create() {
        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        int price = inputNum();
        System.out.println("Nhập số lượng sản phẩm: ");
        int quantity = inputNum();
        System.out.println("Nhập mô tả sản phẩm: ");
        String type = scanner.nextLine();
        Product product = new Product(name, price, quantity, type);
        products.add(product);
        write();
        return product;
    }

    public Product update() {
        Product product = getById();
        System.out.println("Nhập tên mới cho sản phẩm:");
        String name = scanner.nextLine();
        product.setName(name);
        System.out.println("Nhập giá mới cho sản phẩm: ");
        int price = inputNum();
        product.setPrice(price);
        System.out.println("Nhập số lượng mới cho sản phẩm: ");
        int quantity = inputNum();
        product.setQuantity(quantity);
        System.out.println("Nhập mô tả sản phẩm: ");
        String type = scanner.nextLine();
        product.setType(type);
        Product product1 = new Product(name, price, quantity, type);
        products.add(product1);
        write();
        return product1;
    }

    public Product delete() {
        Product product = getById();
        if (product != null) {
            products.remove(product);
        }
        write();
        return product;
    }

    public void sortByPriceIncrease() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) return 1;
                else if (o1.getPrice() < o2.getPrice()) return -1;
                else return 0;
            }
        });
    }

    public void searchByMaxPrice() {
        double maxPrice = products.get(0).getPrice();
        for (Product product : products) {
            if (product.getPrice() > maxPrice) {
                maxPrice = product.getPrice();
            }
        }
        for (Product product : products) {
            if (product.getPrice() == maxPrice) {
                System.out.println(product);
            }
        }
    }


    @Override
    public void write() {
        File file = new File("D:\\02_Study\\thi-thuc-hanh\\src\\bai1\\product.csv");
        List<Product> products1 = new ArrayList<>();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Product product : products1) {
                bufferedWriter.write(product.getId() + "," + product.getName() + ","
                        + product.getName() + "," + product.getPrice()+ ","
                        + product.getQuantity() + "," + product.getType()+ "\n");
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    @Override
    public ArrayList<Product> read() {
        File file = new File("D:\\02_Study\\thi-thuc-hanh\\src\\bai1\\product.csv");
        ArrayList<Product> products1= new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                String[] strings = data.split(",");
                Product product = new Product();
                product.setId(Integer.parseInt(strings[0]));
                product.setName(strings[1]);
                product.setPrice(Integer.parseInt(strings[2]));
                product.setQuantity(Integer.parseInt(strings[3]));
                product.setType(strings[4]);
                products1.add(product);

            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
        return products1;
    }
}
