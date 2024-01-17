package com.learning.CompanyQuestion.altimatrix;

import java.util.*;
/*
State Planning A planned state consists of cities connected by bidirectional roads of different types. For example, one road may be an expressway and another a boulevard. Each road can be described by three integers that represent the two connected cities and the road type. To reduce maintenance, some roads may be demolished. All others will be upgraded. If each city is to remain connected to all currently connected cities by the same type of road, determine the minimum number of roads of each type that will be upgraded Java program for existing method signature
Public static List<Integer> statePlanning(int numCities, int numRoads,int numTyles,List<integer> fromCity, List<integer> ftoCity, List<integer>roadType)
*/

public class StatePlanning {
    public static List<Integer> statePlanning(int numCities, int numRoads, int numTypes,
                                              List<Integer> fromCity, List<Integer> toCity,
                                              List<Integer> roadType) {

        // Create an adjacency list to represent the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < numRoads; i++) {
            int from = fromCity.get(i);
            int to = toCity.get(i);
            int type = roadType.get(i);

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, type});
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[]{from, type});
        }

        List<Integer> result = new ArrayList<>();

        // Track visited cities to handle multiple connected components
        Set<Integer> visited = new HashSet<>();

        for (int city = 1; city <= numCities; city++) {
            if (!visited.contains(city)) {
                visited.add(city);
                Map<Integer, Integer> typeCounts = new HashMap<>();

                // Depth-first search to traverse the connected component
                dfs(city, graph, visited, typeCounts);

                // Calculate minimum road upgrades for each road type in this component
                for (int t = 1; t <= numTypes; t++) {
                    result.add(typeCounts.containsKey(t) ? typeCounts.get(t) - 1 : 0);
                }
            }
        }

        return result;
    }

    // Depth-first search to traverse connected component and count road types
    private static void dfs(int city, Map<Integer, List<int[]>> graph, Set<Integer> visited,
                            Map<Integer, Integer> typeCounts) {
        List<int[]> connections = graph.getOrDefault(city, Collections.emptyList());

        for (int[] connection : connections) {
            int nextCity = connection[0];
            int type = connection[1];

            if (!visited.contains(nextCity)) {
                visited.add(nextCity);
                typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
                dfs(nextCity, graph, visited, typeCounts);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        int numCities = 4;
        int numRoads = 4;
        int numTypes = 2;

        List<Integer> fromCity = Arrays.asList(1, 1, 2, 3);
        List<Integer> toCity = Arrays.asList(2, 3, 4, 4);
        List<Integer> roadType = Arrays.asList(1, 2, 1, 2);

        List<Integer> result = statePlanning(numCities, numRoads, numTypes, fromCity, toCity, roadType);
        System.out.println(result); // Output the minimum number of roads to be upgraded for each type
    }
}
