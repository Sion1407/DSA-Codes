package Exercises.graphs;

public class Main {
    public static void main(String[] args) {
        Graphs graphs = new Graphs();
        graphs.addVertex("10");
        graphs.addVertex("11");
        graphs.addVertex("12");
        graphs.printGraph();

        System.out.println("adding an edge from 10 to 11");
        graphs.addEdge("10","11");
        graphs.addEdge("10","12");
        graphs.addEdge("11","12");
        graphs.printGraph();

        System.out.println("removing an edge");
        graphs.removeEdge("10","11");
        graphs.printGraph();

        System.out.println("removing vertex 11");
        graphs.removeVertex("11");
        graphs.printGraph();
    }
}
