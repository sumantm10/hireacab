package hirecab;

import java.util.Scanner;

//A Java program for Dijkstra's single source shortest path algorithm.
//The program is for adjacency matrix representation of the graph
public class Dijkstra
{
 // A utility function to find the vertex with minimum distance value,
 // from the set of vertices not yet included in shortest path tree
 static final int V=9;
 int minDistance(int dist[], Boolean sptSet[])
 {
     // Initialize min value
     int min = Integer.MAX_VALUE, min_index=-1;

     for (int v = 0; v < V; v++)
         if (sptSet[v] == false && dist[v] <= min)
         {
             min = dist[v];
             min_index = v;
         }

     return min_index;
 }

 // A utility function to print the constructed distance array
 void printSolution(int dist[], int n)
 {
     System.out.println("Vertex   Distance from Source");
     for (int i = 0; i < V; i++)
         System.out.println(i+" \t\t "+dist[i]);
 }

 // Funtion that implements Dijkstra's single source shortest path
 // algorithm for a graph represented using adjacency matrix
 // representation
 void dijkstra(int graph[][], int src)
 {
     int dist[] = new int[V]; // The output array. dist[i] will hold
                              // the shortest distance from src to i

     // sptSet[i] will true if vertex i is included in shortest
     // path tree or shortest distance from src to i is finalized
     Boolean sptSet[] = new Boolean[V];

     // Initialize all distances as INFINITE and stpSet[] as false
     for (int i = 0; i < V; i++)
     {
         dist[i] = Integer.MAX_VALUE;
         sptSet[i] = false;
     }

     // Distance of source vertex from itself is always 0
     dist[src] = 0;

     // Find shortest path for all vertices
     for (int count = 0; count < V-1; count++)
     {
         // Pick the minimum distance vertex from the set of vertices
         // not yet processed. u is always equal to src in first
         // iteration.
         int u = minDistance(dist, sptSet);

         // Mark the picked vertex as processed
         sptSet[u] = true;

         // Update dist value of the adjacent vertices of the
         // picked vertex.
         for (int v = 0; v < V; v++)

             // Update dist[v] only if is not in sptSet, there is an
             // edge from u to v, and total weight of path from src to
             // v through u is smaller than current value of dist[v]
             if (!sptSet[v] && graph[u][v]!=0 &&
                     dist[u] != Integer.MAX_VALUE &&
                     dist[u]+graph[u][v] < dist[v])
                 dist[v] = dist[u] + graph[u][v];
     }

     // print the constructed distance array
     printSolution(dist, V);
 }

 // Driver method
 public static void main (String[] args)
 {
     /* Let us create the example graph discussed above */
    int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                               {4, 0, 8, 0, 0, 0, 0, 11, 0},
                               {0, 8, 0, 7, 0, 4, 0, 0, 2},
                               {0, 0, 7, 0, 9, 14, 0, 0, 0},
                               {0, 0, 0, 9, 0, 10, 0, 0, 0},
                               {0, 0, 4, 0, 10, 0, 2, 0, 0},
                               {0, 0, 0, 14, 0, 2, 0, 1, 6},
                               {8, 11, 0, 0, 0, 0, 1, 0, 7},
                               {0, 0, 2, 0, 0, 0, 6, 7, 0}
                              };
    System.out.println("Enter source : \n");
    Scanner s = new Scanner(System.in);
    int src = s.nextInt();
     Dijkstra t = new Dijkstra();
     t.dijkstra(graph, src);
 }
}


/*import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
 
public class Dijkstra
{
    private int distances[];
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int number_of_nodes;
    private int adjacencyMatrix[][];
 
    public Dijkstra(int number_of_nodes)
    {
        this.number_of_nodes = number_of_nodes;
        distances = new int[number_of_nodes + 1];
        settled = new HashSet<Integer>();
        unsettled = new HashSet<Integer>();
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
    }
 
    public void dijkstra_algorithm(int adjacency_matrix[][], int source)
    {
        int evaluationNode;
        for (int i = 1; i <= number_of_nodes; i++)
            for (int j = 1; j <= number_of_nodes; j++)
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
 
        for (int i = 1; i <= number_of_nodes; i++)
        {
            distances[i] = Integer.MAX_VALUE;
        }
 
        unsettled.add(source);
        distances[source] = 0;		
        while (!unsettled.isEmpty())
        {
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
            unsettled.remove(evaluationNode);
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
        } 
    }
 
    private int getNodeWithMinimumDistanceFromUnsettled()
    {
        int min ;
        int node = 0;
 
        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[node];
        for (int i = 1; i <= distances.length; i++)
        {
            if (unsettled.contains(i))
            {
                if (distances[i] <= min)
                {
                    min = distances[i];
                    node = i;			
                }
            }
        }
        return node;
    }
 
    private void evaluateNeighbours(int evaluationNode)
    {
        int edgeDistance = -1;
        int newDistance = -1;
 
        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)
        {
            if (!settled.contains(destinationNode))
            {
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
                {
                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode])
                    {
                        distances[destinationNode] = newDistance;
                    }
                    unsettled.add(destinationNode);
                }
            }
        }
    }
 
    public static void main(String... arg)
    {
        int adjacency_matrix[][];
        int number_of_vertices;
        int source = 0;
        Scanner scan = new Scanner(System.in);
        try
        {
            System.out.println("Enter the number of vertices");
            number_of_vertices = scan.nextInt();
            adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];
 
            System.out.println("Enter the Weighted Matrix for the graph");
            for (int i = 1; i <= number_of_vertices; i++)
            {
                for (int j = 1; j <= number_of_vertices; j++)
                {
                    adjacency_matrix[i][j] = scan.nextInt();
                    if (i == j)
                    {
                        adjacency_matrix[i][j] = 0;
                        continue;
                    }
                    if (adjacency_matrix[i][j] == 0)
                    {
                        adjacency_matrix[i][j] =  Integer.MAX_VALUE;
                    }
                } 
            } 
 
            System.out.println("Enter the source ");
            source = scan.nextInt();
 
            Dijkstra dijkstrasAlgorithm = new Dijkstra(number_of_vertices);
            dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);
            System.out.println("The adjacency matrix is : \n");
            for(int i=1;i<=number_of_vertices;i++)
            {
            	 for(int j=1;j<=number_of_vertices;j++)
            	 {
            		 System.out.print(adjacency_matrix[i][j]+" ");
            	 }
        		 System.out.print("\n");
            }
            System.out.println("The Shorted Path to all nodes are ");
            for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++)
            {
                System.out.println(source + " to " + i + " is "+ dijkstrasAlgorithm.distances[i]);
            }
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        scan.close();
    }
}
*/