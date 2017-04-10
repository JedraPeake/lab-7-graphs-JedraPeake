package ca.uwo.eng.se2205.lab7.travel;

import ca.uwo.eng.se2205.lab7.graphs.Edge;

import java.util.Collection;

/**
 * Created by PeakeAndSons on 2017-04-09.
 */
public interface Ve<V, E> {

    G<V,E> graph();

    /**
     * Returns the stored element
     * @return Non-{@code null} element stored
     */
    V getElement();

    /**
     * Set the element in the Vertex
     * @param element Non-{@code null} element
     * @return The previous element
     */
    V setElement(V element);

    /**
     * Gets the edges entering {@code this}
     * @return Non-{@code null} collection of {@link Edge}s, but possibly empty
     *
     */
    default Collection<? extends Ed<E, V>> incomingEdges() {
        return graph().incomingEdges(this);
    }

    default Collection<? extends Ed<E, V>> outgoingEdges() {
        return graph().outgoingEdges(this);
    }

    default Collection<? extends Ed<E, V>> incidentEdges() {
        return graph().incidentEdges(this);
    }

    int hashCode();

    /**
     * The {@code #equals(Object)} and {@link #hashCode()} methods of a {@code Vertex} must be based off of identity of
     * the {@code Vertex}, not state.
     * @param o Object used for comparison if equal
     * @return {@code true} if {@code this == o}
     *
     * @see #hashCode()
     */
    boolean equals(Object o);
}

