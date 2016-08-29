import org.omg.CORBA_2_3.portable.*;
import org.omg.CORBA_2_3.portable.InputStream;

import java.awt.*;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by tranh on 24-Aug-16.
 */
public class StudentDataAccess {
    public static void writeToBinaryFile(ArrayList<Student> studentArrayList) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("objectStudent.dat"));
        outputStream.writeObject(studentArrayList);
        outputStream.close();
    }

    public static ArrayList<Student> readFromBinaryFile(String path) throws IOException, ClassNotFoundException {

        ArrayList<Student> arrayListStudent = new ArrayList<>();
        ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream("objectStudent.dat"));
        return (ArrayList<Student>) objInputStream.readObject();
    }

    public static void writeToTextFile(ArrayList<Student> studentArrayList) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sinhvienText.txt"));
        for (int i = 0; i < studentArrayList.size(); i++) {
            bufferedWriter.write(studentArrayList.get(i).getName() + ";" + studentArrayList.get(i).getAge() + ";" + studentArrayList.get(i).getStudentId());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static ArrayList<Student> readFromTextFile(String path) throws IOException {
        BufferedReader bufferedReader = null;
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader("sinhvienText.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại!");
            e.printStackTrace();
        }
        while (bufferedReader.ready()) {

            String strStudent = bufferedReader.readLine();
            String strArray[] = new String[3];
            strArray = strStudent.split(";");

            String name=strArray[0];
            int age=Integer.parseInt(strArray[1]);
            String studentId=strArray[2];

            Student student = new Student(name,age,studentId);


            studentArrayList.add(student);
        }
        return studentArrayList;
    }
}
