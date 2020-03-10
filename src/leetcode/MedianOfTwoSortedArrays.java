package leetcode;



public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,7};
		int[] nums2 = {4,5,6};
//		int[] nums2 = {1};
//		int[] nums1 = {3,4,5,6,7,8,9};
		System.out.println(findMedianSortedArrays(nums1,nums2));
//		System.out.println(findMedianSortedArrays2(nums1,nums2));
	}
	public static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		boolean isOdd = ((l1+l2)%2==1);
		int[] A;
		int[] B;
		if(l2>=l1) {
			A = nums1;
			B = nums2;
		}else {
			A = nums2;
			B = nums1;
		}
		int imin = 0 ;
		int imax = A.length;
		int i = -1;
		int j = -1;
		while(imin<=imax) {
			i = (imin +imax)/2;
			j = (l1+l2+1)/2-i;
			if(i>imin&&A[i-1]>B[j]) {
				imax = i-1;
			}else if(i<imax&&B[j-1]>A[i]) {
				imin = i+1;
			}else {
				int left_max = 0;
				if(i==0) {
					left_max = B[j-1];
				}else if (j==0){
					left_max = A[i-1];
				}else {
					left_max = Math.max(A[i-1], B[j-1]);
				}
				if(isOdd) {
					return left_max;
				}
				int right_min = 0;
				if(i==A.length) {
					right_min = B[j];
				}else if(j == B.length) {
					right_min = A[i];
				}else{
					right_min =Math.min(A[i], B[j]);
				}
					return ((double)(left_max+right_min))/2;
			}
		}
		return -1;
	}
}
