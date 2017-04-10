# Lab 7 - Graphs

##Q1./Q2. Implementing a Directed Graph and Implementing an Undirected Graph
####What type of structure you've chosen 
A main graph class with 2 nested inner classes for the edges and vertices

####The accompanying auxillary data structures you're using.
The main class uses:
Used MyArrayList implementation from Lab 01, to override the add method to throw the correct error, after I added a boolean

The inner Edge uses:2 vertex's and the weight.

The inner Vertex uses:2 hashmaps, 2 arraylists and the element.

##Q3. Pricing Flights
####Graph type used 
DirectGraph
####Algorithm decisions
Floyd Warshall, BFS, Djikstras
##Q4. Landing a Rover on Mars

####Graph type used (even if you chose to not use the Graph<> structures from Q1 and Q2)
The graphHelper class, using an underlying Hashmap

####Algorithm choices
BFS would be the best algorithm to use!
