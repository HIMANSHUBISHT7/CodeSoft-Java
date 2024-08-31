import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing a Course
class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean registerStudent() {
        if (enrolledStudents < capacity) {
            enrolledStudents++;
            return true;
        } else {
            System.out.println("No available slots in " + title);
            return false;
        }
    }

    public void dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }

    public boolean hasAvailableSlot() {
        return enrolledStudents < capacity;
    }

    public void displayCourseInfo() {
        System.out.println(courseCode + ": " + title);
        System.out.println("Description: " + description);
        System.out.println("Schedule: " + schedule);
        System.out.println("Available Slots: " + (capacity - enrolledStudents) + "/" + capacity);
        System.out.println();
    }
}

// Class representing a Student
class Student {
    private String studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
            System.out.println("Successfully registered for " + course.getTitle());
        }
    }

    public void dropCourse(String courseCode) {
        for (Course course : registeredCourses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                course.dropStudent();
                registeredCourses.remove(course);
                System.out.println("Successfully dropped " + course.getTitle());
                return;
            }
        }
        System.out.println("You are not registered for this course.");
    }

    public void displayRegisteredCourses() {
        System.out.println("\n--- Registered Courses ---");
        if (registeredCourses.isEmpty()) {
            System.out.println("You are not registered for any courses.");
        } else {
            for (Course course : registeredCourses) {
                course.displayCourseInfo();
            }
        }
    }
}

// Main class to run the course registration system
public class five {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeCourses();
        initializeStudents();

        boolean running = true;

        while (running) {
            System.out.println("\n--- Course Registration System ---");
            System.out.println("1. List Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listAvailableCourses();
                    break;
                case 2:
                    System.out.print("Enter your Student ID: ");
                    String studentId = scanner.next();
                    Student student = findStudentById(studentId);
                    if (student != null) {
                        listAvailableCourses();
                        System.out.print("Enter the course code to register: ");
                        String courseCode = scanner.next();
                        Course course = findCourseByCode(courseCode);
                        if (course != null) {
                            student.registerCourse(course);
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter your Student ID: ");
                    studentId = scanner.next();
                    student = findStudentById(studentId);
                    if (student != null) {
                        student.displayRegisteredCourses();
                        System.out.print("Enter the course code to drop: ");
                        String courseCode = scanner.next();
                        student.dropCourse(courseCode);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter your Student ID: ");
                    studentId = scanner.next();
                    student = findStudentById(studentId);
                    if (student != null) {
                        student.displayRegisteredCourses();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void initializeCourses() {
        courses.add(new Course("CS101", "Introduction to Computer Science", "Basic concepts of computer science.", 30, "MWF 9:00AM - 10:00AM"));
        courses.add(new Course("MATH101", "Calculus I", "Introduction to differential and integral calculus.", 25, "TTh 11:00AM - 12:30PM"));
        courses.add(new Course("ENG101", "English Composition", "Study and practice of writing and critical reading.", 20, "MWF 10:00AM - 11:00AM"));
    }

    private static void initializeStudents() {
        students.add(new Student("S1001", "Alice Smith"));
        students.add(new Student("S1002", "Bob Johnson"));
        students.add(new Student("S1003", "Charlie Brown"));
    }

    private static void listAvailableCourses() {
        System.out.println("\n--- Available Courses ---");
        for (Course course : courses) {
            course.displayCourseInfo();
        }
    }

    private static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }
}

