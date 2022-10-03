package com.mabuti.main;

import com.mabuti.domain.BlockSection;
import com.mabuti.domain.Course;
import com.mabuti.domain.Student;
import com.mabuti.techServ.BlockSectionDA;

import java.io.IOException;

public class COMReport {

    public static void main(String[] args) throws IOException {
        BlockSectionDA blockSectionDA = new BlockSectionDA();

        BlockSection blockSection = blockSectionDA.getBlockSection();

        System.out.println("Block Section:" + blockSection.getBlockCode()+"\t"+
                "Block Section Description:" + blockSection.getDescription() +"\n"
                + "Class Adviser: " + blockSection.getAdviser()+"\n");

        for (Student student : blockSectionDA.getStudentList()){
            System.out.println("Student Number: " + student.getStudentNumber() + "\t\tStudent Name: " +
                    student.getName() + "\n" + "Schedule:" );

            for (Course course : student.getCourseList()){
                System.out.println(course.getCourseCode() + " " + course.getDescription() + " " +
                        course.getUnit() + " " + course.getDay() + " " + course.getTime());
            }
            System.out.println("------------------------------------------");
        }

    }
}
