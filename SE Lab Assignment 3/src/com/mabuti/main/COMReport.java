package com.mabuti.main;

import com.mabuti.domain.BlockSection;
import com.mabuti.techServ.BlockSectionDA;

import java.io.IOException;

public class COMReport {

    public static void main(String[] args) throws IOException {
        BlockSectionDA blockSectionDA = new BlockSectionDA();

        BlockSection blockSection = blockSectionDA.getBlockSection();

        System.out.println("Block Section:" + blockSection.getBlockCode()+"\t"+
                "Block Section Description:" + blockSection.getDescription() +"\n"
                + "Class Adviser: " + blockSection.getAdviser()+"\n");

        blockSectionDA.printStudents();
    }
}
