import java.util.*;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
class Graph{
    int vertices;
    ArrayList<Edge> allEdges = new ArrayList<>();
    LinkedList<Integer> adjList [];
    int matrix[][];
    public Graph(int vertices){
        this.vertices = vertices;

        matrix = new int[vertices][vertices];
        
        adjList = new LinkedList[vertices];
        for (int i = 0; i <vertices ; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight){
        //forward edge
        adjList[source].addFirst(destination);
        //backward edge in undirected graph
        adjList[destination].addFirst(source);

        //add edge
        matrix[source][destination]=weight;

        //add back edge for undirected graph
        matrix[destination][source] = weight;
        
        Edge edge = new Edge(source, destination, weight);
        allEdges.add(edge); //add to total edges
    }
    public ArrayList<Integer> reachable(int vertex){
        
        boolean [] visited = new boolean[vertices];
        //Do the DFS from the given vertex
        dfs(vertex, visited);

        //count the number of non reached vertices
        int count = 0;
        // int [] reachable;
        ArrayList<Integer> reachable = new ArrayList<>();
        for (int i = 0; i <visited.length ; i++) {
            if(visited[i]==true){
                count++;
                reachable.add(i);
            }
        }
        return reachable;
    }
    public void dfs(int start, boolean [] visited){
        visited[start] = true;
        // System.out.println(start+" dcsdc "+ adjList[start].get(0));
        for (int i = 0; i <adjList[start].size() ; i++) {
            int vertex = adjList[start].get(i);
            if(!visited[vertex])
                dfs(vertex,visited);
        }
    }
    //get the vertex with minimum distance which is not included in SPT
    int getMinimumVertex(boolean [] mst, int [] key){
        int minKey = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i <vertices ; i++) {
            if(mst[i]==false && minKey>key[i]){
                minKey = key[i];
                vertex = i;
            }
        }
        return vertex;
    }
    
    public void dijkstra_GetMinDistances(int sourceVertex){
        boolean[] spt = new boolean[vertices];
        int [] distance = new int[vertices];
        int INFINITY = Integer.MAX_VALUE;

        //Initialize all the distance to infinity
        for (int i = 0; i <vertices ; i++) {
            distance[i] = INFINITY;
        }

        //start from the vertex 0
        distance[sourceVertex] = 0;

        //create SPT
        for (int i = 0; i <vertices ; i++) {

            //get the vertex with the minimum distance
            int vertex_U = getMinimumVertex(spt, distance);

            //include this vertex in SPT
            spt[vertex_U] = true;

            //iterate through all the adjacent vertices of above vertex and update the keys
            for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) {
            //check of the edge between vertex_U and vertex_V
                if(matrix[vertex_U][vertex_V]>0){
                //check if this vertex 'vertex_V' already in spt and
                // if distance[vertex_V]!=Infinity

                    if(spt[vertex_V]==false && matrix[vertex_U][vertex_V]!=INFINITY){
                        //check if distance needs an update or not
                        //means check total weight from source to vertex_V is less than
                        //the current distance value, if yes then update the distance

                        int newKey = matrix[vertex_U][vertex_V] + distance[vertex_U];
                        if(newKey<distance[vertex_V])
                            distance[vertex_V] = newKey;
                    }
                }
            }
        }
        //print shortest path tree
        printDijkstra(sourceVertex, distance);
    }

    public void printDijkstra(int sourceVertex, int [] key){
        System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
        for (int i = 0; i <vertices ; i++) {
            System.out.println("Source Vertex: " + sourceVertex + " to vertex " + + i +
        " distance: " + key[i]);
        }
    }


    public void kruskalMST(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));

        //add all the edges to priority queue, //sort the edges on weights
        for (int i = 0; i <allEdges.size() ; i++) {
            pq.add(allEdges.get(i));
        }

        //create a parent []
        int [] parent = new int[vertices];

        //makeset
        makeSet(parent);

        ArrayList<Edge> mst = new ArrayList<>();

        //process vertices – 1 edges
        int index = 0;
        while(index<vertices-1){
            Edge edge = pq.remove();
            //check if adding this edge creates a cycle
            int x_set = find(parent, edge.source);
            int y_set = find(parent, edge.destination);

            if(x_set==y_set){
                //ignore, will create cycle
            }else {
                //add it to our final result
                mst.add(edge);
                index++;
                union(parent,x_set,y_set);
            }
        }
        //print MST
        System.out.println("Minimum Spanning Tree: ");
        printGraph(mst);
    }

    public void makeSet(int [] parent){
        //Make set- creating a new element with a parent pointer to itself.
        for (int i = 0; i <vertices ; i++) {
            parent[i] = i;
        }
    }

    public int find(int [] parent, int vertex){
        //chain of parent pointers from x upwards through the tree
        // until an element is reached whose parent is itself
        if(parent[vertex]!=vertex)
            return find(parent, parent[vertex]);;
        return vertex;
    }

    public void union(int [] parent, int x, int y){
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    }
    public void printGraph(ArrayList<Edge> edgeList){
        for (int i = 0; i <edgeList.size() ; i++) {
            Edge edge = edgeList.get(i);
            System.out.println("Edge-" + i + " source: " + edge.source +
            " destination: " + edge.destination +
            " weight: " + edge.weight);
        }
    }

}

public class UndirectedDisconnectedGraph implements UndirectedDisconnectedGraphInterface {

    public void isConnected(Graph graph){

        int vertices = graph.vertices;
        LinkedList<Integer> adjList [] = graph.adjList;

        //created visited array
        boolean[] visited = new boolean[vertices];

        //start the DFS from vertex 0
        DFS(0, adjList, visited);

        //check if all the vertices are visited, if yes then graph is connected
        int count = 0;
        for (int i = 0; i <visited.length ; i++) {
            if(visited[i])
                count++;
        }
        if(vertices==count){
            System.out.println("Given graph is connected");
        }else{
            System.out.println("Given graph is not connected");
        }
    }

    public void DFS(int source, LinkedList<Integer> adjList [], boolean[] visited){

        //mark the vertex visited
        visited[source] = true;

        //travel the neighbors
        for (int i = 0; i <adjList[source].size() ; i++) {
            int neighbor = adjList[source].get(i);
            if(visited[neighbor]==false){
                //make recursive call from neighbor
                DFS(neighbor, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1,3);
        graph.addEdge(1,3,7);
        // graph.addEdge(0, 1);
        // graph.addEdge(1, 2);
        // graph.addEdge(2, 3);
        graph.addEdge(4, 5,9);
        graph.addEdge(5, 6,10);
        // graph.addEdge(0, 6);

        UndirectedDisconnectedGraph c = new UndirectedDisconnectedGraph();
        c.isConnected(graph);

        ArrayList<Integer> reachableVertices = graph.reachable(0);
        System.out.println("Reachable vertices from the vertex 0 are: " );
        //   for (int element: reachableVertices) {
            System.out.println(reachableVertices);
        // }
        graph.addEdge(6, 7, 8);
        graph.addEdge(3,2, 7);
        graph.addEdge(3, 4, 14);
        c.isConnected(graph);
        // System.out.println("Number of reachable vertices from the vertex 1 are: " + reachableVertices);

        int sourceVertex = 0;
        graph.dijkstra_GetMinDistances(sourceVertex);
        graph.kruskalMST();
    }
}