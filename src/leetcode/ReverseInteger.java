package leetcode;

public class ReverseInteger {

	// Given a 32-bit signed integer, reverse digits of an integer.
	//
	// Example 1:
	//
	// Input: 123
	// Output: 321
	// Example 2:
	//
	// Input: -123
	// Output: -321
	// Example 3:
	//
	// Input: 120
	// Output: 21
	// Note:
	// Assume we are dealing with an environment which could only store integers
	// within
	// the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this
	// problem,
	// assume that your function returns 0 when the reversed integer overflows.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MIN_VALUE);
		System.out.println(reverse(-1463847412));
	}

	private final static int tenOfMaxInt = Integer.MAX_VALUE / 10;
	private final static int tenOfMinInt = Integer.MIN_VALUE / 10;
	private final static int lastOfMaxInt = Integer.MAX_VALUE % 10;
	private final static int lastOfMinInt = Integer.MIN_VALUE % 10;

	public static int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int pop = x % 10;
			if (res > tenOfMaxInt || (res == tenOfMaxInt && pop > lastOfMaxInt) || res < tenOfMinInt
					|| (res == tenOfMinInt && pop < lastOfMinInt)) {
				return 0;
			}
			res = res * 10 + pop;
			x = x / 10;
		}

		return res;
	}
}
