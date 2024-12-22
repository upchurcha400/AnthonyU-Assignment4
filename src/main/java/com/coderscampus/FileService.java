package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public Student[] loadStudents(String filename) {
        Student[] students = new Student[104];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;

            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null && count < students.length) {
                String[] studentDetails = line.split(",");
                Integer studentId = Integer.parseInt(studentDetails[0]);
                String studentName = studentDetails[1];
                String studentCourse = studentDetails[2];
                Integer studentGrade = Integer.parseInt(studentDetails[3]);
                students[count++] = new Student(studentId, studentName, studentCourse, studentGrade);
            }
        } catch (IOException e) {
            System.out.println("There was an issue reading the file! Here is why ---> " + e.getMessage());
        }
        return students;
    }

    public void sortAndWriteStudentsByCourse(Student[] students) {
        List<Student> compSciStudents = new ArrayList<>();
        List<Student> apMathStudents = new ArrayList<>();
        List<Student> statStudents = new ArrayList<>();
        List<Student> psyStudents = new ArrayList<>();

        for (Student student : students) {
            if (student != null) {
                String course = student.getStudentCourse();

                if (course.contains("COMPSCI")) {
                    compSciStudents.add(student);
                } else if (course.contains("APMTH")) {
                    apMathStudents.add(student);
                } else if (course.contains("STAT")) {
                    statStudents.add(student);
                } else if (course.contains("PSY")) {
                    psyStudents.add(student);
                }

            }
        }

        compSciStudents.sort(null);
        apMathStudents.sort(null);
        statStudents.sort(null);
        psyStudents.sort(null);

        writeToFile(compSciStudents, "course1.csv");
        writeToFile(apMathStudents, "course2.csv");
        writeToFile(statStudents, "course3.csv");
        writeToFile(psyStudents, "course4.csv");
    }

    private void writeToFile(List<Student> students, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Student ID,Student Name,Course,Grade\n");
            for (Student student : students) {
                fileWriter.write(student.getStudentId() + "," + student.getStudentName() + "," + student.getStudentCourse() + "," + student.getStudentGrade() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Uh Oh! There was an issue writing to the file! Here is why ---> " + e.getMessage());
        }
    }
}