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

    public int[] productExceptSelfWithoutDivision(int[] nums) {
        int length = nums.length;
        int[] productArray = new int[length];

        productArray[0] = 1;
        for (int i = 1; i < length; i++) {
            productArray[i] = nums[i - 1] * productArray[i - 1];
        }

        int rightProduct = 1;

        for (int i = length - 1; i >= 0; i--) {
            productArray[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return productArray;
    }
}