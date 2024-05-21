class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int expectedNums = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[expectedNums] = nums[i];
                expectedNums++;
            }
        }
        System.out.println(expectedNums);
    }
}