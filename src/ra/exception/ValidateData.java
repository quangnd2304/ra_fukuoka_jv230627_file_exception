package ra.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValidateData {
    public static void main(String[] args) {
        //Nhập vào tuổi sinh viên là số nguyên có giá trị lớn hơn 0
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        System.out.println("Nhập vào tuổi sinh viên:");
        int age = 0;
        do {
            String ageStr = scanner.nextLine();
            //-Bắt buộc nhập tuổi sinh viên
            if (checkEmpty(ageStr)) {
                //--Bắt kiểu số nguyên
                if (checkInteger(ageStr)) {
                    age = Integer.parseInt(ageStr);
                    if (age > 0) {
                        break;
                    } else {
                        System.err.println("Tuổi sinh viên phải lớn hơn 0, vui lòng nhập lại");
                    }
                } else {
                    System.err.println("Tuổi phải là số nguyên, vui lòng nhập lại");
                }
            } else {
                System.err.println("Tuổi sinh viên không được để trống, vui lòng nhập lại");
            }
        } while (isExit);
        System.out.println("Tuổi sinh viên là: " + age);
        //Nhập vào điểm sinh viên phải có kiểu float có giá trị trong khoảng 0-10
        float mark = 0;
        System.out.println("Nhập vào điểm sinh viên:");
        do {
            String markStr = scanner.nextLine();
            //Kiểm tra không được để trống
            if (checkEmpty(markStr)) {
                //Kiểm tra kiểu dữ liệu là float
                if (checkFloat(markStr)) {
                    mark = Float.parseFloat(markStr);
                    if (mark >= 0 && mark <= 10) {
                        break;
                    } else {
                        System.err.println("Điểm trong khoảng 0-10, vui lòng nhập lại");
                    }
                } else {
                    System.err.println("Điểm sinh viên phải là số thực, vui lòng nhập lại");
                }
            } else {
                System.err.println("Điểm sinh viên không được để trống, vui lòng nhập lại");
            }
        } while (isExit);
        //Nhập vào ngày sinh của sinh viên kiểu dữ liệu là date và có định dạng dd/MM/yyyy
        Date birthDate = new Date();
        System.out.println("Nhập vào ngày sinh của sinh viên:");
        do {
            String birthStr = scanner.nextLine();
            if (checkEmpty(birthStr)) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    birthDate = sdf.parse(birthStr);
                    break;
                } catch (ParseException e) {
                    System.err.println("Ngày sinh sinh viên phải có định dạng dd/MM/yyyy, vui lòng nhập lại");
                }
            } else {
                System.err.println("Ngày sinh sinh viên không được để trống, vui lòng nhập lại");
            }
        } while (isExit);
        System.out.println("Ngày sinh sinh viên: " + birthDate);

    }

    public static boolean checkEmpty(String str) {
        if (str == "" || str.trim().length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean checkInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static boolean checkFloat(String str) {
        try {
            Float.parseFloat(str);
        } catch (NumberFormatException nfe) {
            return false;
        } catch (Exception ex) {
            return false;
        }
        return true;
    }


}
