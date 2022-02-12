package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author amgarg
 */

class Edge {
    int source;
    int destination;
    int weight;
}

public class Graph {

    int v;
    private List<Integer> adjancyList[];

    public Graph(int V) {
        this.v = V;

        adjancyList = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adjancyList[i] = new ArrayList<>();
        }
    }


    public void addEdgeInUndirected(int source, int destination) {
        adjancyList[source].add(destination);
        adjancyList[destination].add(source);
    }

    public void addEdgeInDirected(int source, int destination) {
        adjancyList[source].add(destination);
    }

    public List<Integer> getNeighbours(int source) {
        return adjancyList[source];
    }

    public void dfs() {

        boolean[] marked = new boolean[v];
        //Iterating over the vertices

        for (int i = 0; i < v; i++) {

            if (!marked[i]) {
                dfsHelper(i, marked);
            }
        }
    }

    private void dfsHelper(int currentVertex, boolean[] marked) {
        marked[currentVertex] = true;

        System.out.println(currentVertex + " ");
        List<Integer> neighbours = getNeighbours(currentVertex);

        for (Integer vertex : neighbours) {
            if (!marked[vertex]) {
                dfsHelper(vertex, marked);
            }
        }
    }


    public void bfs() {

        boolean[] marked = new boolean[v];
        //Iterating over the vertices

        for (int i = 0; i < v; i++) {

            if (!marked[i]) {
                bfsHelper(i, marked);
            }
        }
    }

    private void bfsHelper(int currentVertex, boolean[] marked) {
        Queue<Integer> queue = new LinkedList<>();

        marked[currentVertex] = true;

        queue.add(currentVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.println(vertex + " ");
            List<Integer> neighbours = getNeighbours(vertex);
            for (Integer neighbourVertex : neighbours) {
                if (!marked[neighbourVertex]) {
                    marked[neighbourVertex] = true;
                    queue.add(neighbourVertex);
                }
            }

        }
    }

}
