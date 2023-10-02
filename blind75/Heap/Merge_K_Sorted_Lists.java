/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */ 

// Heap solution
// n = number of nodes in list,
// k = number of lists,
// Time: O(n log k)
// Space: O(k)
class nodeComparator implements Comparator<Pair<Integer, Integer>> {
  public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
      return a.getKey() - b.getKey();
  }
}
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      int n = lists.length;
      PriorityQueue<Pair<Integer, Integer>> minHeap = 
        new PriorityQueue<>(new nodeComparator());
      for (int i = 0; i < n; i++) {
        if (lists[i] != null) {
            minHeap.add(new Pair(lists[i].val, i));
        }
      }
      if (minHeap.isEmpty()) return null;

      ListNode dummyHead = new ListNode(0);
      ListNode tail = dummyHead;
      while (!minHeap.isEmpty()) {
        int index = minHeap.poll().getValue();

        tail.next = lists[index];
        tail = tail.next;

        lists[index] = lists[index].next;
        if (lists[index] != null) {
          minHeap.add(new Pair(lists[index].val, index));
        }
      }
      tail.next = null;
      return dummyHead.next;
  }
}

// divide and conquer, 
// n = number of nodes in list,
// k = number of lists,
// Time: O(n log k)
// Space: O(log k)
class Solution2 {
  public ListNode mergeKLists(ListNode[] lists) {
      if (lists.length == 0) return null; 
      return divideByPairs(lists, 0, lists.length-1);
  }
  private ListNode divideByPairs(ListNode[] lists, int left, int right) {
      if (left == right) {
          return lists[left];
      } else if (left + 1 == right) {
          return mergeTwoList(lists[left], lists[right]);
      } else {
          return mergeTwoList(divideByPairs(lists, left, left + (right-left)/2), divideByPairs(lists, left + (right-left)/2 +1, right));
      }
  }
  private ListNode mergeTwoList(ListNode l1, ListNode l2) {
      ListNode dummyHead = new ListNode(0);
      ListNode curr = dummyHead;
      while (l1 != null && l2 != null) {
          if (l1.val <= l2.val) {
              curr.next = l1;
              l1 = l1.next;
          } else {
              curr.next = l2;
              l2 = l2.next;
          }
          curr = curr.next;
      }
      
      if (l1 != null) curr.next = l1;
      else if (l2 != null) curr.next = l2;
      
      return dummyHead.next;
  } 
}