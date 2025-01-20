package recursion;
import java.util.Arrays;

public class Closest_Distance_Pair {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int closestPair(Point[] points) {
        // Sort points by x-coordinates
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1.x, p2.x));

        // Recursive function to find the closest distance
        return closestUtil(points, 0, points.length - 1);
    }

    private static int closestUtil(Point[] points, int left, int right) {
        // If there are 2 or 3 points, solve directly
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }

        // Find the midpoint
        int mid = left + (right - left) / 2;
        Point midPoint = points[mid];

        // Recursively find the smallest distance in the left and right halves
        int leftMin = closestUtil(points, left, mid);
        int rightMin = closestUtil(points, mid + 1, right);

        // Find the smaller of the two distances
        int minDist = Math.min(leftMin, rightMin);

        // Check the strip around the midpoint
        return Math.min(minDist, stripClosest(points, left, right, midPoint, minDist));
    }

    private static int stripClosest(Point[] points, int left, int right, Point midPoint, int minDist) {
        // Create a strip array to store points close to the midpoint
        Point[] strip = new Point[right - left + 1];
        int stripSize = 0;

        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midPoint.x) < minDist) {
                strip[stripSize++] = points[i];
            }
        }

        // Sort the strip by y-coordinates
        Arrays.sort(strip, 0, stripSize, (p1, p2) -> Integer.compare(p1.y, p2.y));

        // Compare each point in the strip with the next few points
        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (strip[j].y - strip[i].y) < minDist; j++) {
                minDist = Math.min(minDist, distance(strip[i], strip[j]));
            }
        }

        return minDist;
    }

    private static int bruteForce(Point[] points, int left, int right) {
        int minDist = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                minDist = Math.min(minDist, distance(points[i], points[j]));
            }
        }
        return minDist;
    }

    private static int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(1, 3),
                new Point(4, 4),
                new Point(5, 1),
                new Point(7, 2),
                new Point(9, 6)
        };

        int minDistance = closestPair(points);
        System.out.println("The minimum distance is: " + minDistance);
    }
}
