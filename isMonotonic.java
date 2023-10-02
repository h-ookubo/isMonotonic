class Solution {
    public static void main(String[] args) {
      Solution ins = new Solution();
      int[] arr = {1,2,3,3};
      System.out.println(ins.isMonotonic(arr) == true);
      int[] arr2 = {6,5,4,4};
      System.out.println(ins.isMonotonic(arr2) == true);
      int[] arr3 = {1,3,2,2};
      System.out.println(ins.isMonotonic(arr3) == false);
      System.out.println("すべてTrueなら一旦成功");
    }

    public boolean isMonotonic(int[] nums) {
        return 1>2;
    }
}