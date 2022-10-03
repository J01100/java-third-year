package com.mabuti.techServ;

import com.mabuti.domain.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseDA {
    ArrayList<Course> courseList = new ArrayList<>();

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public CourseDA(String studentNumber) throws IOException {
        BufferedReader courseFile = new BufferedReader(new FileReader("src/csv/scheduleInfo.csv"));
        String courseRow;

        while((courseRow = courseFile.readLine()) != null) {
            String[] courseRowSpecific = courseRow.split(",");

            Course course = new Course();

            if (studentNumber.equals(courseRowSpecific[0])) {
                course.setCourseCode(courseRowSpecific[1]);
                course.setDescription(courseRowSpecific[2]);
                course.setUnit(Integer.valueOf(courseRowSpecific[3]));
                course.setDay(courseRowSpecific[4]);
                course.setTime(courseRowSpecific[5]);

                courseList.add(course);
            }

        }
    }
}
