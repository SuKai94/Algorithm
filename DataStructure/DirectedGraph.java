/**
 * 有向图的拓扑排序
 * 不能处理环
 */
class  Vertex {
    public char label;
    
    public Vertex(char lab) {
        label= lab;
    }
}
public class DirectedGraph {
    private final int MAX_VERTS = 20;
    private Vertex    vertexList[];
    private int       adjMat[][];
    private int       nVerts;
    private char sortedArray[];
    
    public DirectedGraph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        sortedArray = new char[MAX_VERTS];
    }
    
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }
    
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }
    
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
    
    /*
     * 拓扑排序
     */
    public void topo() {
        int orig_nVerts = nVerts;
        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }
        System.out.print("Topologically sorted order: ");
        for (int j = 0; j < orig_nVerts; j++) {
            System.out.print(sortedArray[j]);
        }
        System.out.println("");
    }
    
    /*
     * 找出没有后继的节点
     */
    public int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge) {
                return row;
            }
        }
        return -1;
    }
    
    public void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) {
            for (int j = delVert; j < nVerts - 1; j++) {
                vertexList[j] = vertexList[j + 1];
            }
            for (int row = delVert; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }
            for (int col = delVert; col < nVerts - 1; col++) {
                moveRowLeft(col, nVerts);
            }
        }
        nVerts--;
    }
    
    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }
    
    private void moveRowLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }
    
    public static void main(String[] args) {
        DirectedGraph theGraph = new DirectedGraph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
        theGraph.addVertex('G');
        theGraph.addVertex('H');
        theGraph.addEdge(0, 3);
        theGraph.addEdge(0, 4);
        theGraph.addEdge(1, 4);
        theGraph.addEdge(2, 5);
        theGraph.addEdge(3, 6);
        theGraph.addEdge(4, 6);
        theGraph.addEdge(5, 7);
        theGraph.addEdge(6, 7);
        
        theGraph.topo();
    }
} 
