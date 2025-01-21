package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
//            mptech o1=
        List<String> techs= Arrays.asList("Sandeep","Ravi","Krish");
        /*Emptech sandy=new Emptech("Sandeep",Arrays.asList("Springboot", "Rest API", "Java"));
        Emptech ravi=new Emptech("Ravi",Arrays.asList("Python", "React"));
        Emptech kris=new Emptech("Sandeep",Arrays.asList("C++", "C", "Java", "Linux"));
        List<Emptech> list=Arrays.asList(sandy,ravi,kris);
        Map<Emptech, Long> map = list.
                stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);*/
        List<String> l1=Arrays.asList( "Rest API", "Java");
        List<String> l2=Arrays.asList( "Python", "React");
        List<String> l3=Arrays.asList( "C++", "C", "Java", "Linux");
        Techemp o1=new Techemp("Sandeep",l1);
        Techemp o2=new Techemp("Ravi",l2);
        Techemp o3=new Techemp("Krishna",l3);
        List<Techemp> list=Arrays.asList(o1,o2,o3);
        Map<Techemp, Long> map = list.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }


}

class Techemp{

    String techname;
    List<String > emps;

    public Techemp(String techname, List<String> emps) {
        this.techname = techname;
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Techemp{" +
                "techname='" + techname + '\'' +
                ", emps=" + emps +
                '}';
    }
}
class Emptech{
    String name;
    List<String> tech;

    public Emptech(String name, List<String> tech) {
        this.name = name;
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Emptech{" +
                "name='" + name + '\'' +
                ", tech=" + tech +
                '}';
    }
}
