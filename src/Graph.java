
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Masroor
 */

public class Graph {
    ArrayList<Vertex> vertices;
    int totalVertices;
    int totalEdges;
    
    public Graph(){
    }
    //parameterized constructor
    public Graph(int totalVertices,int totalEdges){
        this.totalVertices=totalVertices;
        this.totalEdges=totalEdges;
        vertices=new ArrayList<Vertex>();
        for (int i = 0; i < totalVertices; i++) {
            vertices.add(new Vertex(i));
        }
    }
    
    public int getTotalVertices(){
        return this.totalVertices;
    }
    
    public int getTotalEdges(){
        return this.totalEdges;
    }
    
    public void initializeGraph(){
        try{
            Scanner scan=new Scanner(new File("digraph.txt"));
            totalVertices=scan.nextInt();   //first element in the file is # of vertices 
            totalEdges=scan.nextInt();      //second element in the file is # of edges
            //create vertices
            vertices=new ArrayList<Vertex>();
            for (int i = 0; i < totalVertices; i++) {
                vertices.add(new Vertex(i));
            }
            int src,dest;
            for (int i = 0; i < totalEdges; i++) {
                src=scan.nextInt();
                dest=scan.nextInt();
                vertices.get(src).addOutEdge(dest);
            }
        }catch(FileNotFoundException ex){
            
        }
    }
    
    public void printAdjacencyList(){
        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).printVertex();
        }
        System.out.println("\n");
    }
    
    public Graph reverseTheGraph(){
        int dest = 0,src;
        Graph reversedGraph=new Graph(totalVertices,totalEdges);
        
        for(int i=0; i<totalVertices;i++){
            for(Iterator outEdgeIterator=vertices.get(i).outEdges.iterator();outEdgeIterator.hasNext();){
                dest=(int)outEdgeIterator.next();
                src=i;
                reversedGraph.vertices.get(dest).addOutEdge(src);
            }
        }
        return reversedGraph;
    }
}
