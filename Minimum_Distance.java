package ub.cse.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	  private int startNode;
	  private HashMap<Integer, ArrayList<Integer>> graph;
	  public Solution(int node, HashMap<Integer, ArrayList<Integer>> g){
	    startNode = node;
	    graph = g;
	  }

	  public int[] outputDistances(){
		Queue<Integer> q = new LinkedList<Integer>();
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		HashMap<Integer, Integer> prev = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> distance = new HashMap<Integer, Integer>();
		int[] answer = new int[graph.size()];
		for(int x = 0; x < answer.length; x++){
			answer[x] = -1;
		}
		visited.put(startNode, true);
		prev.put(startNode, startNode);
		distance.put(startNode, 0);
		answer[startNode] = 0;
		q.add(startNode);
		while(q.size() != 0){
			int z = q.poll();
			for(int x = 0; x < graph.get(z).size(); x++){
				if(!visited.containsKey(graph.get(z).get(x))){
					visited.put(graph.get(z).get(x), true);
					prev.put(graph.get(z).get(x), z);
					distance.put(graph.get(z).get(x), (distance.get(prev.get(graph.get(z).get(x)))+ 1));
					answer[graph.get(z).get(x)] = distance.get(graph.get(z).get(x));
					System.out.println("x");
					q.add(graph.get(z).get(x));
				}
			}
		}
	    return answer;
	  }
}
