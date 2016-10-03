package algorithms.geeksforgeeks;

public class RotatedSorted {
public static void main(String[] args) {
	int nums[] = new int[] { 1,2,3,4,5};
	int low = 0;
    int high = nums.length - 1;
    while(nums[low] > nums[high]){
        int m = (high + low) / 2 ;
        if(nums[m] > nums[high]){
            low = m + 1;
        }
        else {
            high = m;
        }
    }
}
    //return low => min index
  //  return low - 1 < 0 ? nums[nums.length-1] : nums[low -1] ;
}
