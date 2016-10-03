package algorithms.geeksforgeeks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathFinder {
	int node;
	static Map<String, List<String>> adjList;
	static Map<String, Boolean> visited;
	static Map<Integer,String> path;
	static List<String> result = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = "/Users/vijayanbalasubramanian/Documents/workspacehk/algorithms/src/algorithms/geeksforgeeks/input_1.txt";
		if (args.length > 0) {
			filename = args[0];
		}

		List<String> answer = parseFile(filename);
		System.out.println(answer);
	}

	static List<String> parseFile(String filename) throws FileNotFoundException, IOException {
		/*
		 * Don't modify this function
		 */
		BufferedReader input = new BufferedReader(new FileReader(filename));
		List<String> allLines = new ArrayList<String>();
		String line;
		while ((line = input.readLine()) != null) {
			allLines.add(line);
		}
		input.close();

		return parseLines(allLines);
	}

	static List<String> parseLines(List<String> lines) {
		String[] nodes = lines.get(0).split(" ");
		String source = nodes[0];
		String destination = nodes[1];
		lines.remove(0);
		adjList = new HashMap();
		for (String line : lines) {
			String[] partition = line.split(":");
			adjList.put(partition[0].trim(), Arrays.asList(partition[1].trim().split(" ")));
		}
		path = new HashMap<>();;
		visited = new HashMap<>();
		for(String key : adjList.keySet()){
			visited.put(key, false);
		}
        printPath(source,destination,0,result);
		return result;
	}

	public static void printPath(String source, String destination, int level,List<String> result) {
		path.put(level, source);
	     visited.put(source, true);
		if (source.equals(destination)) {
			String resultPrint = "";
			for (int i = 0; i <= level; i++) {
				resultPrint += (path.get(i));
			}
			result.add(resultPrint);

		} else {
			for (String s : adjList.get(source)) {
				if(visited.containsKey(s) == false){
					visited.put(s, false);
				}
				if (visited.get(s).equals(false))
					printPath(s, destination, level + 1,result);
			}

		}
		visited.put(source, false);
	}
}