class Solution {
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0) return null;
        
        return merge(lists, 0, lists.length-1);
    }

    public static ListNode merge(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        
        int mid = left + (right-left)/2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        
        return mergeTwoLists(l1, l2);
    }

    /* already implemented in Merge Two Sorted Array */
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(l1 != null && l2 != null){ 
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;     
    }
}