package projects.maps;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author amgarg
 */
class Pair implements  Comparable<Pair> {
    int vertex;

    String path;

    int distanceSoFar;

    public Pair(int vertex, String path, int distanceSoFar) {
        this.vertex = vertex;
        this.path = path;
        this.distanceSoFar = distanceSoFar;
    }

    @Override
    public int compareTo(Pair o) {
        return this.distanceSoFar - o.distanceSoFar;
    }
}
public class DijkstraAlgorithm {


    public static  void dijkstra(MapGraph mapGraph, int source, int destination) {
        boolean visited[] = new boolean[mapGraph.getVerticesList().length];

        //Vertex vs Distance
        int[] distanceNodes = new int[mapGraph.getVerticesList().length];

        Arrays.fill(distanceNodes, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(source, source + "", 0));

        while (!pq.isEmpty()) {

            Pair pair = pq.poll();

            if (visited[pair.vertex] == true) {
                continue;
            }
            visited[pair.vertex] = true;

            ArrayList<Edge>[] verticesList =
                    mapGraph.getVerticesList();

            ArrayList<Edge> neighbours = verticesList[pair.vertex];

            System.out.println(pair.vertex + " Path is " + pair.path + " Distance is " + pair.distanceSoFar);
            for (int j = 0; j < neighbours.size(); j++) {
                if (!visited[neighbours.get(j).getDestination()]) {

                    int newDistance = pair.distanceSoFar + neighbours.get(j).getWeight();

                    pq.add(new Pair(neighbours.get(j).getDestination(), pair.path + "" +
                            neighbours.get(j).getDestination(),
                            newDistance));
                }
            }
        }
    }
}
