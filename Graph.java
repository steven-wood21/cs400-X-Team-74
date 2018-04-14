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
//new comment
public class Graph<E> implements GraphADT<E> {
    
	HashMap<E, Vertex<E>> vertices = new HashMap<>();
	protected List<List<Vertex<E>>> neighbors = new ArrayList<>();
	
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
    	if ((vertex != null) && !(vertices.containsValue(vertex))) {
        	vertices.put(vertex, new Node<>(vertex));
        	
        	for (E i : getAllVertices()) {
        		addEdge(vertex, i);
        	}
        	return vertex;
        } else return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeVertex(E vertex) {
    	if ((vertex != null) && !(vertices.containsValue(vertex))) {
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
    	if ((vertices.containsValue(vertex1) && vertices.containsValue(vertex2)) 
    			&& !(vertex1.equals(vertex2))) {
    		//Still need to do
    	} return false;
    }    

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeEdge(E vertex1, E vertex2) {
    	if ((vertices.containsValue(vertex1) && vertices.containsValue(vertex2)) 
    			&& !(vertex1.equals(vertex2))) {
    		//Still need to do
    	} return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdjacent(E vertex1, E vertex2) {
    	if ((vertices.containsValue(vertex1) && vertices.containsValue(vertex2)) 
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
        if (!(vertex == null) && (vertices.containsValue(vertex))) {
        	//Still need to do
        } return null; 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<E> getAllVertices() {
        return Iterator(vertices);  //Still need to do
    }

}

