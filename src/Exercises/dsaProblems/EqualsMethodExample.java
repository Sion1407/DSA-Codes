package Exercises.dsaProblems;

import java.util.HashSet;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Check for self-comparison
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Check for null and type
        }
        Person person = (Person) obj; // Cast the object
        System.out.println("name: " + name.hashCode());
        return age == person.age && name.equals(person.name); // Compare fields
    }

//    @Override
//    public int hashCode() {
//        System.out.println(Objects.hash(name,age)+name.hashCode());
//        return Objects.hash(name, age); // Required when overriding equals
//    }
}

public class EqualsMethodExample {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Alice", 30);

        // Add persons to a HashSet
        HashSet<Person> set = new HashSet<>();
        set.add(person1);
        set.add(person2);

        // Print size of the HashSet
        System.out.println("HashSet size: " + set.size()); // Should be 1 if hashCode is implemented correctly

        // Test equality
        System.out.println("person1.equals(person2): " + person1.equals(person2)); // true
        System.out.println("person1.hashCode() == person2.hashCode(): " + (person1.hashCode() == person2.hashCode())); // true
    }
}
