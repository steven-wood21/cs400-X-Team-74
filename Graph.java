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
        private Vertex destination;

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
