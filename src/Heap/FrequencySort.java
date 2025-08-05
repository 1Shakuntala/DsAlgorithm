package Heap;
import java.util.*;
public class FrequencySort {
    public static List<Integer> sortFrequency(int[] arr){
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num:arr) {
//            if (freq.containsKey(num)) {
//                freq.put(num, freq.get(num) + 1);
//            } else {
//                freq.put(num, 1);
//            }

            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
            PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                    new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

            maxHeap.addAll(freq.entrySet());

            List<Integer> result = new ArrayList<>();
            while (!maxHeap.isEmpty()) {
                Map.Entry<Integer, Integer> entry = maxHeap.poll();
                int freq1 = entry.getValue();
                int num1 = entry.getKey();
                for (int i = 0; i < freq1; i++) {
                    result.add(num1);
                }
            }

            return result;
    }
    public static void main(String[] args){
        int[] arr = {4, 4, 1, 2, 2, 2, 3};
        List<Integer> sorted = sortFrequency(arr);
        System.out.print(sorted);
    }
}
