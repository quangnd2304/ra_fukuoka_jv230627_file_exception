package ra.exception;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số nguyên thứ 1:");
        int number1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào số nguyên thứ 2:");
        int number2 = Integer.parseInt(scanner.nextLine());
        //Tính thương 2 số
        //Sử dụng try...catch
        int divide=0;
        try {
            //Bắt exception cho cả khối lệnh
            divide = number1 / number2;
            System.out.println("Đang tính thương");
        } catch (ArithmeticException ae) {
            //Xử lý các lỗi ngoại lệ
            System.out.println("Bắt đầu xử lý ngoại lệ");
            number2 = 1;
            divide = number1 / number2;
        } catch (NullPointerException ne){
            System.out.println("Xử lý khi null pointer exception");
        } catch (Exception ex){
            System.out.println("Xử lý tất cả các lỗi ngoại lệ");
        }finally {
            System.out.println("Kết thúc, đóng kết nối");
        }

        System.out.println("Thương 2 số là: " + divide);
        System.out.println("Kết thúc chương trình");
    }
}
