package tj.mirboboev.challenges;

import java.util.*;
import java.util.stream.Collectors;

public class CriticalConnectionsInANetwork {
    public static void main(String[] args) {
        // [[0,1],[1,2],[2,0],[1,3]]
        List<List<Integer>> connections = new ArrayList<>();

        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        System.out.println(criticalConnections(4, connections));
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<List<Integer>>> connectionsMap = buildConnectionMap(connections);

        Set<Integer> allNodes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            allNodes.add(i);
        }

        for (List<Integer> connection : connections) {
            Map<Integer, Set<Integer>> collectedNodes = new HashMap<>();

            traverse(connection.get(0),
                    connectionsMap,
                    new HashSet<>(),
                    connection,
                    collectedNodes);
        }

        return result.stream().distinct().collect(Collectors.toList());
    }

    public static void traverse(int node,
                                Map<Integer, List<List<Integer>>> connectionsMap,
                                Set<List<Integer>> visited,
                                List<Integer> excludedConnection,
                                Map<Integer, Set<Integer>> collectedNodes) {
        Set<Integer> nodeSeenNodes = collectedNodes.getOrDefault(node, new HashSet<>());
        collectedNodes.put(node, nodeSeenNodes);

        if (nodeSeenNodes.contains(node)) {
            return;
        }

        nodeSeenNodes.add(node);

        for (List<Integer> connection : connectionsMap.get(node)) {
            if (!visited.contains(connection) && !connection.equals(excludedConnection)) {
                visited.add(connection);
                traverse(connection.get(0), connectionsMap, visited, excludedConnection, collectedNodes);
                traverse(connection.get(1), connectionsMap, visited, excludedConnection, collectedNodes);
            }
        }
    }

    public static Map<Integer, List<List<Integer>>> buildConnectionMap(List<List<Integer>> connections) {
        Map<Integer, List<List<Integer>>> connectionsMap = new HashMap<>();

        connections.forEach(connection -> {
            int a = connection.get(0);
            int b = connection.get(1);

            List<List<Integer>> connectionsOfA = connectionsMap.getOrDefault(a, new ArrayList<>());
            List<List<Integer>> connectionsOfB = connectionsMap.getOrDefault(b, new ArrayList<>());

            connectionsOfA.add(connection);
            connectionsOfB.add(connection);

            connectionsMap.put(a, connectionsOfA);
            connectionsMap.put(b, connectionsOfB);
        });

        return connectionsMap;
    }
}
