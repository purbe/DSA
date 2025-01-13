package recursion;
import java.util.ArrayList;
import java.util.List;
public class Paths_in_aMaze {

    public static void findPath(ArrayList<ArrayList<Integer>> arr, int x, int y, int n, String path, ArrayList<String> result, boolean[][] visited) {
        // Base case: If we reach the bottom-right corner
        if (x == n - 1 && y == n - 1) {
            result.add(path); // Add the current path to the result
            return;
        }

        // Directions: Down, Left, Right, Up
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] moves = {'D', 'L', 'R', 'U'};

        // Mark the current cell as visited
        visited[x][y] = true;

        // Explore all four directions
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // Check if the move is valid
            if (isValid(arr, newX, newY, n, visited)) {
                findPath(arr, newX, newY, n, path + moves[i], result, visited);
            }
        }

        // Backtrack: Unmark the current cell
        visited[x][y] = false;
    }

    public static boolean isValid(ArrayList<ArrayList<Integer>> maze, int x, int y, int n, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < n && y < n && maze.get(x).get(y) == 1 && !visited[x][y];
    }

    public static ArrayList<String> findAllPaths(ArrayList<ArrayList<Integer>> arr) {
        int n = arr.size();
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        // Start only if the starting and ending cells are open
        if (arr.get(0).get(0) == 1 && arr.get(n - 1).get(n - 1) == 1) {
            findPath(arr, 0, 0, n, "", result, visited);
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        maze.add(new ArrayList<>(List.of(1, 0, 0, 0)));
        maze.add(new ArrayList<>(List.of(1, 1, 1, 0)));
        maze.add(new ArrayList<>(List.of(0, 0, 1, 1)));
        maze.add(new ArrayList<>(List.of(1, 1, 1, 1)));

        ArrayList<String> paths = findAllPaths(maze);

        System.out.println("All Paths:");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
