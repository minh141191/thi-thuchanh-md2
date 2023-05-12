package bai1;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ProductManage productManage = new ProductManage();
        int choice = -1;
        do {
            System.out.println("-----MENU-----");
            System.out.println("1. Xem danh sách sản phẩm: ");
            System.out.println("2. Thêm mới sản phẩm: ");
            System.out.println("3. Cập nhật sản phẩm: ");
            System.out.println("4. Xóa sản phẩm: ");
            System.out.println("5. Sắp xếp sản phẩm: ");
            System.out.println("6. Tìm kiếm sản phẩm có giá đắt nhất: ");
            System.out.println("7. Đọc từ file: ");
            System.out.println("8. Ghi từ file: ");
            System.out.println("0. Thoát: ");
            System.out.println(" Chọn lựa chức năng: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    productManage.displayAll();
                    break;
                case 2:
                    productManage.create();
                    break;
                case 3:
                    productManage.update();
                    break;
                case 4:
                    productManage.delete();
                    break;
                case 5:
                    productManage.displayAll();
                    productManage.sortByPriceIncrease();
                    break;
                case 6:
                    productManage.searchByMaxPrice();
                    break;
                case 7:
                    productManage.read();
                    break;
                case 8:
                    productManage.write();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }while (true);
    }
}
