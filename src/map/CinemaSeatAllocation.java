package map;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaSeatAllocation {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, List<Integer>> reservedSeatMap = new HashMap<>();
        int ans = 0;

        for(int [] row : reservedSeats) {
            if(reservedSeatMap.containsKey(row[0])) {
                reservedSeatMap.get(row[0]).add(row[1]);
            } else {
                reservedSeatMap.put(row[0], new ArrayList<>(Arrays.asList(row[1])));
            }
        }

        ans = (n - reservedSeatMap.size()) * 2;

        for(List<Integer> reservedSeatsList : reservedSeatMap.values()) {

            boolean isSettled = false;
            if(!reservedSeatsList.contains(2) && !reservedSeatsList.contains(3) &&
                    !reservedSeatsList.contains(4) && !reservedSeatsList.contains(5)) {
                ans++;
                isSettled = true;
            }

            if(!reservedSeatsList.contains(6) && !reservedSeatsList.contains(7) &&
                    !reservedSeatsList.contains(8) && !reservedSeatsList.contains(9)) {
                ans++;
                isSettled = true;
            }

            if(!isSettled) {
                if(!reservedSeatsList.contains(4) && !reservedSeatsList.contains(5) &&
                        !reservedSeatsList.contains(6) && !reservedSeatsList.contains(7)) {
                    ans++;
                }
            }

        }
        return ans;

    }
}
