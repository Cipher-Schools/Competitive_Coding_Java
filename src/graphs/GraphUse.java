package graphs;


import java.util.List;

public class GraphUse {


    public static void main(String[] args) {

        Graph graph = new Graph(7);
        graph.addEdgeInUndirected(0, 1);
        graph.addEdgeInUndirected(1, 2);
        graph.addEdgeInUndirected(2, 3);
        graph.addEdgeInUndirected(3,4);
        graph.addEdgeInUndirected(4, 5);
        graph.addEdgeInUndirected(4, 1);
        graph.addEdgeInUndirected(2, 6);
        graph.addEdgeInUndirected(5, 6);


        List<Integer> neighbours =
                graph.getNeighbours(6);

      graph.bfs();

    }
}
