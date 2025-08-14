package Recursion;

public class KthSymbolGrammer {
    public static int KthGrammer(int n, int k){
        if(n==1 && k==1){
            return 0;
        }
        int mid = (int)Math.pow(2, n-1)/2;
        if(k<=mid) return KthGrammer(n-1, k);
        else return 1-KthGrammer(n-1, k-mid);
    }
    public static void main(String[] args) {
        int n=4, k = 5;
        System.out.println(KthGrammer(n, k));
    }
}
