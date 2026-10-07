import java.util.*;

class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> stack = new Stack<>();

        for (int num : nums) {
            long current = num;
            
           
            while (!stack.isEmpty() && stack.peek() == current) {
                current += stack.pop();
            }
            
            
            stack.push(current);
        }

        return new ArrayList<>(stack);
    }
}