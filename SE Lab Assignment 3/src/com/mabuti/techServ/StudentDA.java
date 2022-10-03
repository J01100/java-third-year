package com.mabuti.techServ;

import com.mabuti.domain.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentDA {
    ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public StudentDA() throws IOException {
        BufferedReader studentFile = new BufferedReader(new FileReader("src/csv/studentInfo.csv"));
        String studentRow;

        while((studentRow = studentFile.readLine()) != null){
            String[] studentRowSpecific = studentRow.split(",");
            Student student = new Student();
            student.setStudentNumber(studentRowSpecific[1]);
            student.setName(studentRowSpecific[2]);
            student.setProgram(studentRowSpecific[3]);

            CourseDA courseDA = new CourseDA(student.getStudentNumber());
            student.setCourseList(courseDA.getCourseList());
            studentList.add(student);
        }
    }
}
