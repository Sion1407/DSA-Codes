package Exercises.Streams;

import java.util.List;

public class Emp {
    private Integer id;
    private String name;
    private List<Long> phn;
    private Integer age;
    private String dept;
    private Double sal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getPhn() {
        return phn;
    }

    public void setPhn(List<Long> phn) {
        this.phn = phn;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Emp(Integer id, String name, List<Long> phn, Integer age, String dept, Double sal) {
        this.id = id;
        this.name = name;
        this.phn = phn;
        this.age = age;
        this.dept = dept;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phn=" + phn +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                ", sal=" + sal +
                '}';
    }
}
