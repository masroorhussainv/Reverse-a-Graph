
/**
 *
 * @author Masroor
 */
public class ReverseAGraph {

    public static void main(String[] args) {
        GraphGenerator graphGenerator=new GraphGenerator(10, 15);   //takaes (vertices,edges) and generates graph in a file
        Graph graph=new Graph();            //graph that will be initialzed from the file
        graph.initializeGraph();            //initialzes from the file "digraph.txt"
        graph.printAdjacencyList();         //prints the graph in adjaceny list format
        
        Graph reversedGraph=graph.reverseTheGraph();    //returns a new graph which is reversed
        System.out.println("Reversed Graph:");
        reversedGraph.printAdjacencyList();             //prints the reversed graph
    }
    
}
