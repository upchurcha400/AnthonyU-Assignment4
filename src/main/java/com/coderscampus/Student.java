package com.coderscampus;

public class Student implements Comparable<Student> {
    private Integer studentId;
    private String studentName;
    private String studentCourse;
    private Integer studentGrade;

    public Student(int studentId, String studentName, String studentCourse, int studentGrade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCourse = studentCourse;
        this.studentGrade = studentGrade;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public Integer getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(Integer studentGrade) {
        this.studentGrade = studentGrade;
    }

    @Override
    public int compareTo(Student student) {
        return Integer.compare(student.getStudentGrade(), this.studentGrade);
    }
}