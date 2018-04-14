import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/////////////////////////////////////////////////////////////////////////////
//Semester:         CS400 Spring 2018
//PROJECT:          CS400_Program2
//FILES:            Graph.java, GraphADT.java, GraphProcessor.java, 
//					GraphTest.java, WordProcessor.java
//
//USER:             sdwood3, adwinter, yxu368, jwindorf, zwille
//
//Instructor:       Deb Deppeler (deppeler@cs.wisc.edu)
//Bugs:             No known bugs
//
//2018 Apr 14, 2018 Graph.java
////////////////////////////80 columns wide //////////////////////////////////

/**
 * 
 * This Graph class is used to implement an undirected, unweighted graph. It 
 * implements GraphADT which provides methods that must be implemented. 
 * 
 */

public class Graph<E> implements GraphADT<E> {
    
	HashMap<E, Vertex<E>> vertices = new HashMap<>(); 
	ArrayList<Edge> neighbors = new ArrayList<>();
	
	/**
	 * 
	 * This Vertex class is inside of the Graph class and provides the 
	 * predecessor for the GraphProcessor class and the element which 
	 * refers to the HashMap.
	 * 
	 */
    public class Vertex<E>{
        private E element;
        private E predecessor = null;
        
        /**
         * Constructor used to create a new vertex.
         * 
         * @param element element of the new vertex
         */
        public Vertex(E element){
            this.element = element;
        }
        
        /**
         * Getter used to receive the element for a key of the HashMap.
         * 
         * @return element for the vertex
         */
        public E getElement(){
            return element;
        }

        /**
         * Setter used to set the element for a given key.
         * 
         * @param element element of the vertex
         */
        public void setElement(E element){
            this.element = element;
        }
       
        /**
         * Setter used to set the predecessor for a given element.
         * 
         * @param predecessor predecessor of the element called upon
         */
        public void setPredecessor(E predecessor) {
        	this.predecessor = predecessor;
        }
        
        /**
         * Getter used to receive the predecessor of a element.
         * 
         * @return predecessor of the element called upon
         */
        public E getPredecessor() {
        	return predecessor;
        }
    }

    /**
	 * 
	 * This Edge class is inside of the Graph class and is used to track 
	 * the edges that exist between two vertices. 
	 * 
	 */
    public class Edge{
        private Vertex source;
        private Vertex destination;

        /**
         * Constructor used to create a new edge
         * 
         * @param source one of the two vertices in the edge
         * @param destination the other of the two vertices in the edge
         */
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
        
        public boolean contains(E key) {
        	if (key.equals(source.getElement()) || 
        			key.equals(destination.getElement())) {
        		return true;
        	} return false;
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
        } return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeVertex(E vertex) {
    	if ((vertex != null) && (vertices.containsKey(vertex))) {
    		Iterator<Edge> i = neighbors.iterator();
    		
    		while (i.hasNext()) {
    			Edge e = i.next();
    			if (e.contains(vertex)) {
    				i.remove();
    			}
    		}   		
    		vertices.remove(vertex);
    		return vertex;
    	} return null;
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
    		for (int i = 0; i < neighbors.size(); i++) {
    			if ((neighbors.get(i).getDestination().element.equals(vertex1) && 
    					neighbors.get(i).getSource().element.equals(vertex2)) || 
    					(neighbors.get(i).getSource().element.equals(vertex1) && 
    					neighbors.get(i).getDestination().element.equals(vertex2))) {
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

