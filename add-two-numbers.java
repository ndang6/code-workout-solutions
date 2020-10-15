class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode dummyHead = new ListNode(0);
		ListNode runner = dummyHead;
      	int sum = 0;
      
      	while(l1 != null || l2 != null){
      		sum /= 10;
          
          	if(l1 != null) {
              sum += l1.val;
              l1 = l1.next;
            }
          
          	if(l2 != null) {
              sum += l2.val;
              l2 = l2.next;
            }
          
          	runner.next = new ListNode(sum % 10);
          	runner = runner.next;          
        }
      
      	if(sum >= 10) runner.next = new ListNode(1);
      	return dummyHead.next;
	}
}