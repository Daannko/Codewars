import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Solution {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int offset = 0;
        for (int i =0 ; i < m + n ; i++){
            if(offset == n) break;
            if(nums1[i] > nums2[offset] || i >= m + offset){
                for(int k = m + offset ; k > i ;k--){
                    nums1[k] = nums1[k - 1];
                }
                nums1[i] = nums2[offset];
                offset++;
            }
        }
        return nums1;
    }
/*    public static int removeDuplicates(int[] nums) {
        int counter = 0;

        List<Integer> values = new ArrayList<>();
        for(int i =0 ; i < nums.length - counter; i++){
            if(values.contains(nums[i])){
                for(int j = i; j < nums.length - 1 ; j++){
                    nums[j] = nums[j + 1];
                }
                counter++;
                i--;
            }else {
                values.add(nums[i]);
            }
        }
        return nums.length - counter;
    }*/

/*    public static int removeDuplicates(int[] nums) {
        int D = 1;
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i-1]!= nums[i]) nums[D++] = nums[i];
        }
        return D;
    }*/
public static int removeDuplicates(int[] nums) {
    if (nums.length <= 2) return nums.length;  // If the array has 2 or fewer elements, return its length as is.

    int j = 2;  // Start from the third position since the first two are always allowed.

    for (int i = 2; i < nums.length; i++) {
        // If the current element is not equal to the element two places before, it means it can be allowed.
        if (nums[i] != nums[j - 2]) {
            nums[j] = nums[i];  // Place the element in the correct position.
            j++;  // Move the pointer for the next unique/allowed duplicate element.
        }
    }

    return j;  // Return the length of the array with duplicates removed.
}

    public static int majorityElement(int[] nums) {
        int number = nums[0],counter = 1;
        for(int i =1 ; i < nums.length; i++){
            if(counter == 0) {
                number = nums[i];
                counter++;
            }
            else{
                if(nums[i] == number) counter++;
                else counter--;
            }

        }
        return number;
    }
    public static void main(String[] args) {

//
//        int[] nums = new int[]{2,4,1};
//        Solution solution = new Solution();
//        System.out.println(solution.maxProfit(nums));
//        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int[] numsClone = nums.clone();
        for(int i = 0; i < nums.length ;i++){
            nums[(i + k) % nums.length] = numsClone[i];
        }
    }

    public int maxProfit(int[] prices) {
        int min = prices[0],bestProfit = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min,prices[i]);
            bestProfit = Math.max(prices[i] - min, bestProfit);
        }
        return bestProfit;
    }
    
}