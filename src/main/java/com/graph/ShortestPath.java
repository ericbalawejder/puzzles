package com.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Write a function, shortestPath, that takes in an array of edges for an undirected graph and
 * two nodes (nodeA, nodeB). The function should return the length of the shortest path between A and B.
 * Consider the length as the number of edges in the path, not the number of nodes. If there is no path
 * between A and B, then return -1.
 * Answer = 2
 *
 * const shortestPath=(edges, src, dst) => {
 * const graph = createAdjacencyList(edges)
 * 1. create a queue, create set of visitedNodes(),
 * create distance count = 0
 * 2. put first edge into queue
 * 3. while queue is not empty
 * 4. shift element from queue
 * 5. check if element equal to dst
 * 6. for every neighbor in element -
 * 7. check if it wasn't visited add to visited
 * 8. add neighbor to queue
 * 9. return count or -1
 * }
 */
public class ShortestPath {

    private static final List<List<Character>> EDGES = List.of(
            List.of('w', 'x'),
            List.of('x', 'y'),
            List.of('z', 'y'),
            List.of('z', 'v'),
            List.of('w', 'v')
    );

    public static void main(String[] args) {
        System.out.println(EDGES);
        System.out.println(createAdjacencyList(EDGES));
        System.out.println(shortestPath(EDGES, 'w', 'z'));
    }

    static int shortestPath(List<List<Character>> edges, char source, char destination) {
        final Map<Character, Set<Character>> graph = createAdjacencyList(edges);
        final Queue<Pair<Character, Integer>> queue = new ArrayDeque<>();
        final Set<Character> visitedNodes = new HashSet<>();
        queue.add(new Pair<>(source, 0));
        visitedNodes.add(source);

        while (queue.size() > 0) {
            final Pair<Character, Integer> currentNode = queue.poll();
            if (currentNode.first() == destination) {
                return currentNode.second();
            }
            for (Character node : graph.get(currentNode.first())) {
                if (!visitedNodes.contains(node)) {
                    visitedNodes.add(node);
                    queue.add(new Pair<>(node, currentNode.second() + 1));
                }
            }
        }
        return -1;
    }

    private static Map<Character, Set<Character>> createAdjacencyList(List<List<Character>> edges) {
        final Map<Character, Set<Character>> adjacencyList = new HashMap<>();
        for (List<Character> edge : edges) {
            final Set<Character> v1 = adjacencyList.getOrDefault(edge.get(0), new HashSet<>());
            v1.add(edge.get(1));
            adjacencyList.put(edge.get(0), v1);
            final Set<Character> v2 = adjacencyList.getOrDefault(edge.get(1), new HashSet<>());
            v2.add(edge.get(0));
            adjacencyList.put(edge.get(1), v2);
        }
        return Map.copyOf(adjacencyList);
    }

}

/*

        const shortestPath=(edges,src,dst)=>{
        const graph=createAdjacencyList(edges)
        const queue=[[src,0]];
        const visitedNodes=new Set([src]);
        let min_distance=0;

        while(queue.length>0){
        const[currentNode,distance]=queue.shift();
        if(currentNode===dst){
        return distance
        // min_distance=Math.min(min_distance, distance)
        }
        for(let node of graph[currentNode]){
        if(!visitedNodes.has(node)){
        visitedNodes.add(node);
        queue.push([node,distance+1]);
        }
        }
        }
        return-1
        // return min_distance === 0 ? -1 : min_distance;

        }

        function createAdjacencyList(edges){
        const hash={}
        for(const edge of edges){
        const[nodeA,nodeB]=edge

        if(!hash[nodeA])hash[nodeA]=[]
        if(!hash[nodeB])hash[nodeB]=[]

        hash[nodeA].push(nodeB)
        hash[nodeB].push(nodeA)
        }
        return hash;
        }

        console.log(shortestPath(edges,'w','z'))
*/

