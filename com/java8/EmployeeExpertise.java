package com.java8;

import java.util.*;
/*
* input :
Employee Name
Employee expert technology

Krishna : {C++, C, Java, Linux}
Sandeep: {Springboot, Rest API, Java}
Ravi: {Python, React}

output:
Java : {Krishna, Sandeep}
Rest API; {Sandeep}
* */
public class EmployeeExpertise {
    public static void main(String[] args) {
        Set<String> tech1= new HashSet<>(Arrays.asList("C++", "C", "Java", "Linux"));
        Set<String> tech2= new HashSet<>(Arrays.asList("Springboot","Rest API", "Java"));
        Set<String> tech3= new HashSet<>(Arrays.asList("Python", "React"));
        Map<String,Set<String>> empSkillSet=new HashMap();
        empSkillSet.put("sandy",tech2);
        empSkillSet.put("krish",tech1);
        empSkillSet.put("ravi",tech3);

        Map<String,Set<String>> skillEmpSet=new HashMap();
        for(Map.Entry<String,Set<String>> entry:empSkillSet.entrySet()){
            System.out.println("key "+entry.getKey()+"  value  "+entry.getValue());

            for (String  skill:entry.getValue()){
                skillEmpSet.computeIfAbsent(skill,x->new HashSet<>()).add(entry.getKey());
            }
        }

        skillEmpSet.entrySet().stream().forEach(entry-> System.out.println(entry.getKey()+"  "+entry.getValue()));
    }
}
