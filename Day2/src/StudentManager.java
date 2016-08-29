import java.util.ArrayList;

/**
 * Created by tranh on 23-Aug-16.
 */
public class StudentManager {
    ArrayList<Student> studentArrayList = new ArrayList<>();

    public boolean addStudent(String name, int age, String studentid) {
        return studentArrayList.add(new Student(name, age, studentid));
    }

    public boolean removeStudent(String studentid) {
        return studentArrayList.remove(findStudentById(studentid));
    }

    public Student findStudentById(String studenId) {
        for (int i = 0; i < studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getStudentId().equals(studenId)) {
                return studentArrayList.get(i);
            }
        }
        return null;
    }

    public Student findStudent(String name, int age, String studenId) {
        for (int i = 0; i < studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getStudentId().equals(studenId) &&
                    studentArrayList.get(i).getName().equals(name) &&
                    studentArrayList.get(i).getAge() == age) {
                return studentArrayList.get(i);
            }
        }
        return null;
    }
    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> arrayList = new ArrayList<>();
        for (int i = 0; i < studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getName().equals(name)) {
                arrayList.add(studentArrayList.get(i));
            }
        }
        return arrayList;
    }
    public boolean editStudent(String studentId,String newName) {
        for (int i=0;i<studentArrayList.size();i++) {
            if (findStudentById(studentId).getStudentId().equals(studentId)) {
                studentArrayList.set(i, new Student(newName, studentArrayList.get(i).getAge(), studentArrayList.get(i).getStudentId()));
            return true;
            }
        }
        return false;
    }
    public boolean editStudent(String studentId,int age) {
        for (int i=0;i<studentArrayList.size();i++) {
            if (findStudentById(studentId).getStudentId().equals(studentId)) {
                studentArrayList.set(i, new Student(studentArrayList.get(i).getName(), age, studentArrayList.get(i).getStudentId()));
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String strAllStudent="";
        for (int i=0;i<studentArrayList.size();i++) {
            strAllStudent+=studentArrayList.get(i).toString();
        }
        return strAllStudent;
    }
    public ArrayList<Student> allStudent() {
        return studentArrayList;
    }

}
