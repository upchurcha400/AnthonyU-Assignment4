package com.coderscampus;

public class CollegeRosterApplication {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        Student[] students = fileService.loadStudents("student_master_list.csv");
        fileService.sortAndWriteStudentsByCourse(students);
    }
}