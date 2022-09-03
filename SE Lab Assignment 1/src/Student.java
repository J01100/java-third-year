import java.util.List;

public class Student {
    public String studentNo;
    public String lastName;
    public String firstName;
    public String gender;
    public String program;
    public List<Course> coursesTaken;

    public String getStudentNo() { return studentNo; }

    public void setStudentNo(String studentNo) { this.studentNo = studentNo; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getProgram() { return program; }

    public void setProgram(String program) { this.program = program; }

    public List<Course> getCoursesTaken() { return coursesTaken; }

    public void setCoursesTaken(List<Course> coursesTaken) { this.coursesTaken = coursesTaken; }

    public String toString(){
        String output = "";
        output += "Student number is " + getStudentNo();
        output += "\nName: " + getLastName().toUpperCase() + ", " + getFirstName();
        output += "\nGender: " + getGender();
        output += "\nProgram: " + getProgram();
        output += "\n\nCourses Taken: ";

        int size = getCoursesTaken().size();

        while (size > 0){
            output += getCoursesTaken().get(size-1);
            size--;
        }

        return output;
    }
}
