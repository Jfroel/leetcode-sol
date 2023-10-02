class MedianFinder {
  private PriorityQueue<Integer> large; // minHeap
  private PriorityQueue<Integer> small; // maxHeap
  public MedianFinder() {
      large = new PriorityQueue<>();
      small = new PriorityQueue<>(Collections.reverseOrder());
  }
  
  public void addNum(int num) {
      // add the num to the small nums, pull the top of the heap and add it to the 
      // larger nums. After this, the nums are all sorted but the heaps are not balanced.
      // The larger nums heap might have more elements
      small.add(num);
      large.add(small.poll());
      // balance the heaps
      if (large.size() > small.size()) { 
        small.add(large.poll());
      }
  }
  
  public double findMedian() {
    // the median is either the top of the smallerNums or is the 
    // the average of the two top elements
    if (large.size() < small.size()) {
      return small.peek();
    } else {
      return (double)(small.peek() + large.peek()) / 2.0;
    }
  }
}

/**
* Your MedianFinder object will be instantiated and called as such:
* MedianFinder obj = new MedianFinder();
* obj.addNum(num);
* double param_2 = obj.findMedian();
*/
