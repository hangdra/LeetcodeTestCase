package AddTwoNumbers;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		a1.next=a2;
		a2.next=a3;
		b1.next=b2;
		b2.next=b3;
		ListNode resu = addTwoNumbers2(a1,b1);
		while(resu.next!=null) {
			System.out.println(resu.val);
			resu = resu.next;
		}
		System.out.println("final");
		System.out.println(resu.val);
		System.out.println(15/10);
	}


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    	ListNode out = new ListNode(0);
        ListNode outt = new ListNode(0);
        boolean first = true;
        int outval = 0;
        int low_increase = 0;
        do{
        	int vout = l1.val+l2.val+low_increase;
            if (vout>9){
                outval = vout-10;
                low_increase=1;
            }else{
                outval = vout;
                low_increase=0;
            }
            if (first){
                out.val = outval;
                out.next = outt;
                first=false;
            }else{
                outt.val = outval;
                outt.next = new ListNode(0);
                outt = outt.next;
            }
            l1=l1.next;
            l2=l2.next;
        }while(l1!=null);

        return out;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode(0);
        ListNode outt = new ListNode(0);
        boolean first = true;
        int outval = 0;
        int low_increase = 0;
        while(l1!=null | l2!=null){
        	int vout = 0;
        	if(l1!=null && l2!=null) {
        		vout = l1.val+l2.val+low_increase;
        		l1=l1.next;
                l2=l2.next;
        	}else if (l2!=null) {
        		vout = l2.val+low_increase;
                l2=l2.next;
        	}else {
        		vout = l1.val+low_increase;
        		l1=l1.next;
        	}
            if (vout>9){
                outval = vout-10;
                low_increase=1;
            }else{
                outval = vout;
                low_increase=0;
            }
            if (first){
            	outt = new ListNode(outval);
                out = outt;
                first = false;
            }else{
                outt.next = new ListNode(outval);
                outt = outt.next;
            }
        }
        if (low_increase!=0) {
        	outt.next = new ListNode(low_increase);
        }
        return out;
    }
}
