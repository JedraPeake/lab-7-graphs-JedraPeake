package ca.uwo.eng.se2205.lab7.travel;

import ca.uwo.eng.se2205.lab7.graphs.Edge;
import ca.uwo.eng.se2205.lab7.graphs.Vertex;

import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Created by PeakeAndSons on 2017-04-09.
 */
public interface G<V, E> {

    /**
     * Returns a collection of {@link Vertex} that works with the
     * {@code Graph}. Any change to the {@link Collection} will affect
     * the {@code Graph} itself.
     *
     * @return {@code Graph}-backed {@code Collection}
     */
    Collection<? extends Ve<V, E>> vertices();

    /**
     * Creates a new {@link Vertex} instance adding it to the {@code Graph}
     * @param element The stored element
     * @return New non-{@code null} {@code Vertex}
     */
    Ve<V, E> newVertex(V element);


    /**
     * Gets a collection of {@link Edge}s that is backed by the
     * {@code Graph}. Any change to the {@code Collection} will affect the
     * {@code Graph} itself.
     *
     * @return {@code Graph}-backed {@code Collection}
     */
    Collection<? extends Ed<E, V>> edges();

    /**
     * Create a new {@link Edge} instance or returns the existing {@code Edge}
     * @param u
     * @param v
     * @param weight
     * @return New non-{@code null} {@code Edge.Weighted}
     *
     * @throws ClassCastException if the {@link Vertex} implementation is not correct
     */
    Ed<E, V> newEdge(Ve<V, E> u, Ve<V, E> v, double weight);

    /**
     * Returns an edge between {@param u} and {@param v}. If the {@code Graph}
     * is Directed the order matters.
     * @param u First {@code Vertex}
     * @param v Second {@code Vertex}
     * @return Edge between two {@link Vertex}, {@code null} if it doesn't exist
     *
     * @throws ClassCastException if the {@link Vertex} implementation is not correct
     */
    @Nullable
    Ed<E, V> getEdge(Ve<V, E> u, Ve<V, E> v);


    /**
     * Gets the edges entering a {@link Vertex}
     * @param v
     * @return Non-{@code null} collection of {@link Edge}s, but possibly empty
     *
     * @throws ClassCastException if the {@link Vertex} implementation is not correct
     */
    Collection<? extends Ed<E, V>> incomingEdges(Ve<V, E> v);

    /**
     * Gets the edges exiting a {@link Vertex}
     * @param v
     * @return Non-{@code null} collection of {@link Edge}s, but possibly empty
     *
     * @throws ClassCastException if the {@link Vertex} implementation is not correct
     */
    Collection<? extends Ed<E, V>> outgoingEdges(Ve<V, E> v);

    /**
     +     * Gets all of the edges of a {@link Vertex}
     +     * @param v
     +     * @return Non-{@code null} collection of {@link Edge}s, but possibly empty
     +     *
     +     * @throws ClassCastException if the {@link Vertex} implementation is not correct
     +     */
    Collection<? extends Ed<E, V>> incidentEdges(Ve<V, E> v);

}

