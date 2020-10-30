package tj.mirboboev.challenges;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(
                2, new int[][]{{1, 0}}
        )));
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(
                4, new int[][]{
                        {1, 0},
                        {2, 0},
                        {3, 1},
                        {3, 2},
                }
        )));
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(
                2, new int[][]{
                        {0, 1},
                        {1, 0}
                }
        )));
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(
                3, new int[][]{
                        {1, 0},
                        {1, 2},
                        {0, 1}
                }
        )));
    }

    /**
     * Algorithm:
     * ---------
     * create an adj list
     * iterate over adj list
     * for every iterated node
     * mark it as visited and in stack
     * if any of neighbors or their neighbors
     * has any dependency on in stack node
     * then there is cycle, and course could not be scheduled
     * (topological sorting)
     */
    boolean foundCycle = false;

    int nextIndex = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = toAdjList(prerequisites);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                topologicalSort(i, adjList, visited, recursionStack, result);
            }
        }

        if (foundCycle) {
            return new int[0];
        }

        return result;
    }

    private void topologicalSort(int course,
                                 Map<Integer, List<Integer>> adjList,
                                 Set<Integer> visited,
                                 Set<Integer> recursionStack,
                                 int[] result) {
        if (foundCycle) {
            return;
        }

        recursionStack.add(course);
        visited.add(course);

        for (int depCourse : adjList.getOrDefault(course, new ArrayList<>())) {
            if (!visited.contains(depCourse)) {
                recursionStack.add(depCourse);
                topologicalSort(depCourse, adjList, visited, recursionStack, result);
            } else if (recursionStack.contains(depCourse)) {
                foundCycle = true;
                return;
            }
        }

        recursionStack.remove(course);
        result[nextIndex] = course;
        nextIndex += 1;
    }

    public static Map<Integer, List<Integer>> toAdjList(int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] pre : prerequisites) {
            List<Integer> list = adjList.getOrDefault(pre[0], new ArrayList<>());
            list.add(pre[1]);
            adjList.putIfAbsent(pre[0], list);
        }

        return adjList;
    }
}
