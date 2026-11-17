package handson9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + "}";
    }
}

public class Main {
    public static void serialize(List<Employee> employees, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Berhasil men-serialize " + employees.size() + " objek ke " + filename);
        } catch (IOException ex) {
            System.out.println("Error serialize: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserialize: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        String filename = "emp.ser";

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("John", 30));
        list.add(new Employee("Dewi", 21));
        list.add(new Employee("Rina", 25));

        serialize(list, filename);

        List<Employee> restoredList = deserialize(filename);
        System.out.println("\nHasil Deserialized:");
        for (Employee emp : restoredList) {
            System.out.println("- " + emp);
        }
    }
}