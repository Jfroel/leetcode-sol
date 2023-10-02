class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    // Step 1: tally up the occurrences using a map 
    HashMap<Integer, Integer> occursMap = new HashMap<>(); // num -> occurs
    for (int num : nums) {
      Integer occurs = occursMap.putIfAbsent(num, 1);
      if (occurs != null) occursMap.put(num, occurs+1);
    }

    // Step 2: Use a min heap to sort the map entries by their occurs.
    // Using a minHeap so the heap never gets bigger than k.  
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap 
      = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
    for (Map.Entry<Integer, Integer> entry : occursMap.entrySet()) {
      minHeap.add(entry);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    // Step 3: 
    int[] res = new int[k];
    for (int i = k-1; i >= 0; i--) {
      res[i] = minHeap.poll().getKey();
    }
    return res;
  }
}
