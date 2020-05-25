import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

/**
 * <h1>QUESTION 2: ROOMMATE MATCHING</h1>
 * <p/>
 *
 * Class to implement the algorithm to select roommates from a 2d-array of pairs.
 * <p/>
 *
 * See description of problem and example in the write-up.
 *
 * @author bursztyn, 19sp
 */
public class Question2 {

    /**
     * Returns the set of roommates who mutually requested each other.
     *
     * @param requests the 2d-array of pairs of requests of the form (student, requested roommate).
     *                 Note: a student cannot request themself. 
     * @return a set of pairs of roommates who mutually requested each other
     * 
     * @implSpec you may assume that input is valid and non-null. Do not throw any exceptions.
     */
    public static Set<Pair<String, String>> findMatches(String[][] requests) {
        Arrays.sort(requests, new Comparator<String[]>() { 
            @Override
            public int compare(String[] o1, String[] o2) {
                return (o1[0].compareTo(o2[0]));
              }
          }); 
        
        for (int i = 0; i < requests.length; i++) {
            int lol = Arrays.binarySearch(requests, requests[1]);
        }
        return null;
    }
    
    
    
    public static void main (String args[]) {
        String [][] requests = { {"Steven", "Will"}, {"Helen", "Caroline"}, {"Caroline", "Monal"}, 
                {"Will", "Steven"} };
        System.out.print(Arrays.binarySearch(requests, "Steven"));
//        System.out.print(findMatches(requests));
    }
}
