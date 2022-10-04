package com.mabuti.techServ;

import com.mabuti.domain.BlockSection;
import com.mabuti.domain.Course;
import com.mabuti.domain.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BlockSectionDA {
    BlockSection blockSection = new BlockSection();

    public BlockSection getBlockSection() {
        return blockSection;
    }

    public BlockSectionDA() throws IOException {
        BufferedReader blockSectionFile = new BufferedReader(new FileReader("src/csv/blockSectionInfo.csv"));
        String blockSectionRow = blockSectionFile.readLine();

        String[] blockSectionRowSpecific = blockSectionRow.split(",");

        blockSection.setBlockCode(blockSectionRowSpecific[0]);
        blockSection.setDescription(blockSectionRowSpecific[1]);
        blockSection.setAdviser(blockSectionRowSpecific[2]);

    }

    public void printStudents() throws IOException {
        StudentDA studentDA = new StudentDA();

        for (Student student : studentDA.getStudentList()){
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
