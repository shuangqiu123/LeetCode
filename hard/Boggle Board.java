import java.util.*;

class Program {
  public static List<String> boggleBoard(char[][] board, String[] words) {
		TrieNode root = buildTrie(words);
		Set<String> result = new HashSet<>();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (root.children.containsKey(board[i][j])) {
					dfsFindWords(i, j, board, root.children.get(board[i][j]), result, new HashSet<>());
				}
			}
		}
		
    return new ArrayList<String>(result);
  }
	
	public static void dfsFindWords(int row, int col, char[][] board, TrieNode currentNode, Set<String> result, HashSet<String> visited) {
		if (visited.contains(row + "," + col)) {
			return;
		}
		if (currentNode.isAWord) {
			result.add(currentNode.current);
		}
		
		int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
		Map<Character, TrieNode> children = currentNode.children;
		visited.add(row + "," + col);
		
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextCol = col + direction[1];
			if (nextRow < 0 || nextCol < 0 || nextRow >= board.length || nextCol >= board[0].length) {
				continue;
			}
			char nextChar = board[nextRow][nextCol];

			if (children.containsKey(nextChar)) {
				dfsFindWords(nextRow, nextCol, board, children.get(nextChar), result, visited);
			}
		}
		visited.remove(row + "," + col);
	}
	
	
	private static TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		root.current = "";
		
		for (String word : words) {
			TrieNode currentNode = root;
			for (char c : word.toCharArray()) {
				
				if (!currentNode.children.containsKey(c)) {
					currentNode.children.put(c, new TrieNode());
					currentNode.children.get(c).current = currentNode.current + c;
				}
				currentNode = currentNode.children.get(c);
			}
			currentNode.isAWord = true;
		}
		return root;
	}
}

class TrieNode {
	Map<Character, TrieNode> children;
	boolean isAWord;
	String current;
	
	TrieNode() {
		children = new HashMap<>();
	}
}