package ra.exception;

import java.util.Scanner;

public class Throw_Throws_Exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số nguyên thứ 1:");
        int number1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào số nguyên thứ 2:");
        int number2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Thương 2 số là: "+divide(number1,number2));
    }
    public static int divide(int number1, int number2) throws ArithmeticException{
        if (number2==0){
            throw new ArithmeticException("Lỗi chia cho 0");
        }
        int result = number1/number2;
        return result;
    }
}
