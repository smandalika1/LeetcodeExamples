import java.util.Arrays;

public class ArrayAddition {

    public static void main(String args[]){
        int arr[]=new int[]{1,7,3,6,5,6};
        ArrayAddition AA=new ArrayAddition();
        //System.out.println(AA.pivotIndex(arr));
        System.out.println(AA.pivotIndexOpt(arr));
    }

    public int pivotIndexOpt(int[] nums){
        int sum=0;
        int leftSum=0;

        for(int num:nums){
            sum=sum+num;
        }

        for(int i=0;i<nums.length;++i){
            if(leftSum==sum-leftSum-nums[i]){
                return i;
            }
            leftSum=leftSum+nums[i];

        }
        return -1;
    }
    public int pivotIndex(int[] nums) {
        int j=1;
        int i=0;
        for(i=0;i<nums.length;i++,j++){
            int leftSum=0;
            int rightSum=0;
            int[] leftArr=new int[j-1];
            leftArr = Arrays.copyOfRange(nums, 0, j-1);

            int[]rightArr=new int[nums.length-(j-1)];
            rightArr=Arrays.copyOfRange(nums,j,nums.length);

            leftSum=sum(leftArr);
            rightSum=sum(rightArr);

            System.out.println("left sum--"+leftSum);
            System.out.println("right sum--"+rightSum);

            System.out.println("j=="+j);

            if(leftSum==rightSum){
                return j-1;
            }

        }
        return -1;

    }

    private int sum(int[] numArr){
        int sum=0;
        for(int i=0;i<numArr.length;i++){
            sum=sum+numArr[i];
        }
        return sum;
    }
}
