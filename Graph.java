import java.util.HashMap;
import java.util.HashSet;
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
            this.element = element
        }
    }


    public class Edge{
        private Vertex source;
        private Vertex destination

        public Edge(Vertex source, Vertex destination){
            this.source = source;
            this.destination = destination;
        }

        public Node getDestination() {
            return destination;
        }

        public void setDestination(Node destination) {
            this.destination = destination;
        }
        public Node getSource() {
            return source;
        }

        public void setSource(Node source) {
            this.source = source;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E addVertex(E vertex) {
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeVertex(E vertex) {
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addEdge(E vertex1, E vertex2) {
        
    }    

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeEdge(E vertex1, E vertex2) {
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdjacent(E vertex1, E vertex2) {
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<E> getNeighbors(E vertex) {
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<E> getAllVertices() {
        
    }

}

public class Graph<E> implements GraphADT<E> {
    
	HashMap<E, Node<E>> vertices = new HashMap<>();
	protected List<List<Node<E>>> neighbors = new ArrayList<>();
	
	ArrayList<E> verticesList = ArrayList<vertices>;
    /**
     * Instance variables and constructors
     */

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
