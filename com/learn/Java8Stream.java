package com.learn;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Stream {

    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                        new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
                        new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("+912632632762", "+1673434723929")),
                        new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("+912632633882", "+1673434709929")),
                        new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("+9126325832782", "+1671434729929")),
                        new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("+012632632782")),
                        new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("+9126254632782", "+16736784729929")),
                        new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("+912632632782", "+1671234729929")),
                        new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("+9126326355782", "+1673434729929")),
                        new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
                        new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("+912632646482", "+16734323229929")))
                .collect(Collectors.toList());

        // 1. Find the list of students whose rank is in between 50 and 10
        studentList.stream().filter(student -> student.getRank() > 50 && student.getRank()<100).
                forEach(s-> System.out.print(s+" , "));

        studentList.stream().filter(student -> student.getCity().equals("Karnataka")).
                sorted(Comparator.comparing(Student::getFirstName,Comparator.reverseOrder())).forEach(s-> System.out.print(s));
        System.out.println("\n-------------------");
studentList.stream().forEach(s-> System.out.print(s.getDept()+", "));
        System.out.println("\n-------------------");
studentList.stream()
        .map(Student::getDept)
        .distinct()
        .forEach(s-> System.out.print(s+"  "));

        System.out.println("\n-------------------");

        studentList.stream().map(student -> student.getContacts()).forEach(s-> System.out.print(s+" "));
        System.out.println("\n-----------------flat map --");
        studentList.stream().flatMap(student -> student.getContacts().stream()).distinct().forEach(s-> System.out.print(s+" , "));

        Map<String, List<Student>> stuMap = studentList.stream().collect(Collectors.groupingBy(Student::getDept));
        Map<String, Long> collect = studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));
        System.out.println(collect);
        System.out.println("\n-----------------flat map --");
        Map.Entry<String, Long> stringLongEntry = studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(stringLongEntry);
        System.out.println("\n-----------------flat map --");

        Map<String, Double> collect1 = studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(collect1);

    }
}