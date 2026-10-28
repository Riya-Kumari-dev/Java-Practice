package streamapi;

import java.util.List;

public class StudentMarks {

    public static void main(String[] args) {

        // List containing student's marks
        List<Integer> marks = List.of(45, 60, 75, 60, 90, 45, 80, 75, 30);

        // Filter marks >= 60, remove duplicates, sort in ascending order, and collect the results
        List<Integer> selectedMarks = marks.stream()
                .filter(mark -> mark >= 60) // // We first select eligible marks and
                .distinct() // then remove duplicates from the selected elements.
                .sorted()  // arranges the remaining integers in ascending order.
                .toList(); // terminal operation that triggers processing and returns the results as an unmodifiable list

        // Display the processed marks
        System.out.println("Selected Marks: " + selectedMarks);

        // Count the distinct marks that are >= 60
        long count = marks.stream()
                .filter(mark -> mark >= 60)
                .distinct()
                .count(); //

        System.out.println("Number of Distinct Selected Marks: " + count);

        // Calculate the sum of all the distinct marks that are greater than or equal to 60.
        int result = marks.stream()
                .filter(mark -> mark >= 60)
                .distinct()
                .reduce(0, (a, b)-> a+b);

        System.out.println("Sum of all distinct marks >= 60 is "+result);
    }
}