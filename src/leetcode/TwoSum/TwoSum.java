package leetcode.TwoSum;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,1,2} ;
		System.out.println(a.length);
		for(int i :a) {
			System.out.println(i);
		}

		System.out.println(a[1]+a[2]==3);
		int si=1;
		int sii = 2;
		int[] q2 = {si,sii};
		System.out.println(q2);
		boolean ards = true;
	}



//    public int[] twoSum(int[] nums, int target) {
//        int l = nums.length;
//        for(int si=0;si<l-1;si++){
//            for(int sii=si+1;sii<l;sii++){
//                if(nums[si]+nums[sii]==target){
//                    return {si,sii};
//                }
//            }
//        }
//        return null;
//    }
}
