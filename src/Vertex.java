
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Masroor
 */

public class Vertex {
    int vertexNum;
    ArrayList<Integer> outEdges;
    public Vertex(int vertexNum){
        this.vertexNum=vertexNum;
        outEdges=new ArrayList();
    }
    public void addOutEdge(int v){
        outEdges.add(v);
        Collections.sort(outEdges); //to maintain ascending visiting order in neighbors
    }
    public boolean isOutEdge(int v){    //tells if it contains the vertex v as an outedge
        return (outEdges.contains(v));
    }
    public void removeOutEdge(int v){
       if(outEdges.indexOf(v)!=-1)
       {
           outEdges.remove(outEdges.indexOf(v));
       }
    }
    public void printVertex(){
        System.out.print("Vertex: "+vertexNum+"\t");
        System.out.print("Outedges: ");
        for (int i = 0; i < outEdges.size(); ) {
            System.out.print(outEdges.get(i));
            i++;
            if(i<outEdges.size()){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}