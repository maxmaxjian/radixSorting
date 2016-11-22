import java.util.Arrays;
import java.util.List;

class Solution {
    public void radixSort(List<Integer> nums) {
        int nth = 1;
        while (!allzeros(nums, nth)) {
            insertsort(nums, nth);
            for (int i : nums)
                System.out.print(i+" ");
            System.out.println();
            nth++;
        }
    }

    private int getNth(int num, int nth) {
        int rs = num;
        while (nth-- > 0)
            rs /= 10;
        return rs%10;
    }

    private boolean allzeros(List<Integer> nums, int nth) {
        for (int i = 0; i < nums.size(); i++)
            if (getNth(nums.get(i), nth) != 0)
                return false;
        return true;
    }

    private void insertsort(List<Integer> nums, int nth) {
        for (int i = 1; i < nums.size(); i++) {
            int j = i;
            while (j > 0 && getNth(nums.get(j), nth) < getNth(nums.get(j-1), nth)) {
                swap(nums, j, j - 1);
                j--;
            }
        }
    }

    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public static void main(String[] args) {
        Integer[] ints = {170, 45, 75, 90, 802, 2, 24, 66};
        List<Integer> nums = Arrays.asList(ints);
        System.out.println("Before sorting:");
        for (int i : nums)
            System.out.print(i+" ");
        System.out.println();

        Solution soln = new Solution();
        soln.radixSort(nums);
        System.out.println("After sorting:");
        for (int i : nums)
            System.out.print(i+" ");
        System.out.println();
    }
}