package Heap;
import java.util.*;

public class ConnectRopesToMinimiseCost {

    public static int minCostToConnectRopes(int[] arr){
                PriorityQueue<Integer> minH = new PriorityQueue<>();
                for(int i:arr){
                    minH.add(i);
                }
                int Tcost = 0;
                while(minH.size()>1){
                    int first = minH.poll();
                    int second = minH.poll();

                    int cost = first + second;

                    Tcost+=cost;

                    minH.add(cost);
                }
                return Tcost;
    }

    public static void main(String[] args){
        int[] ropes = {1, 2, 3, 4, 5};
        int result = minCostToConnectRopes(ropes);
        System.out.println("Minimum total cost to connect ropes: " + result);
    }
}
