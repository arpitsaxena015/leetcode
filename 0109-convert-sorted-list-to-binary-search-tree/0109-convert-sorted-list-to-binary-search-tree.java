class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // Find the middle element using slow and fast pointers
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the left half from the middle node
        if (prev != null) {
            prev.next = null;
        }

        // Mid node becomes the root
        TreeNode root = new TreeNode(slow.val);

        // Recursively build left and right subtrees
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}