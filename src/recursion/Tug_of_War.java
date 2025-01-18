package recursion;
import java.util.ArrayList;
public class Tug_of_War {
    public static void findMinimumDifference(ArrayList<Integer> arr, int n, int index,
                                             ArrayList<Integer> team1, ArrayList<Integer> team2,
                                             int sum1, int sum2, int[] minDifference) {
        // Base case: If we have distributed all students
        if (index == n) {
            if (Math.abs(team1.size() - team2.size()) <= 1) {
                int diff = Math.abs(sum1 - sum2);
                minDifference[0] = Math.min(minDifference[0], diff);
            }
            return;
        }

        // Add the current student to team1
        if (team1.size() < (n + 1) / 2) {
            team1.add(arr.get(index));
            findMinimumDifference(arr, n, index + 1, team1, team2, sum1 + arr.get(index), sum2, minDifference);
            team1.remove(team1.size() - 1); // Backtrack
        }

        // Add the current student to team2
        if (team2.size() < (n + 1) / 2) {
            team2.add(arr.get(index));
            findMinimumDifference(arr, n, index + 1, team1, team2, sum1, sum2 + arr.get(index), minDifference);
            team2.remove(team2.size() - 1); // Backtrack
        }
    }
    public static int tugOfWar(ArrayList<Integer> arr, int n) {
        // Write your code here.
        ArrayList<Integer> team1 = new ArrayList<>();
        ArrayList<Integer> team2 = new ArrayList<>();
        int[] minDifference = {Integer.MAX_VALUE};

        findMinimumDifference(arr, n, 0, team1, team2, 0, 0, minDifference);

        return minDifference[0];

    }
    public static void main (String arg[]) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(4);
        arr1.add(6);

        System.out.println(tugOfWar(arr1, 3) + "");
    }

}
