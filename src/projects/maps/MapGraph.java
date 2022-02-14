package projects.maps;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MapGraph {

    private int vertices;

    ArrayList<Edge> verticesList[];

    private boolean visited [];

    public ArrayList<Edge>[] getVerticesList() {
        return verticesList;
    }

    public MapGraph(int vertices) {
        this.vertices = vertices;
        verticesList = new ArrayList[vertices];
        visited = new boolean[vertices];

        for(int node = 0;  node < vertices; node++ ) {
            verticesList[node] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        Edge edge = new Edge(source, destination);
        verticesList[source].add(edge);
    }

    public void addWeightedEdge(int source, int destination, int wt) {
        Edge edge = new Edge(source, destination, wt);
        verticesList[source].add(edge);
    }

    public void printGraph() {
        for(int node = 0;  node < vertices; node++ ) {
            ArrayList<Edge> neighbours = verticesList[node];

            for(int j = 0; j < neighbours.size(); j++) {
                System.out.println("Vertex - " + node + " is connected to - " +
                        neighbours.get(j).getDestination());
            }
        }
    }

    public void dfs(int vertex) {
        visited[vertex] = true;
        System.out.println("Visited Vertex " + vertex);

        ArrayList<Edge> neighbours = verticesList[vertex];

        for(int j = 0; j < neighbours.size(); j++) {
            if(!visited[neighbours.get(j).getDestination()]) {
                dfs(neighbours.get(j).getDestination());
            }
        }
    }


    public boolean isConnected(int source) {

        visited = new boolean[vertices];
        dfs(0);

        int visitedCount = 0;

        for(int i = 0; i< visited.length; i++) {
            if(visited[i]) {
                visitedCount++;
            }
        }

        if(visitedCount == verticesList.length)  {
            return  true;
        }
        return false;
    }

    public void dfsIterative(int vertex) {
        visited = new boolean[vertices];

        Stack<Integer> stack = new Stack<>();

        stack.push(vertex);

        while(!stack.isEmpty()) {
            vertex = stack.pop();
            System.out.println("Visited Vertex " + vertex);
            visited[vertex] = true;

            ArrayList<Edge> neighbours = verticesList[vertex];

            for (int j = 0; j < neighbours.size(); j++) {
                if (!visited[neighbours.get(j).getDestination()]) {
                    stack.push(neighbours.get(j).getDestination());
                }
            }
        }
    }


    public void bfs(int vertex) {
        visited = new boolean[vertices];

        Queue<Integer> verticesQueue = new LinkedList<>();

        verticesQueue.add(vertex);
        visited[vertex] = true;

        while(!verticesQueue.isEmpty()) {

            vertex = verticesQueue.poll();

            System.out.println(vertex);

            ArrayList<Edge> neighbours = verticesList[vertex];

            for (int j = 0; j < neighbours.size(); j++) {
                if (!visited[neighbours.get(j).getDestination()]) {
                    verticesQueue.add(neighbours.get(j).getDestination());
                    visited[neighbours.get(j).getDestination()] = true;
                }
            }
        }
    }

    public void bfsRecursive(int vertex) {
        visited = new boolean[vertices];

        Queue<Integer> verticesQueue = new LinkedList<>();
        verticesQueue.add(vertex);
        visited[vertex] = true;
        helper(verticesQueue);
    }

    private void helper(Queue<Integer> verticesQueue) {

        if(verticesQueue.isEmpty()) {
            return;
        }

        int vertex = verticesQueue.poll();

        System.out.println(vertex);

        ArrayList<Edge> neighbours = verticesList[vertex];

        for (int j = 0; j < neighbours.size(); j++) {
            if (!visited[neighbours.get(j).getDestination()]) {
                verticesQueue.add(neighbours.get(j).getDestination());
                visited[neighbours.get(j).getDestination()] = true;
            }
        }

        helper(verticesQueue);

    }


}