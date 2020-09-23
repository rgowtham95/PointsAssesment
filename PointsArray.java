public class PointsArray {
    public static void main(String[] args) {
        int [] array = {2,2,3,3,3,4};
        System.out.println(deleteAndEarn(array));
        int [] array2 = {3,4,2};
        System.out.println(deleteAndEarn(array2));
    }

    public static int deleteAndEarn(int[] nums) {
        return recursiveDeleteAndEarn(0, 0, nums);
    }


    public static int recursiveDeleteAndEarn(int index, int points, int [] nums) {
        if (index >= nums.length) {
            return points;
        }
        int num1 = 0;
        boolean same = false;
        if(index < nums.length - 1) {
            num1 = recursiveDeleteAndEarn(index + 1, points, nums);
        }
        same = true;
        int [] numsEdit = new int [nums.length];
        int num2 = 0;
        if(same) {
            for(int i = 0; i < nums.length; i++) {
                numsEdit[i] = nums[i];
            }
            int morePoints = 0;
            if(numsEdit[index] != -1) {
                morePoints += numsEdit[index];
            }

            for (int i = 0; i < nums.length; i++) {
                if ((numsEdit[i] == numsEdit[index] + 1) || (numsEdit[i] == numsEdit[index] - 1)) {
                    numsEdit[i] = -1;
                }
            }
            num2 = recursiveDeleteAndEarn(index + 1, points + morePoints, numsEdit);
        }
        else {
            int morePoints = 0;
            if(nums[index] != -1) {
                morePoints += nums[index];
            }

            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] == nums[index] + 1) || (nums[i] == nums[index] - 1)) {
                    nums[i] = -1;
                }
            }
            num2 = recursiveDeleteAndEarn(index + 1, points + morePoints, nums);
        }
        return Math.max(num1, num2);
    }
}