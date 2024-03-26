package Exercises.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Graphs {
    private HashMap<String, ArrayList<String>> adjacencyList = new HashMap<>();

    public boolean addVertex(String vertex){
        if (adjacencyList.get(vertex)==null){
            adjacencyList.put(vertex,new ArrayList<>());
            return true;
        }
        return false;
    }

    public void printGraph(){
        System.out.println(adjacencyList);
    }

    public boolean addEdge(String ver1, String ver2){
        if (adjacencyList.get(ver1)!=null && adjacencyList.get(ver2)!=null){
            adjacencyList.get(ver1).add(ver2);
            adjacencyList.get(ver2).add(ver1);
            return true;
        }
        return false;
    }
    public boolean removeEdge(String ver1, String ver2){
        if (adjacencyList.get(ver1)!=null && adjacencyList.get(ver2)!=null){
            adjacencyList.get(ver1).remove(ver2);
            adjacencyList.get(ver2).remove(ver1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex){
        if (adjacencyList.get(vertex)==null) return false;
        for (String otherVertex: adjacencyList.get(vertex)){
            adjacencyList.get(otherVertex).remove(vertex);
        }
        adjacencyList.remove(vertex);
        return true;
    }
}
