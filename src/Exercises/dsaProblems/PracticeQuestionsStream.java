package Exercises.dsaProblems;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
class DL{
    Node head;
    Node tail;

    class Node{
        Node nxt;
        Node prev;
        int val;

        Node(int val){
            this.nxt = null;
            this.prev = null;
            this.val = val;
        }
    }
}


class Employee{
    String fName;
    String lName;
    String deptName;
    int empId;
    String gender;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    Double salary;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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

//    Employee(String fName, String lName, String deptName,int empId){
//        this.fName = fName;
//        this.lName = lName;
//        this.deptName = deptName;
//        this.empId = empId;
//    }

    public Employee(String fName, String lName, String deptName, int empId, String gender,Double salary) {
        this.fName = fName;
        this.lName = lName;
        this.deptName = deptName;
        this.empId = empId;
        this.gender = gender;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", empId=" + empId +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class PracticeQuestionsStream {
    public static void main(String[] args) {

        var cd = List.of(1,2,2,3,4,4,5).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
                .filter(c -> c.getValue()>1).map(v -> v.getValue()*v.getKey()).collect(Collectors.toList());
        List<Employee> employees = List.of(new Employee("Sion","Chowdhury","IT",1,"Male",1000.0),
                new Employee("Lokesh","Singh","IT",2,"Female",500.0),
                new Employee("Harika","Singh","Sales",3,"Female",2000.0),
                new Employee("Ankit","Saini","Sales",4,"Male",3000.0));

        //    Given a list of employees. Can you create a map with the count of employees each department has ?
        //with key as department name and count of employees as value.
        Map<String, Long> hm = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()));
        System.out.println(hm);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("s");
        stringBuilder.append(true);
        stringBuilder.delete(0,2);
        System.out.println("sb:  "+stringBuilder);

        Optional<Employee> highestsal = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
        System.out.println("highest sal"+highestsal.get());

//        Given a map with the department name as key and value as list of employees belonging to that department.
//        when a search string is given, need to list out the employees whose firstname or lastname is matching(match should be case insensitive).

        String s = "Sion";
        List<Employee> emp2 = employees.stream().filter(emp -> emp.fName.equalsIgnoreCase(s) || emp.lName.equalsIgnoreCase(s))
                .toList();
        System.out.println(emp2);

//        Separate employees into male and female, and return a string like:
        Map<String,List<Employee>> maleFemale = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.toList()));
//        if we want only firstnames
        Map<String,List<String>> maleFemale2 = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getfName,Collectors.toList())));

        System.out.println("Malefemale: "+maleFemale);
        System.out.println("Malefemale only fname: "+maleFemale2);




        Map<String,List<Employee>> hm1 = employees.stream().collect(Collectors.groupingBy(i-> i.getDeptName(), Collectors.toList()));
//        String s = "Sion";


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
        List<Employee> sortedEmp = employees.stream().sorted(Comparator.comparing(Employee::getfName)).toList();
        System.out.println("sorted  emp fname: "+sortedEmp);

//        Store ids are of 4 digit strings.if length of given storeId is less than 4 digits,you need to prefix with zeros and return a 4 digit storeId.
        String storeId = "123";
        StringBuilder sb = new StringBuilder(storeId);
        if (storeId.length() < 4){
            for(; storeId.length() <4;){
                storeId = "0"+ storeId;
            }
        }
        System.out.println(storeId);

//        7)Consider a list of employees, return the employee whose empId is highest.
        Optional<Employee> e = employees.stream().max((Comparator.comparingInt(emp3 -> emp3.empId)));
        System.out.println(e.isEmpty() ? null:e.get());
//        e.ifPresentOrElse(emp3 -> emp3.fName, () -> System.out::println("in else"));

//        Consider a list of employees, concat the fullName of all the employees with pipe (|) and return the concatenated string.
//        where fullName = firstname + lastname.
//                ex: niranjankumar|viswaraj
        List<String> concatedString = employees.stream().map(emp4-> emp4.fName+"|"+emp4.lName).collect(Collectors.toList());
        System.out.println(concatedString);

//        find employee names whose name starts with "SU"
        List<Employee> employeesNamesStartsWithSU = employees.stream().filter(emp5 -> emp5.fName.substring(0,2).equalsIgnoreCase("si")).toList();
        System.out.println(employeesNamesStartsWithSU);

        String cntOfSplChars = "a@sd3";
        long cnt = cntOfSplChars.chars().mapToObj(c -> (char) c).filter(c -> !c.isLetterOrDigit(c)).count();
        System.out.println(cnt);

        List<String> printcntOfDupl = Arrays.asList("apple","mange","apple");
        Map<String,Long> map = printcntOfDupl.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("cnt: "+ map);


        CopyOnWriteArrayList<String> cwa = new CopyOnWriteArrayList<>();
        cwa.add("Sion");
        cwa.add("Loki");
        Iterator<String> itr = cwa.iterator();
        while (itr.hasNext()){
            String value = itr.next();
            if (value.equals("Sion")){
                cwa.remove("Sion");
            }
        }
        System.out.println("cwa "+cwa);


//        find first non repeating character
        String non = "stress";
        Character c = non.chars().mapToObj(m -> (char) m)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream().filter(ch -> ch.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(c);

        String string []= new String[]{"Sion","Sion","Harish"};

        Map<String,Long> hm2 = Arrays.stream(string).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("cnt of all string "+ hm2);
//        max sal
//        Employee maxe = employees.stream().max(Comparator.comparing(Emp::getSalary)).orElse(null)


//        select salary from (select salary, dense_rank() over(order by salary)) as rnk where rnk = 3;


//        Finding all the numbers starting with 1
        List<Integer> ls = new ArrayList<>(Arrays.asList(1,2,31,13,14,2,31));
        List<Integer> containg1s = ls.stream().map(i -> i.toString()).filter(nums -> nums.startsWith("1"))
                .map(num1 -> Integer.valueOf(num1)).toList();
        System.out.println("Arrays containing 1: "+ containg1s);

//        finding all the duplicate integers
        Set<Integer> set = new HashSet<>();
//        set returns true & false, so if the element is already present in set it will return false and will getting added
//        to the list of duplInt
        List<Integer> duplInt = ls.stream().filter(nums -> !set.add(nums)).toList();
        System.out.println("duplicate integers: " + duplInt);

//      using boxed()/IntStream().range() -> used to convert primitive to Wrapper
        int[] a = new int[]{1,2,3};
        Arrays.stream(a).boxed().findFirst().ifPresentOrElse(System.out::println, () -> System.out.println("is Empty"));

//        find max element present in the list
        Integer maxEl = ls.stream().max(Integer::compare).get();

//      find first non-repeating char in a string
        String nonR = "ssionn";
        Character nr =nonR.chars().mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().filter(e2 -> e2.getValue()==1)
                .map(e1 -> e1.getKey())
                .findFirst()
                .get();
        System.out.println("non-repeating char: "+nr);

//      check if the given list is distinct
        Set<Integer> set1 = new HashSet<>();
        Boolean checkDst = ls.stream().anyMatch(nums -> !set1.add(nums));
        System.out.println("Contains duplicate: "+checkDst);

//        perform cube on elements on list and filter out elements greater
//        than 50
        List<Integer> cubeList = ls.stream().distinct().map(i->(int) Math.pow(i,3)).filter(num -> num<=50).toList();
        System.out.println("Cube and less than 50: " + cubeList);

//        cnt of each character in a string
        Map<String,Long>cntChar = Arrays.stream(nonR.split(""))
                .collect(Collectors.groupingBy(c1 -> c1,Collectors.counting()));
        System.out.println("cnt of each char in a string: "+ cntChar);

//        SELECT salary FROM (
//                SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
//                FROM employees
//        )
//        WHERE rnk = 3;
        int[] fact = new int[]{2};

        List<Integer> ls2 = List.of(1,2,3);
        ls2.stream().map(i -> i * fact[0]).forEach(System.out::println);

        fact[0] = 0;
//         str.forEach(System.out::println);

//        Collection<Integer> cl = List.of(1,2,3);
//        cl.remove(1);
//
//        List<Integer> ls3 = List.of(1,2,3);;
//        ls.remove(1);
//
//        System.out.println();
//        String test = "asdasd";
//        test.chars().mapToObj(s-> Character.toLowerCase((char) s)).

        String nrs = "leetcode";

        Optional<Character> c1 = nrs.chars().mapToObj(ch-> (char) ch).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(hms -> hms.getValue()==1).map(vals -> vals.getKey()).findFirst();
        System.out.println(c1.get());
    }
}

