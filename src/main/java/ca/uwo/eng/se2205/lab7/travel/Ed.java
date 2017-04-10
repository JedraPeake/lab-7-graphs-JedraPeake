package ca.uwo.eng.se2205.lab7.travel;

import ca.uwo.eng.se2205.lab7.graphs.Edge;
import ca.uwo.eng.se2205.lab7.graphs.Graph;
import ca.uwo.eng.se2205.lab7.graphs.Vertex;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by PeakeAndSons on 2017-04-09.
 */
public interface Ed<E, V> {

    /**
     * Get the owning {@link Graph} of this {@link Edge}.
     *
     * @return Non-{@code null} graph instance
     */
    G <V, E> graph();

    /**
     * Get the weight
     *
     * @return the weight
     */
    double getWeight();

    /**
     * Set the weight
     *
     * @param weight New weight
     * @throws UnsupportedOperationException if immutable
     */
    void setWeight(@Nullable double weight);

    /**
     * Get {@code u}, the first {@link Vertex}. If the edge is {@link Undirected} the order does
     * not matter.
     *
     * @return First {@code Vertex}
     */
    Ve<V, E> u();

    /**
     * Get {@code v}, the second {@link Vertex}. If the edge is {@link Undirected} the order does
     * not matter.
     *
     * @return Second {@code Vertex}
     */
    Ve<V, E> v();

    /**
     * Get the {@link Vertex} opposite the passed {@link Vertex}.
     *
     * @param vertex Vertex within the edge
     * @return Opposite vertex to the passed parameter
     * @throws IllegalArgumentException if {@code v} is not attached to the {@code Edge}
     */
    Ve<V, E> opposite(Ve<V, E> vertex);

    /**
     * Returns {@code true} if the vertex is in this edge
     *
     * @param vertex The vertex to check against
     * @return
     * @throws NullPointerException if vertex is {@code null}
     */
    default boolean contains(Ve<V, E> vertex) {
        checkNotNull(vertex, "vertex == null");

        return (u().equals(vertex) || v().equals(vertex));
    }


    /**
     * Defines a directed edge
     *
     * @param <V>
     */
    interface Directed<E, V> extends Ed<E, V> {

    }

    /**
     * Defines an undirected edge
     *
     * @param <V>
     */
    interface Undirected<E, V> extends Ed<E, V> {

    }
}

