package com.learning;

    import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

    public class ReportChain {
        public static void main(String[] args) {
            // Sample data
            Map<String, Set<String>> mapManager = new HashMap<>();

            // Define report chains
            mapManager.put("A", Set.of("B"));
            mapManager.put("B", Set.of("C"));
            mapManager.put("C", Set.of("D"));
            mapManager.put("D", Set.of()); // No one reports to D

            // Start with report A
            Set<String> allReports = getAllReports("A", mapManager, new HashSet<>());

            System.out.println("All recursive reports starting from A:");
            System.out.println(allReports);
        }

        // Recursive method to find all reports starting from a specific report
        public static Set<String> getAllReports(String report, Map<String, Set<String>> mapManager, Set<String> visited) {
            // To avoid revisiting the same report, we track visited reports
            if (visited.contains(report)) {
                return new HashSet<>();
            }

            visited.add(report);
            Set<String> result = new HashSet<>();
            result.add(report);

            // Recursively find reports that the current report refers to
            if (mapManager.containsKey(report)) {
                for (String subReport : mapManager.get(report)) {
                    result.addAll(getAllReports(subReport, mapManager, visited));
                }
            }

            return result;
        }

}
