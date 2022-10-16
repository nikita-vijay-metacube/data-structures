import java.util.*;

interface UndirectedDisconnectedGraphInterface {

    public void isConnected(Graph graph);

    public void DFS(int source, LinkedList<Integer> adjList [], boolean[] visited);

}