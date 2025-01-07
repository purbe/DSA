package recursion;

public class NthTermOfGP {
    public static int nthTermOfGP(int N, int A, int R) {
        // Write you code here

        if(N==1){
            return A;
        }

        return (R*nthTermOfGP(N-1, A, R)) % (1000000007);

    }

    public static void main (String arg[]){
        System.out.printf(nthTermOfGP(5,3,2)+"");

    }

}
