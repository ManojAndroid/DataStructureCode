package com.learning;

import java.util.*;

public class ManagerEmployeeHierarchy {

        // A map where key is manager and value is the list of employees reporting directly to them
        static Map<String, List<String>> manEmpMap = new HashMap<>();

        // Method to recursively collect all employees (direct and indirect) reporting to the manager
        public static Set<String> collectEmployees(String manager) {
            Set<String> allEmployees = new HashSet<>();

            // Get the list of employees reporting directly to the manager
            List<String> employees = manEmpMap.get(manager);

            // If no employees are found, return empty set
            if (employees == null) {
                return allEmployees;
            }

            // For each direct report, collect all employees under them
            for (String employee : employees) {
                // Add the direct report to the set
                allEmployees.add(employee);
                // Recursively add the indirect subordinates (employees reporting to this employee)
                allEmployees.addAll(collectEmployees(employee));
            }

            return allEmployees;
        }

        public static void main(String[] args) {
            // Populate the manager-employee map
            manEmpMap.put("A", Arrays.asList("a1", "a2", "a3"));
            manEmpMap.put("a1", Arrays.asList("b1", "b2", "b3"));
            manEmpMap.put("b1", Arrays.asList("c1", "c2", "c3"));
            manEmpMap.put("c1", Arrays.asList("d1", "d2", "d3"));

            // You can add more hierarchy if needed

            // Get the set of all employees reporting to manager A
            Set<String> result = collectEmployees("A");

            // Print the result
            System.out.println("Employees reporting to A:");
            System.out.println(result);
        }
    }

