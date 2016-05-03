import java.util.*;

public class Solution {

    /*public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 ) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry: list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }*/

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequents = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (!frequents.containsKey(nums[i])) {
                frequents.put(nums[i], 1);
            } else {
                int cur = frequents.get(nums[i]);
                frequents.put(nums[i], cur+1);
            }
        }
        List<Map.Entry<Integer, Integer>> frequentSorted = new ArrayList<Map.Entry<Integer, Integer>>(frequents.entrySet());
        Collections.sort(frequentSorted, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<Integer> ans = new ArrayList<Integer>(k);
        for (int i=0; i<k; i++) {
            ans.add(frequentSorted.get(i).getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        List<Integer> ans = topKFrequent(nums, 2);
        System.out.println(ans.toString());
    }
}
