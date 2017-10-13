
import com.sun.org.apache.bcel.internal.generic.DLOAD;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author masroor
 */
public class GraphGenerator {
    int totalVertices;
    int totalEdges;

    class Edge{
        int source;
        int dest;
        public Edge(int s,int d){
            source=s;
            dest=d;
        }
    }
    
    class EdgeList{
        ArrayList<Edge> edgeList=new ArrayList<Edge>();
        
        public boolean hasEdge(Edge e){
            for (int i = 0; i < edgeList.size(); i++) {
                if(edgeList.get(i).source==e.source && edgeList.get(i).dest==e.dest)
                    return true;
            }
            return false;
        }
        
        public void add(Edge e){
            edgeList.add(e);
        }
    }
    public int generateRandomNumber(int min,int max){
        Random rand=new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    
    public GraphGenerator(int totalVertices,int totalEdges) {
    
        try {
            File file = new File("digraph.txt");
            if (!file.exists())
            {
                file.createNewFile();
            }
        //           System.out.println("File found.");
            FileWriter writer = new FileWriter(file);
            //write number of vertices
            writer.append(totalVertices+"\n");
            //write number of edges
            writer.append(totalEdges+"\n");
            EdgeList edgeList=new EdgeList();   //list to avoid duplicate edges
            for (int i = 0; i < totalEdges; i++) {
                int source=generateRandomNumber(0, totalVertices-1);
                int dest=generateRandomNumber(0, totalVertices-1);
                Edge edge=new Edge(source, dest);
                while(edgeList.hasEdge(edge)){
                    dest=generateRandomNumber(0, totalVertices-1);
                    edge=new Edge(source,dest);
                }
                edgeList.add(edge);
                writer.append(source+" "+dest+"\n");
            }
            System.out.println("Graph Generated!");
            writer.flush();
            writer.close();
        } catch (Exception e) {
        
        }       
    }
}