package streamapi;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class EmployeeSalaryProcessing {
    public static void main(String[] args) {
        List<Integer> salaries = List.of(25_000, 40_000, 35_000, 50_000, 30_000, 45_000);

        salaries.stream() // creates a stream
                .filter(salary -> salary > 30_000) // select salaries above 30_000
                .map(salary -> salary + salary/10) // increase each selected salary by 10%
                .sorted() // sorts the updated salaries in ascending order
                .forEach(System.out::println); // prints each salary

        // find the highest salary
        Optional<Integer> max = salaries.stream()
                .max(Integer::compareTo);

        // print the salary only if a maximum value exists
        max.ifPresent(salary -> System.out.println("Highest Salary: " + salary));
    }
}