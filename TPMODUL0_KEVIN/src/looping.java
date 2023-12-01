public class looping {
    public static void main(String[] args) {
        // Inisiasi primitive type arrays
        byte[] x = {1, 2, 3, 4, 5};
        short[] y = {100, 200, 300, 400};
        char[] z = {'a', 'b', 'c', 'd'};
        int[] a = {1000000, 2000000, 3000000};
        long[] b = {10000000, 2000000000, 300000000};

        // Inisiasi course objects
        Course c1 = new Course();
        c1.setCourseID("IS001");
        c1.setCourseName("Pemrograman Berorientasi Objek");
        c1.setCredits(3);

        Course c2 = new Course();
        c2.setCourseID("IS002");
        c2.setCourseName("Algoritma dan Struktur Data");
        c2.setCredits(4);

        Course c3 = new Course();
        c3.setCourseID("IS003");
        c3.setCourseName("Database Management Systems");
        c3.setCredits(3);

        Course[] courses = {c1, c2, c3};

        int index = 0;
        do {
            Course course = courses[index];
            System.out.println("Course ID: " + course.getCourseID());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Credits: " + course.getCredits());
            System.out.println("-----------------------");
            index++;
        } while (index < courses.length);

       
        for (Course c : courses) {
            System.out.println("Course ID: " + c.getCourseID());
            System.out.println("Course Name: " + c.getCourseName());
            System.out.println("Credits: " + c.getCredits());
            System.out.println("-----------------------");
        }

        for (byte i = 0; i < 5; i++) {
            for (byte j = 0; j < 5; j++) {
                if (j > i) {
                    break;
                }
                System.out.print(" * ");
            }
            System.out.println();
        }

        // Print array elements 
        System.out.print("Array elements: ");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            if (i < b.length - 1) {
                System.out.print(", ");
            }
        }
    }
}

class Course {
    private String courseID;
    private String courseName;
    private int credits;

    // 
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}