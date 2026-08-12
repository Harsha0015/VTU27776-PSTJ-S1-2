import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> pq = new PriorityQueue<>(
            new Comparator<Student>() {

                @Override
                public int compare(Student s1, Student s2) {

                    // 1. Higher CGPA gets higher priority
                    if (Double.compare(s2.getCGPA(), s1.getCGPA()) != 0) {
                        return Double.compare(s2.getCGPA(), s1.getCGPA());
                    }

                    // 2. If CGPA is same, name in alphabetical order
                    if (!s1.getName().equals(s2.getName())) {
                        return s1.getName().compareTo(s2.getName());
                    }

                    // 3. If CGPA and name are same, smaller ID first
                    return Integer.compare(s1.getID(), s2.getID());
                }
            }
        );

        // Process all events
        for (String event : events) {

            String[] parts = event.split(" ");

            // ENTER event
            if (parts[0].equals("ENTER")) {

                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);

                Student student = new Student(id, name, cgpa);

                pq.offer(student);
            }

            // SERVED event
            else if (parts[0].equals("SERVED")) {

                if (!pq.isEmpty()) {
                    pq.poll();
                }
            }
        }

        // Store remaining students
        List<Student> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}

public class Solution {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Read number of events
        int totalEvents = Integer.parseInt(scan.nextLine());

        List<String> events = new ArrayList<>();

        // Read all events
        while (totalEvents-- != 0) {
            events.add(scan.nextLine());
        }

        // Process events
        Priorities priorities = new Priorities();

        List<Student> students = priorities.getStudents(events);

        // Print result
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    }
}
