import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/////////////////////////////////////////////////////////////////////////////
//Semester:         CS400 Spring 2018
//PROJECT:          CS400_Program2
//FILES:            Graph.java, GraphADT.java, GraphProcessor.java, 
//GraphTest.java, WordProcessor.java
//
//USER:             sdwood3, adwinter, yxu368, jwindorf, zwille
//
//Instructor:       Deb Deppeler (deppeler@cs.wisc.edu)
//Bugs:             No known bugs
//
//2018 Apr 14, 2018 GraphProcessor.java
////////////////////////////////////////////////////////////////////////////

/**
 * This class adds additional functionality to the graph as a whole.
 * <p>
 * Contains an instance variable, {@link #graph}, which stores information for all the vertices and edges.
 *
 * @author sapan (sapan@cs.wisc.edu)
 * @see #populateGraph(String)
 * - loads a dictionary of words as vertices in the graph.
 * - finds possible edges between all pairs of vertices and adds these edges in the graph.
 * - returns number of vertices added as Integer.
 * - every call to this method will add to the existing graph.
 * - this method needs to be invoked first for other methods on shortest path computation to work.
 * @see #shortestPathPrecomputation()
 * - applies a shortest path algorithm to precompute data structures (that store shortest path data)
 * - the shortest path data structures are used later to
 * to quickly find the shortest path and distance between two vertices.
 * - this method is called after any call to populateGraph.
 * - It is not called again unless new graph information is added via populateGraph().
 * @see #getShortestPath(String, String)
 * - returns a list of vertices that constitute the shortest path between two given vertices,
 * computed using the precomputed data structures computed as part of {@link #shortestPathPrecomputation()}.
 * - {@link #shortestPathPrecomputation()} must have been invoked once before invoking this method.
 * @see #getShortestDistance(String, String)
 * - returns distance (number of edges) as an Integer for the shortest path between two given vertices
 * - this is computed using the precomputed data structures computed as part of {@link #shortestPathPrecomputation()}.
 * - {@link #shortestPathPrecomputation()} must have been invoked once before invoking this method.
 */
public class GraphProcessor {

    /**
     * Graph which stores the dictionary words and their associated connections
     */
    private GraphADT<String> graph;

    /**
     * Constructor for this class. Initializes instances variables to set the starting state of the object
     */
    public GraphProcessor() {
        this.graph = new Graph<>();
    }

    /**
     * Builds a graph from the words in a file. Populate an internal graph, by adding words from the dictionary as vertices
     * and finding and adding the corresponding connections (edges) between
     * existing words.
     * <p>
     * Reads a word from the file and adds it as a vertex to a graph.
     * Repeat for all words.
     * <p>
     * For all possible pairs of vertices, finds if the pair of vertices is adjacent {@link WordProcessor#isAdjacent(String, String)}
     * If a pair is adjacent, adds an undirected and unweighted edge between the pair of vertices in the graph.
     *
     * @param filepath file path to the dictionary
     * @return Integer the number of vertices (words) added
     */
    public Integer populateGraph(String filepath) {
        Stream<String> stream = null;
        try {
            stream = WordProcessor.getWordStream(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Holds the strings found in stream in an ArrayList
        ArrayList<String> streamToList = stream.collect(Collectors.toCollection(ArrayList::new));
        
        //Add all the elements in streamToList into the graph as vertexes
        for (int i = 0; i < streamToList.size(); i++) {
            graph.addVertex(streamToList.get(i));
        }
        
        //Test every vertex against every vertex to see if they are adjacent. If true, then an edge is created
        //between the two
        for (int i = 0; i < streamToList.size(); i++) {
            for (int j = i + 1; j < streamToList.size(); j++) {
                if (WordProcessor.isAdjacent(streamToList.get(i), streamToList.get(j))) {
                    graph.addEdge(streamToList.get(i), streamToList.get(j));
                }
            }
        }
        return streamToList.size();
    }


    /**
     * Gets the list of words that create the shortest path between word1 and word2
     * <p>
     * Example: Given a dictionary,
     * cat
     * rat
     * hat
     * heat
     * wheat
     * kit
     * shortest path between cat and wheat is the following list of words:
     * [cat, hat, heat, wheat]
     *
     * @param word1 first word
     * @param word2 second word
     * @return List<String> list of the words
     */
    public List<String> getShortestPath(String word1, String word2) {
        HashMap<String, String> previous =
                        new HashMap<String, String>(); //the key the current node and the value is the previous node
        PriorityQueue<String> pq = new PriorityQueue<String>();
        ArrayList<String> Visited = new ArrayList<String>();
        List<String> shortestPath = new ArrayList<String>();
        String current = word1;
        previous.put(word1, null);
        pq.add(word1);
        Visited.add(current);
        while (!pq.isEmpty()) {
            current = pq.remove();
            if (current.equals(word2)) {
                break;
            } else {
                for (String nextWord : graph.getNeighbors(current)) {
                    if (!Visited.contains(nextWord)) {
                        pq.add(nextWord);
                        Visited.add(nextWord);
                        previous.put(nextWord, current);
                    }
                }
            }
        }

        if (!current.equals(word2)) {
            return null; //Gone through all of them but no path
        }

        for (String word = word2; word != null; word = previous.get(word)) {
            shortestPath.add(word);
        }
        return reverse(shortestPath);
    }

    private List<String> reverse(List<String> list) {
        List<String> reversed = new ArrayList<String>();
        for (int last = list.size() - 1; last >= 0; last--) {
            reversed.add(list.get(last));
        }
        return reversed;
    }

    /**
     * Gets the distance of the shortest path between word1 and word2
     * <p>
     * Example: Given a dictionary,
     * cat
     * rat
     * hat
     * heat
     * wheat
     * kit
     * distance of the shortest path between cat and wheat, [cat, hat, heat, wheat]
     * = 3 (the number of edges in the shortest path)
     *
     * @param word1 first word
     * @param word2 second word
     * @return Integer distance
     */
    public Integer getShortestDistance(String word1, String word2) {
        return getShortestPath(word1, word2).size()-1;
    }

    /**
     * Computes shortest paths and distances between all possible pairs of vertices.
     * This method is called after every set of updates in the graph to recompute the path information.
     * Any shortest path algorithm can be used (Djikstra's or Floyd-Warshall recommended).
     */
    public void shortestPathPrecomputation() {

    }
}
