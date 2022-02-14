package graphs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        HashMap<Integer, List<Integer>> stopVsBusMap = new HashMap<>();

        int cost = 0;

        if(source == target) {
            return cost;
        }

        //create a stop vs buses map
        for(int i = 0; i <  routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                int currentStop = routes[i][j];
                List<Integer> buses
                        = stopVsBusMap.getOrDefault(currentStop, new ArrayList<>());
                buses.add(i);
                stopVsBusMap.put(currentStop, buses);
            }
        }


        //apply bfs over the map
        queue.add(source);

        while (!queue.isEmpty()) {
            int size = queue.size();
            cost++;
            for(int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                List<Integer> buses =
                        stopVsBusMap.get(currentStop);

                for(int currentBus : buses) {
                    if(!visited.contains(currentBus)) {
                        //fetch the stops for this currentBus
                        int [] busStop = routes[currentBus];
                        for(int stop : busStop) {
                            if(stop == target) {
                                return cost;
                            }
                            queue.add(stop);
                        }
                        visited.add(currentBus);
                    }

                }
            }
        }
        return -1;
    }

}
