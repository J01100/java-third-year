public class Course {
    public String courseCode;
    public String description;
    public Integer unit;

    public String getCourseCode() { return courseCode; }

    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getUnit() { return unit; }

    public void setUnit(Integer unit) { this.unit = unit; }

    public String toString(){
        String output = "";
        output += "\nCourse code: " + this.getCourseCode();
        output += "\nDescription: " + this.getDescription();
        output += "\nNumber of units: " + this.getUnit() + "\n";
        return output;
    }
}
