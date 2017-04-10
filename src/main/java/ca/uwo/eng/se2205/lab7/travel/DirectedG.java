package ca.uwo.eng.se2205.lab7.travel;

import javax.annotation.Nullable;
import java.util.*;

/**
 * Created by PeakeAndSons on 2017-04-09.
 */
public class DirectedG <V,E> implements G<V,E> {

    @Override
    public Ed <E, V> newEdge(Ve<V, E> u, Ve<V, E> v, double weight) {
        DirectedEdge temp = new DirectedEdge(u,v,weight);
        DirectedVertex origin = (DirectedVertex)u;
        DirectedVertex dest = (DirectedVertex)v;
        origin.outEdges.add((Ed<E, V>) temp);
        origin.outgoing.put(u,temp);
        dest.inEdges.add((Ed<E,V>) temp);
        dest.incoming.put(v,temp);
        add = true;
        edges.add(temp);
        add = false;
        return temp;
    }

    public Collection<Ve<V,E>> vertices;
    public Collection<Ed<E,V>> edges;
    public boolean add;

    private class MyArrayList<T> extends AbstractList<T> {

        private int size;
        private T[] myArray;
        private int capacity;

        public MyArrayList(){
            int initialCapacity = 3;
            capacity = initialCapacity;
            size = 0;
            myArray = (T[]) new Object[capacity];
            add = false;
        }

        @SuppressWarnings("unchecked")
        public MyArrayList(List<? extends T> base) {
            myArray = (T[])base.toArray();
            size = base.size();
            capacity = base.size();
        }

        @SuppressWarnings("unchecked")
        public MyArrayList(int initialCapacity) {
            capacity = initialCapacity;
            size = 0;
            myArray = (T[]) new Object[capacity];
        }

        @Override
        public int size(){return size;}

        @Override
        public boolean isEmpty(){return size==0;}

        @Override
        public boolean remove(Object o){
            int indexOfO = indexOf(o);

            if(indexOfO == -1) {
                return false;
            }

            DirectedEdge edge = (DirectedEdge) (o);
            Ve<V,E>[] verts = edge.endpoints;
            DirectedVertex t = (DirectedVertex) verts[0];
            DirectedVertex z = (DirectedVertex) verts[1];
            DirectedEdge temp = (DirectedEdge) t.outgoing.remove(z);
            t.outEdges.remove(temp);
            DirectedEdge temp2 = (DirectedEdge) z.incoming.remove(t);
            z.inEdges.remove(temp2);

            remove(indexOfO);


            return true;
        }

        @Override
        public T remove(int index)throws IndexOutOfBoundsException{
            checkIndex(index, size);    //throws.

            T temp = myArray[index];

            for(int i = index + 1; i < size; i++) {
                myArray[i - 1] = myArray[i];
            }

            size--;
            return temp;
        }

        @Override
        public int indexOf(Object o){
            if(o == null) {
                for (int i = 0; i < size(); i++ ) {
                    if(myArray[i] == null){
                        return i;
                    }
                }
            }
            else {
                for (int i = 0; i < size; i++) {
                    if(myArray [i] != null && myArray [i].equals(o)){
                        return i;
                    }
                }
            }
            return -1;
        }

        @Override
        public void add(int i, T e)throws IndexOutOfBoundsException{
            checkIndex(i,size+1);   //throws exception.
            checkSize();
            for(int k=size-1;k>=i;k--){
                myArray[k+1]=myArray[k];
            }
            myArray[i]=e;
            size++;
        }

        @Override
        public boolean add(T e){
            if(add == false){
                throw new UnsupportedOperationException();
            }
            checkSize();
            this.myArray[size++] = e;
            return true;
        }

        private void checkIndex(int i, int n) throws IndexOutOfBoundsException{
            if((i<0) || (i >= n))
                throw new IndexOutOfBoundsException("Illegal index: "+ i);
        }

        private void checkSize(){
            if (size() >= capacity && capacity != 0) {
                T[] newM = myArray;
                capacity *= 2;
                myArray = (T[]) new Object[capacity];
                System.arraycopy(newM, 0, myArray, 0, size());
            }
            else if(size() >= capacity && capacity == 0) {
                capacity = 10;
                myArray = (T[]) new Object[capacity];
            }
        }

        @Override
        public boolean equals(Object o){
            if(! (o instanceof List<?>)) {
                return false;
            }
            if(o == this) {
                return true;
            }

            List<?> tmp = (List<?>)o;

            if(size() == tmp.size()) {
                for(int i = 0; i < size(); i++ ) {
                    if ( get(i) == null && get(i) != tmp.get(i)) {
                        return false;
                    } else if (get(i) != null && !(get(i)).equals(tmp.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("["); //= "[";
            for( int i =0; i< size; i++) {
                if(i==0){
                    sb.append(myArray[i]);
                }
                else {
                    sb.append(", ");
                    sb.append(myArray[i]);
                }
            }
            return sb +"]";
        }

        @Override
        public T get(int index) throws IndexOutOfBoundsException{
            checkIndex(index,size);     //throws
            return myArray[index];
        }

        @Override
        public T set(int index, T e) throws IndexOutOfBoundsException{
            checkIndex(index,size);     //throws
            T temp = myArray[index];
            myArray[index]=e;
            return temp;
        }
    }

    public DirectedG(){
        edges = new MyArrayList<Ed<E,V>>();
        vertices = new ArrayList<>();
    }

    @Override
    public Collection<? extends Ve<V, E>> vertices() {
        return this.vertices;
    }

    @Override
    public Ve<V, E> newVertex(V element) {
        DirectedVertex temp =  new DirectedVertex(element);
        vertices.add(temp);
        return temp;
    }

    @Override
    public Collection<? extends Ed<E, V>> edges() {
        return this.edges;
    }

    @Nullable
    @Override
    public Ed<E, V> getEdge(Ve<V, E> u, Ve<V, E> v) {
        DirectedVertex temp = (DirectedVertex)u;
        return temp.outgoing.get(u);
    }

    @Override
    public Collection<? extends Ed<E, V>> incomingEdges(Ve<V, E> v) {
        DirectedVertex vert =(DirectedVertex) v;
        return vert.incomingEdges();
    }

    @Override
    public Collection<? extends Ed<E, V>> outgoingEdges(Ve<V, E> v) {
        DirectedVertex vert = (DirectedVertex) v; ;
        return vert.outgoingEdges();
    }

    @Override
    public Collection<? extends Ed<E, V>> incidentEdges(Ve<V, E> v) {
        return null;
    }

    private class DirectedEdge implements Ed <E,V>{
        //all edges are direct ie route
        //so would contain from to where sort of thing.
        double weight;
        Ve<V,E> u;
        Ve<V,E> v;
        private Ve<V,E>[] endpoints;
        private DirectedEdge(Ve<V,E> st, Ve<V,E> end, double wght){
            this.u =st;
            this.v = end;
            this.weight = wght;
            endpoints = (Ve<V,E>[]) new Ve[]{u,v};
        }

        @Override
        public G<V, E> graph() {
            return null;
        }

        @Override
        public double getWeight() {
            return this.weight;
        }

        @Override
        public void setWeight(@Nullable double weight) {
            this.weight = weight;
        }

        @Override
        public Ve<V, E> u() {
            return this.u;
        }

        @Override
        public Ve<V, E> v() {
            return this.v;
        }

        @Override
        public Ve<V, E> opposite(Ve<V, E> vertex) {
            Ve<V,E>[] endpoints = this.endpoints;
            if (endpoints[0] == v)
                return endpoints[1];
            else// (endpoints[1] == v)
                return endpoints[0];
        }
    }

    private class DirectedVertex implements Ve<V,E>{
        V element;
        private Map<Ve<V,E>, Ed<E,V>> outgoing, incoming;
        Collection<Ed<E, V>> outEdges, inEdges;
        private DirectedVertex(V v){
            this.element = v;
            inEdges = new ArrayList<>();
            outEdges = new ArrayList<>();
            outgoing = new HashMap<>();
            incoming = new HashMap<>();
        }

        @Override
        public Collection<? extends Ed<E, V>> incomingEdges() {
            return inEdges;
        }

        @Override
        public Collection<? extends Ed<E, V>> outgoingEdges() {
            return outEdges;
        }

        @Override
        public G<V, E> graph() {
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

