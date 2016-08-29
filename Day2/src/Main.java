import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by tranh on 22-Aug-16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StudentManager studentManager = new StudentManager();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("---------Phần mềm quản lý sinh viên-------");
            System.out.println("Mời bạn chọn chức năng: ");
            System.out.println("1.Thêm sinh viên.");
            System.out.println("2.Sửa thông tin sinh viên.");
            System.out.println("3.Xóa sinh viên.");
            System.out.println("4.Tìm sinh viên theo tên.");
            System.out.println("5.Tìm sinh viên theo Id");
            System.out.println("6.Hiển thị tất cả sinh viên:");
            System.out.println("7.Lưu object dưới dạng binary.");
            System.out.println("8.Hiển thị object đã lưu (binary) ");
            System.out.println("9.Lưu object dưới dạng text");
            System.out.println("10.Hiển thị object lưu dưới dạng text");
            System.out.println("0.Thoát");
            System.out.println("--------------------");
            int chosose = input.nextInt();
            input.nextLine();
            int age;
            String name, studentId;
            ArrayList<Student> studentArrayList=new ArrayList<>();

            switch (chosose) {
                case 1:
                    System.out.println("Nhập tên sinh viên: ");
                    name = input.nextLine();
                    System.out.println("Nhập tuổi: ");
                    age = input.nextInt();
                    input.nextLine();
                    System.out.println("Nhập mã Sv: ");
                    studentId = input.nextLine();
                    if (studentManager.addStudent(name, age, studentId)) {
                        System.out.println("Thêm thành công!");
                    } else {
                        System.out.println("Thêm thất bại!");
                    }
                    break;
                case 2:
                    System.out.println("Nhập id muốn sửa: ");
                    studentId = input.nextLine();
                    System.out.println("Nhập tên muốn sửa: ");
                    name = input.nextLine();
                    if (studentManager.editStudent(studentId, name)) {
                        System.out.println("Thành công");
                    } else {
                        System.out.println("sửa thất bại!");
                    }
                    break;
                case 3:
                    System.out.println("Nhập id cần xóa: ");
                    studentId = input.nextLine();
                    if (studentManager.removeStudent(studentId)) {
                        System.out.println("Thành công");
                    } else {
                        System.out.println("Xóa thất bại");
                    }
                    break;
                case 4:
                    System.out.println("Nhập tên sinh viên cần tìm: ");
                    name=input.nextLine();
                    ArrayList<Student>studentByName=studentManager.findStudentByName(name);
                    System.out.println(studentByName.toString());
                    break;
                case 5:
                    System.out.println("Nhập id sinh viên: ");
                    studentId=input.nextLine();
                    if (studentManager.findStudentById(studentId)!=null) {
                        System.out.println(studentManager.findStudentById(studentId).toString());
                    }
                    else {
                        System.out.println("Không tồn tại!");
                    }
                    break;
                case 6:
                    System.out.println(studentManager.toString());
                    break;
                case 7:
                    StudentDataAccess.writeToBinaryFile(studentManager.allStudent());
                    System.out.println("Thành công!");
                    break;
                case 8:
                    try {
                        studentArrayList=StudentDataAccess.readFromBinaryFile("objectStudent.dat");
                    } catch (ClassNotFoundException e) {
                        System.out.println("File không tồn tại!");
                        e.printStackTrace();
                    }
                    System.out.println(studentArrayList.toString());
                    break;
                case 9:
                    StudentDataAccess.writeToTextFile(studentManager.allStudent());
                    System.out.println("Thành công!");
                    break;
                case 10:
                    studentArrayList=StudentDataAccess.readFromTextFile("sinhvienText.txt");
                    System.out.println(studentArrayList.toString());
                    break;
                default:
                    return;
            }
        } while (true);
    }
}
