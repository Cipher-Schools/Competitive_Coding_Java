package projects.maps;

/**
 * @author amgarg
 */
public class ShortestPath {


    public static void main(String[] args) {

        MapGraph mapGraph = new MapGraph(6);
        mapGraph.addWeightedEdge(0, 5, 10);
        mapGraph.addWeightedEdge(5, 0, 10);

        mapGraph.addWeightedEdge(0, 1, 10);
        mapGraph.addWeightedEdge(1, 0, 10);

        mapGraph.addWeightedEdge(5, 2, 20);
        mapGraph.addWeightedEdge(2, 5, 20);

        mapGraph.addWeightedEdge(1, 2, 5);
        mapGraph.addWeightedEdge(2, 1, 5);

        mapGraph.addWeightedEdge(1, 2, 5);
        mapGraph.addWeightedEdge(2, 1, 5);

        mapGraph.addWeightedEdge(2, 4, 5);
        mapGraph.addWeightedEdge(4, 2, 5);

        mapGraph.addWeightedEdge(2, 3, 20);
        mapGraph.addWeightedEdge(3, 2, 20);

        mapGraph.addWeightedEdge(3, 4, 10);
        mapGraph.addWeightedEdge(4, 4, 10);

        DijkstraAlgorithm.dijkstra(mapGraph,1);




    }
}
