import java.util.ArrayList;
import java.util.List;

public class ClassList {
    public static void main(String[] args) {
        Student student1 = new Student();

        student1.setStudentNo("1234");
        student1.setLastName("Dela Cruz");
        student1.setFirstName("Juan");
        student1.setGender("M");
        student1.setProgram("BSCS");

        List courseList = new ArrayList<Course>();

        Course course1 = new Course();
        course1.setCourseCode("CSL311-18");
        course1.setDescription("SoftEng1 Lab");
        course1.setUnit(1);

        Course course2 = new Course();
        course2.setCourseCode("CCS311-18");
        course2.setDescription("SoftEng1 Lec");
        course2.setUnit(2);

        Course course3 = new Course();
        course3.setCourseCode("CCS211-18");
        course3.setDescription("Info Management 1");
        course3.setUnit(3);

        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);

        student1.setCoursesTaken(courseList);

        System.out.println(student1);

    }
}
