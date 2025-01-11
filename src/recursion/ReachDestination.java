package recursion;

public class ReachDestination {
    public static boolean reachDestination(int sx, int sy, int dx, int dy) {
        // Write your code here
        if(sx==dx && sy==dy)
            return true;

        // if(sx>dx || sy>dy)
        // 	return false;

        if(dx<sx || dy<sy)
            return false;


        // return reachDestination(sx+sy, sy, dx, dy) || reachDestination(sx, sx+sy, dx, dy); //time limit out error


        return reachDestination(sx, sy, dx-dy, dy)|| reachDestination(sx, sy, dx, dy-dx); //optimized approach

    }

    public static void main (String arg[]){
        System.out.println(reachDestination(18, 989, 2104, 1043)+ "");
        System.out.println(reachDestination(8, 76, 2037, 1417)+"");
    }
}
