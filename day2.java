class Day2 {
    public int[] productExceptSelf(int[] nums) {

        int totalProduct = 1;
        int totalZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                totalProduct *= nums[i];
            } else {
                ++totalZero;
            }
            if (totalZero > 1) {
                totalProduct = 0;
                break;
            }
        }

        int productArray[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (totalZero > 1) {
                productArray[i] = 0;

            } else if (totalZero == 1) {
                if (nums[i] != 0) {
                    productArray[i] = 0;
                } else {
                    productArray[i] = totalProduct;
                }
            } else {
                productArray[i] = (totalProduct / nums[i]);
            }
        }

        return productArray;
    }
}