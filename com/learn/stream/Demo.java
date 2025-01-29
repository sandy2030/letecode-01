package com.learn.stream;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@FunctionalInterface
interface  Fun1{
    int calculate(int x,int y);
}
public class Demo {
    public static void main(String[] args) {
        Fun1 sub=(a,b)->a-b;
        int calculate = sub.calculate(4, 3);
        System.out.println(calculate);
        ///////////////////////
        /*
           3 variants of groupingBy
        * first one groups elements by the result of a classifier function which is Collectors.toList() by default
        * 1) groupingBy(Funtion)
        * second one allows grouped data in a custom way like Collectors.counting() to count the number of items in each group
        2) groupingBy(Funtion,Collector)
        * third one allows to specify the type of Map to use for storing the results, By default, groupingBy() returns a HashMap,
        but you can use this variant to specify a different Map implementation, such as TreeMap or LinkedHashMap,
        to maintain order
        * 3)  groupingBy(Funtion,Supplier,Collector)
        * */
        List<Employee>list=getEmp();
        Collection<List<Employee>> values = list.stream()
                .collect(Collectors.groupingBy(Employee::getDept))
                .values();
        values.forEach(z->z.stream().filter(x->x.getAge()>25 && x.getAge()<=30 && x.getGender().equals("male"))
                .forEach(d-> System.out.println(d)));
    }
    static List<Employee> getEmp(){
        return Arrays.asList(
                new Employee("ram",23,Dept.IT,"male"),
                new Employee("shery",23,Dept.ADMIN,"female"),
                new Employee("rita",27,Dept.IT,"female"),
                new Employee("peter",29,Dept.IT,"male"),
                new Employee("jack",30,Dept.IT,"male"),
                new Employee("stephy",26,Dept.IT,"female")
        );
    }
}


class Employee{
    String name;
    int age;
    Dept dept;
    String gender;

    public Employee(String name, int age, Dept dept, String gender) {
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Dept getDept() {
        return dept;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dept=" + dept +
                ", gender='" + gender + '\'' +
                '}';
    }
}
