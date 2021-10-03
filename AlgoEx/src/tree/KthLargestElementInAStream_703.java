package tree;

import java.util.PriorityQueue;

public class KthLargestElementInAStream_703 {

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private int k;

    public KthLargestElementInAStream_703(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
            } else {
                if (nums[i] > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else {
            if (val > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        }
        return priorityQueue.peek();
    }
}
