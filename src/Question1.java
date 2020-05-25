import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * <h1>QUESTION 1: FLIGHT SCHEDULES</h1>
 * <p/>
 *
 * Class to implement the algorithm to determine a possible flight schedule given the conditions.
 * <p/>
 *
 * See description of problem and example in the write-up.
 *
 * @author bursztyn, 19sp
 */
public class Question1 {

    /**
     * Given the number of flights to schedule and conditions for departure, returns one possible
     * departure schedule.
     *
     * @param numFlights the number of flights waiting to take off
     * @param conditions the list of condition pairs (no duplicate pairs may exist)
     * @return one possible valid flight departure ordering, or an empty list if none exists
     * 
     * @implSpec you may assume that input is valid (well formatted, mx2 2d-array) and non-null.
     * Do not throw any exceptions.
     */
    public static List<Integer> getFlightDepartureSchedule(int numFlights, int[][] conditions) {
        int [] freq = new int[numFlights];
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < numFlights; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        ArrayList<Integer> finList = new ArrayList<Integer>();
        ArrayList<Integer> potential = new ArrayList<Integer>();
        for (int i = 0; i < conditions.length; i++) {
            adj.get(conditions[i][1]).add(conditions[i][0]);
            freq[conditions[i][0]]++;
        }
        
        for (int i = 0; i < freq.length; i ++) {
            if (freq[i] == 0) {
                potential.add(i);
            }
        }
        
        while (!potential.isEmpty()) {
            int num = potential.remove(0);
            finList.add(num);
            ArrayList<Integer> numAdj = adj.get(num);
            for (int eachNum : numAdj) {
                freq[eachNum]--;
                if (freq[eachNum] == 0) {
                    potential.add(eachNum);
                }
            }
        }
        
        return finList;
    }
    
    public static void main(String args[]) {
        int[][] conditions =  {{3, 2}, {1, 2}, {0, 3}, {0, 1}};
        System.out.print(getFlightDepartureSchedule(4,conditions));
    }
}
