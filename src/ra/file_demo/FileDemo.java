package ra.file_demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDemo {
    public static void main(String[] args) {
        Student student1 = new Student("SV001", "Nguyễn Văn A", 20);
        Student student2 = new Student("SV002", "Nguyễn Văn Bình", 22);
        Student student3 = new Student("SV003", "Nguyễn Văn C", 25);
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        //Ghi dữ liệu danh sách sinh viên ra file students.txt
        writeDataToFile(listStudent);
        //Đọc dữ liệu từ file
        readDataFromFile();
    }

    public static void writeDataToFile(List<Student> listStudent) {
        //1. Khởi tạo file
        //Nếu file students.txt chưa tồn tại thì tạo mới
        //Nếu file students.txt đã tồn tại, ghi đè toàn bộ
        File file = new File("students.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            //2. Khởi tạo đối tượng FileOutputStream
            fos = new FileOutputStream(file);
            //3. Khởi tạo đối tượng ObjectOutputStream
            oos = new ObjectOutputStream(fos);
            //4. Ghi dữ liệu ra file với phương thức writeObject
            oos.writeObject(listStudent);
            //5. Đẩy dữ liệu từ stream xuống file
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readDataFromFile() {
        //1. Khởi tạo đối tượng file
        File file = new File("students.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            //2. Khởi tạo đôi tượng FileInputStream
            fis = new FileInputStream(file);
            //3. Khởi tạo đối tượng ObjectInputStream để đọc object
            ois = new ObjectInputStream(fis);
            //4. Đọc dữ liệu với phương thức readObject()
            List<Student> listStudentRead = (List<Student>) ois.readObject();
            //In ra kết quả
            for (Student student : listStudentRead) {
                System.out.println(student.toString());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
