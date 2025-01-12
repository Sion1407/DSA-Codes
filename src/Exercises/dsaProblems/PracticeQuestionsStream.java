package Exercises.dsaProblems;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee{
    String fName;
    String lName;
    String deptName;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    Employee(String fName, String lName, String deptName){
        this.fName = fName;
        this.lName = lName;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}

public class PracticeQuestionsStream {
    public static void main(String[] args) {

        var cd = List.of(1,2,2,3,4,4,5).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
                .filter(c -> c.getValue()>1).map(v -> v.getValue()*v.getKey()).collect(Collectors.toList());
        List<Employee> employees = List.of(new Employee("Sion","Chowdhury","IT"),
                new Employee("Lokesh","Singh","IT"),
                new Employee("Harish","Kairawat","Sales"),
                new Employee("Ankit","Saini","Sales"));

        //    Given a list of employees. Can you create a map with the count of employees each department has ?
        //with key as department name and count of employees as value.
        Map<String,Long> hm = employees.stream()
                .collect(Collectors.groupingBy(i->i.deptName, Collectors.counting()));
//        System.out.println(hm);

//        Given a map with the department name as key and value as list of employees belonging to that department.
//        when a search string is given, need to list out the employees whose firstname or lastname is matching(match should be case insensitive).
        Map<String,List<Employee>> hm1 = employees.stream().collect(Collectors.groupingBy(i-> i.getDeptName(), Collectors.toList()));
        String s = "Sion";


//        List<Employee> empList = employees.stream().filter(i-> s.equals(i.getfName())|| s.equals(i.getlName())).collect(Collectors.toList());
        List<Employee> emp = hm1.entrySet().stream().flatMap(i->i.getValue().stream().filter(e->s.toLowerCase().equals(e.getfName().toLowerCase())
                || s.toLowerCase().equals(e.getlName().toLowerCase()))).collect(Collectors.toList()).stream().toList();
//        System.out.println(emp);

//      Consider a list of employees, and if a department name is given as argument, list out the employees which doesn't belong to that department.
        String d = "IT";
//        List<Employee> emp1 = hm1.entrySet().stream().filter(i->!i.getKey().equalsIgnoreCase(d)).flatMap(i->i.getValue().stream()).collect(Collectors.toList());
//        System.out.println(emp1);

        List<Employee> emp1 = hm1.entrySet().stream().flatMap(i->i.getValue()
                .stream().filter(e->!d.toLowerCase().equals(e.getDeptName().toLowerCase()))).collect(Collectors.toList()).stream().toList();
        System.out.println(emp1);
//        Consider a list of employees, sort the employees by their firstName and return the sorted list of employees.

    }
}

