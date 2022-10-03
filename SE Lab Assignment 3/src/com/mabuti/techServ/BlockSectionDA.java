package com.mabuti.techServ;

import com.mabuti.domain.BlockSection;
import com.mabuti.domain.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BlockSectionDA {
    BlockSection blockSection = new BlockSection();
    ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

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

        StudentDA studentDA = new StudentDA();
        this.setStudentList(studentDA.getStudentList());
    }
}
