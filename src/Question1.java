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
     * Contains the API necessary for a simple, (optionally) weighted directed graph.
     * We call the graph "optionally weighted" because it can be used by algorithms that use weights
     * (like Dijkstra's) and by algorithms that do not (like BFS). An algorithm like BFS would simply
     * ignore any weights present.
     * <p>
     * By convention, the n vertices will be labeled 0,1,...,n-1. The edge weights can be any int value.
     * Since we are labeling vertices from 0 to n-1, you may find arrays/arraylists helpful!
     * Self loops and parallel edges are not allowed. Your implementation should use O(m + n) space.
     * Please DO NOT use adjacency matrices!
     * <p>
     * Also note that the runtimes given are expected runtimes. As a result, you should be
     * implementing your graph using a HashMap as the primary data structure for the adjacency list.
     * <p>
     * Notice that this class also supports undirected graph. Which means you can implement an
     * undirected graph as each undirected edge between u and v being two directed edge from u to v and
     * from v to u.
     */
    static class Graph {
        //list of nodes' hashMap adjacency lists
        private ArrayList<HashMap<Integer, Integer>> totList;
        
        
        /**
         * Initializes a graph of size {@code n}. All valid vertices in this graph thus have integer
         * indices in the half-open range {@code [0, n)}, n > 0.
         * <p/>
         * Do NOT modify this constructor header.
         *
         * @param n the number of vertices in the graph
         * @throws IllegalArgumentException if {@code n} is zero or negative
         * @implSpec This method should run in O(n) time
         */
        public Graph(int n) {
            if (n <= 0) {
                throw new IllegalArgumentException();
            }
            totList = new ArrayList<HashMap<Integer,Integer>>(n); //size of adj list
            for (int i = 0; i < n; i++) { //O(n) time to go through each of n nodes
                totList.add(new HashMap<Integer, Integer>()); //add adj list for each node
            }
        }

        /**
         * Returns the number of vertices in the graph.
         * <p/>
         * Do NOT modify this method header.
         *
         * @return the number of vertices in the graph
         * @implSpec This method should run in O(1) time.
         */
        public int getSize() {
            return totList.size(); //constant time to return
        }

        /**
         * Determines if there's an directed edge from u to v.
         * <p/>
         * Do NOT modify this method header.
         *
         * @param u a vertex
         * @param v a vertex
         * @return {@code true} if the {@code u-v} edge is in this graph
         * @throws IllegalArgumentException if a specified vertex does not exist
         * @implSpec This method should run in O(1) time.
         */
        public boolean hasEdge(int u, int v) {
            //check first if vertices exist in constant time
            if (totList.size() <= u || u < 0) {
                throw new IllegalArgumentException();
            }
            if (totList.size() <= v || v < 0) {
                throw new IllegalArgumentException();
            }
            return (totList.get(u).containsKey(v)); //constant time check if list has key 
        }

        /**
         * Returns the weight of an the directed edge {@code u-v}.
         * <p/>
         * Do NOT modify this method header.
         *
         * @param u source vertex
         * @param v target vertex
         * @return the edge weight of {@code u-v}
         * @throws NoSuchElementException   if the {@code u-v} edge does not exist
         * @throws IllegalArgumentException if a specified vertex does not exist
         * @implSpec This method should run in O(1) time.
         */
        public int getWeight(int u, int v) {
            //checks in constant time using hasEdge constant method
            if (!hasEdge(u,v)) {
                throw new NoSuchElementException();
            }
            if (totList.size() <= u || u < 0) {
                throw new IllegalArgumentException();
            }
            if (totList.size() <= v || v < 0) {
                throw new IllegalArgumentException();
            }
            return (totList.get(u).get(v)); //constant to get weight
        }

        /**
         * Creates an edge from {@code u} to {@code v} if it does not already exist. A call to this
         * method should <em>not</em> modify the edge weight if the {@code u-v} edge already exists.
         * <p/>
         * Do NOT modify this method header.
         *
         * @param u      the source vertex to connect
         * @param v      the target vertex to connect
         * @param weight the edge weight
         * @return {@code true} if the graph changed as a result of this call, false otherwise (i.e., if
         * the edge is already present)
         * @throws IllegalArgumentException if a specified vertex does not exist or if u == v
         * @implSpec This method should run in O(1) time
         */
        public boolean addEdge(int u, int v, int weight) {
            //checks in constant time
            if (totList.size() <= u || u < 0) {
                throw new IllegalArgumentException();
            }
            if (totList.size() <= v || v < 0) {
                throw new IllegalArgumentException();
            }
            if (u == v) {
                throw new IllegalArgumentException();
            }
            if (hasEdge(u,v)) { //checks if edge exists in constant time then does not modify
                return false;
            } else { //constant time to add edge, and return true
                totList.get(u).put(v, weight);
                return true;
            }
        }

        /**
         * Returns the out-neighbors of the specified vertex.
         * <p/>
         * Do NOT modify this method header.
         *
         * @param v the vertex
         * @return all out neighbors of the specified vertex or an empty set if there are no out
         * neighbors
         * @throws IllegalArgumentException if the specified vertex does not exist
         * @implSpec This method should run in O(outdeg(v)) time.
         */
        public Set<Integer> outNeighbors(int v) {
            //constant check if v is in bounds
            if (totList.size() <= v || v < 0) {
                throw new IllegalArgumentException();
            }
            return totList.get(v).keySet(); //O(outdeg(v)) to go through keys of v (v's adjacent nodes)
        }
    }

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
        Graph flights = new Graph(numFlights);
        List<Integer> topOrder = new ArrayList<Integer>(); //Node Finish Times
        for (int i = 0; i < conditions.length; i++) {
            flights.addEdge(conditions[i][1], conditions[i][0], 1);
        }
        List<Integer> finishTimes = depthFirst(flights, 0);
        for (int i = finishTimes.size() - 1; i > 0;  i++) {
            topOrder.add(finishTimes.get(i));
        }
        return finishTimes;
    }
    
    //run DFS from node x, get all nodes reachable from x
    static List<Integer> depthFirst(Graph g, int x) {
        Set<Integer> depNodes = new TreeSet<Integer>(); //keep reachable nodes
        boolean[] visited = new boolean[g.getSize()]; //keep visited nodes
        List<Integer> finishTimes = new ArrayList<Integer>(); //Node Finish Times
        return depthFirstVisit(g, x, depNodes, visited, finishTimes);
    }
    
    //run DFS from node x, takes O(n + m) time as go through each node and its adjacent vertices
    //which from lecture takes O(n + 2m) from handshake lemma, or O(n + m)
    static List<Integer> depthFirstVisit(Graph g, int x, Set<Integer> fin, boolean[] visited, 
            List<Integer> finishTimes) {
        visited[x] = true; //mark x as visited
        fin.add(x); //add to nodes in dfs tree from x
            
        //get all adjacent and recurse deeper into each adjacent node until no more adjacent
        Set<Integer> adj = g.outNeighbors(x);
        Iterator<Integer> adjIter = adj.iterator(); //go through each adjacent node and recurse
        while (adjIter.hasNext()) {
            int next = adjIter.next();
            if (!visited[next]) { //if not already seen, recurse
                depthFirstVisit(g, next, fin, visited, finishTimes);
            }
        }
        finishTimes.add(x);
        
        return finishTimes;
    }
    
    public static void main (String args[]) {
        int[][] conditions =  {{3, 2}, {1, 2}, {0, 3}, {0, 1}};
        Graph g = new Graph (4);
        g.addEdge(2, 3, 1);
        g.addEdge(2, 1, 1);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 3, 1);
        System.out.print(depthFirst(g,0));
        System.out.print(getFlightDepartureSchedule(4,conditions));
    }
}
