package graphs;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {

    List<Integer>[] graph;
    boolean [] visited;
    boolean[] processed;
    Stack<Integer> stack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //Build Graph
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        processed = new boolean[numCourses];
        visited = new boolean[numCourses];

        //Checking cycle
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(isCyclicHelper(i)) {
                    return new int[]{};
                }
            }
        }

        //Topological sorting
        visited = new boolean[numCourses];
        stack = new Stack<>();
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                getTopologicalSortOrder(i);
            }

        }

        int [] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }

        return res;


    }

    private void getTopologicalSortOrder(int currentVertex) {

        visited[currentVertex] = true;

        List<Integer> neighbours = graph[currentVertex];

        for (Integer vertex : neighbours) {
            if (!visited[vertex]) {
                getTopologicalSortOrder(vertex);
            }
        }
        stack.push(currentVertex);
    }

    private boolean isCyclicHelper(int currentVertex) {
        visited[currentVertex] = true;

        List<Integer> neighbours = graph[currentVertex];

        for (Integer vertex : neighbours) {
            if (!visited[vertex]) {
                if(isCyclicHelper(vertex)) {
                    return true;
                }
            } else if (!processed[vertex]) {
                return true;
            }
        }
        processed[currentVertex] = true;
        return false;
    }

}
