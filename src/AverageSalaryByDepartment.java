import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class AverageSalaryByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ram", "IT", 50000));
        employees.add(new Employee("Krishna", "HR", 50000));
        employees.add(new Employee("Ganesh", "Finance", 50000));
        employees.add(new Employee("Shiva", "HR", 50000));
        employees.add(new Employee("Sai", "IT", 50000));
        employees.add(new Employee("Bob", "HR", 60000));
        employees.add(new Employee("Charlie", "Engineering", 70000));
        employees.add(new Employee("David", "Engineering", 80000));
        employees.add(new Employee("Emma", "Finance", 70000));
        employees.add(new Employee("Frank", "Finance", 90000));

        Map<String, Double> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
        averageSalary.forEach((dept,salary)->{
            System.out.println(dept+":"+salary);
        });

    }
}
