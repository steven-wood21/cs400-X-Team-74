import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Undirected and unweighted graph implementation
 * 
 * @param <E> type of a vertex
 * 
 * @author sapan (sapan@cs.wisc.edu)
 * 
 */

public class Graph<E> implements GraphADT<E> {
    
	HashMap<E, Vertex<E>> vertices = new HashMap<>();
	ArrayList<Edge> neighbors = new ArrayList<>();
	
    /**
     * Instance variables and constructors
     */
    public class Vertex<E>{
        private E element;

        public Vertex(E element){
            this.element = element;
        }

        public E getElement(){
            return element;
        }

        public void setElement(E element){
            this.element = element;
        }
    }

    
    public class Edge{
        private Vertex source;
        private Vertex destination;

        public Edge(Vertex source, Vertex destination){
            this.source = source;
            this.destination = destination;
        }

        public Vertex getDestination() {
            return destination;
        }

        public void setDestination(Vertex destination) {
            this.destination = destination;
        }
        public Vertex getSource() {
            return source;
        }

        public void setSource(Vertex source) {
            this.source = source;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E addVertex(E vertex) {
    	if ((vertex != null) && !(vertices.containsKey(vertex))) {
        	vertices.put(vertex, new Vertex<>(vertex));
        	return vertex;
        } else return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeVertex(E vertex) {
    	if ((vertex != null) && !(vertices.containsKey(vertex))) {
    		for (E i : getAllVertices()) {
    			if (isAdjacent(vertex, i)) {
    				removeEdge(vertex, i);
    			}
    		}
    		
    		vertices.remove(vertex);
    		return vertex;
    	} else return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addEdge(E vertex1, E vertex2) {
    	if ((vertices.containsKey(vertex1) && vertices.containsKey(vertex2)) 
    			&& !(vertex1.equals(vertex2))) {
    		neighbors.add(new Edge(vertices.get(vertex1), vertices.get(vertex2)));
    		return true;
    	} return false;
    }    

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeEdge(E vertex1, E vertex2) {
    	if ((vertices.containsKey(vertex1) && vertices.containsKey(vertex2)) 
    			&& !(vertex1.equals(vertex2))) {
    		for (Edge i : neighbors) {
    			if ((i.getDestination().equals(vertex1) && i.getSource().equals(vertex2)) || 
    					(i.getSource().equals(vertex1) && i.getDestination().equals(vertex1))) {
    				neighbors.remove(i);
    			}
    		}
    		return true;
    	} return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdjacent(E vertex1, E vertex2) {
    	if ((vertices.containsKey(vertex1) && vertices.containsKey(vertex2)) 
    			&& !(vertex1.equals(vertex2))) {
	        for (E i : getNeighbors(vertex1)) {
	        	if (i.equals(vertex2)) {
	        		return true;
	        	}
	        } return false;
    	} return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<E> getNeighbors(E vertex) {
        if (!(vertex == null) && (vertices.containsKey(vertex))) {
        	ArrayList<E> localNeighbors = new ArrayList<E>();
        	
        	for (Edge i : neighbors) {
        		if (i.getDestination().getElement().equals(vertex)) {
        			localNeighbors.add((E) i.getSource().getElement());
        		} else if (i.getSource().getElement().equals(vertex)) {
        			localNeighbors.add((E) i.getDestination().getElement());
        		}
        	}
        	return localNeighbors;
        } return null; 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<E> getAllVertices() {
        return vertices.keySet();  
    }

}

