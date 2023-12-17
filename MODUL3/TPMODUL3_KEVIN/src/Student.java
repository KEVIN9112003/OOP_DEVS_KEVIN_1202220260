
import java.util.ArrayList;

public class Student extends User {
    protected ArrayList<String> enrolledCourse;

    public Student(String name, int id) {
        super(name, id);
        enrolledCourse = new ArrayList<>();
    }

    public void enrollInCourse(String course) {
        enrolledCourse.add(course);
    }

    @Override
    public String getUserDetails() {
        return super.getUserDetails() + "\nEnrolled Courses: " + enrolledCourse;
    }
}
