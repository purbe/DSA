package recursion;
import java.util.ArrayList;


public class FindSubsetsThatSumToK {
    public static void generate (ArrayList<Integer> arr,int index,ArrayList<Integer> current,ArrayList<ArrayList<Integer>> result, int target) {


        if(index==arr.size()){
            if(target == 0)
            {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        current.add(arr.get(index));
        generate(arr,index+1,current,result,target-arr.get(index));

        current.remove(current.size()-1);
        generate(arr,index+1,current,result,target);


    }

    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k)
    {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        generate(arr,0,new ArrayList<>(),result,k);

        return result;

    }

    public static void main (String arg[]){
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(4);
        arr1.add(6);
        System.out.println(findSubsetsThatSumToK(arr1,3,6)+"");
        //System.out.println(findSubsetsThatSumToK(new ArrayList<>({-2 ,-7, 3, 1, 2, 4, 9}),7,2)+""); illegal


    }

}
