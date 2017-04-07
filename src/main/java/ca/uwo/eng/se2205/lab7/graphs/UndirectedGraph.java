package ca.uwo.eng.se2205.lab7.graphs;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PeakeAndSons on 2017-04-05.
 */
public class UndirectedGraph<V,E> implements Graph<V,E> {
    private Collection<Vertex<V,E>> vertices;
    private Collection<Edge<E,V>> edges;
    UndirectedGraph(){
        edges = new ArrayList<>();
        vertices = new ArrayList<>();
    }
    @Override
    public Collection<? extends Vertex<V, E>> vertices() {
        return this.vertices;
    }

    @Override
    public Vertex<V, E> newVertex(V element) {
        UndirectedVertex temp =  new UndirectedVertex(element);
        vertices.add(temp);
        return temp;
    }

    @Override
    public Collection<? extends Edge<E, V>> edges() {
        return this.edges;
    }

    @Override
    public Edge<E, V> newEdge(Vertex<V, E> u, Vertex<V, E> v, E weight) {
        UndirectedEdge temp = new UndirectedEdge(u,v,weight);
        UndirectedVertex origin = (UndirectedVertex)u;
        UndirectedVertex dest = (UndirectedVertex)v;
        origin.outEdges.add((Edge<E, V>) temp);
        origin.outgoing.put(u,temp);
        dest.inEdges.add((Edge<E,V>) temp);
        edges.add(temp);
        return temp;
    }

    @Nullable
    @Override
    public Edge<E, V> getEdge(Vertex<V, E> u, Vertex<V, E> v) {
        UndirectedVertex temp = (UndirectedVertex) u;
        return temp.outgoing.get(u);
    }

    @Override
    public Collection<? extends Edge<E, V>> incomingEdges(Vertex<V, E> v) {
        UndirectedVertex vert =(UndirectedVertex) v;
        return vert.incomingEdges();
    }

    @Override
    public Collection<? extends Edge<E, V>> outgoingEdges(Vertex<V, E> v) {
        UndirectedVertex vert = (UndirectedVertex) v; ;
        return vert.outgoingEdges();
    }

    @Override
    public Collection<? extends Edge<E, V>> incidentEdges(Vertex<V, E> v) {
        return null;
    }

    private class UndirectedEdge implements Edge<E,V>{
        //all edges are direct ie route
        //so would contain from to where sort of thing.
        E weight;
        Vertex<V,E> u;
        Vertex<V,E> v;
        private UndirectedEdge(Vertex<V,E> st, Vertex<V,E> end, E wght){
            this.u =st;
            this.v = end;
            this.weight = wght;
        }

        @Override
        public Graph<V, E> graph() {
            return null;
        }

        @Override
        public E getWeight() {
            return this.weight;
        }

        @Override
        public void setWeight(@Nullable E weight) {
            this.weight = weight;
        }

        @Override
        public Vertex<V, E> u() {
            return this.u;
        }

        @Override
        public Vertex<V, E> v() {
            return this.v;
        }

        @Override
        public Vertex<V, E> opposite(Vertex<V, E> vertex) {
            return null;
        }
    }

    private class UndirectedVertex implements Vertex<V,E>{
        V element;
        Collection<Edge<E, V>> outEdges, inEdges;
        private Map<Vertex<V,E>, Edge<E,V>> outgoing;
        private UndirectedVertex(V v){
            this.element = v;
            outEdges = new ArrayList<>();
            inEdges = outEdges;
            outgoing = new HashMap<>();
        }

        @Override
        public Collection<? extends Edge<E, V>> incomingEdges() {
            return inEdges;
        }

        @Override
        public Collection<? extends Edge<E, V>> outgoingEdges() {
            return outEdges;
        }

        @Override
        public Graph<V, E> graph() {
            return null;
        }

        @Override
        public V getElement() {
            return this.element;
        }

        @Override
        public V setElement(V element) {
            if(element == null){
                throw new NullPointerException();
            }
            V temp = getElement();
            this.element =element;
            return temp;
        }
    }
}
