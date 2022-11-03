package leetcode.FindFirstLastPositionElementSortedArray;

public class Solution {
    public static void main(String[] args) {
        //        System.out.println(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));
        //        System.out.println(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6));
        //        System.out.println(searchRange(new int[] {1, 2, 2, 2, 2, 2, 2, 2}, 2));
        //        System.out.println(searchRange(new int[] {1, 2, 2, 2, 2, 2, 2, 2}, 1));
        //        System.out.println(1 >> 1);
        //        System.out.println(searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        //        System.out.println(searchMatrix(new int[][] {{1}}, 1));
        //        System.out.println(searchMatrix(new int[][] {{1, 2, 3, 4, 5}}, 4));
        //        System.out.println(searchMatrix(new int[][] {{1, 2, 3, 4, 5}}, 6));
        //        System.out.println(searchMatrix(new int[][] {{1}, {2}, {3}, {4}, {5}}, 6));
        //        System.out.println(searchMatrix(new int[][] {{1}, {2}, {3}, {4}, {5}}, 3));
        //        System.out.println(twoSum(new int[] {0, 0, 1, 1, 2, 3, 4, 5, 6}));
        //        System.out.println(findMin(new int[] {2, 3, 4, 5, 6, 0, 0, 1, 1}));
        //        System.out.println(findMin(new int[] {3, 4, 5, 6, 0, 0, 1, 1, 1, 2}));
        //        System.out.println(findMin(new int[] {4, 5, 6, 0, 0, 1, 1, 1, 2, 3}));
        //        System.out.println(findMin(new int[] {5, 6, 0, 0, 1, 1, 1, 2, 3, 4}));
        //        System.out.println(findMin(new int[] {6, 0, 0, 1, 1, 1, 2, 3, 4, 5}));
        //        System.out.println(findMin(new int[] {2, 2, 2, 0, 0, 1, 1, 1}));
        //        System.out.println(1 >> 1);
        System.out.println(twoSum(new int[] {1, 2, 3}, 4));
        System.out.println(twoSum(new int[] {2, 7, 11, 15}, 9));
        System.out.println(twoSum(new int[] {-1, 0}, -1));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        int start = 0;
        int end = nums.length - 1;

        if (nums[start] == target && nums[end] == target) {
            return new int[] {start, end};
        }
        while (start < end) {
            int mid = (start + end) / 2;
            if (start == mid || end == mid) {
                break;
            }
            //            System.out.println("start:" + start + "  end:" + end + " mid:" + mid);
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
                break;
            }

        }
        boolean isFind = false;
        if (nums[start] == target || nums[end] == target) {
            isFind = true;
        } else {
            //            System.out.println("[-1,-1]");
            return new int[] {-1, -1};
        }
        if (isFind) {
            if (nums[start] == target) {
                int tempEnd = start;
                while (start - 1 >= 0 && nums[start - 1] == target) {
                    start--;
                }
                while (tempEnd + 1 < nums.length && nums[tempEnd + 1] == target) {
                    tempEnd++;
                }
                //                System.out.println("[" + start + "," + tempEnd + "]");
                return new int[] {start, tempEnd};
            } else if (nums[end] == target) {
                int tempStart = end;
                while (end + 1 < nums.length && nums[end + 1] == target) {
                    end++;
                }
                while (tempStart - 1 >= 0 && nums[tempStart - 1] == target) {
                    tempStart--;
                }
                //                System.out.println("[" + tempStart + "," + end + "]");
                return new int[] {tempStart, end};
            }

        }
        return new int[] {start, end};
    }

    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {


        for (int i = 0; i < matrix[0].length; i++) {
            int startRow = 0;
            int endRow = matrix.length - 1;
            while (startRow <= endRow) {
                int mid = startRow + ((endRow - startRow) >> 1);
                if (matrix[mid][i] > target) {
                    endRow = mid - 1;
                } else if (matrix[mid][i] < target) {
                    startRow = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;

    }

    public static int findMin(int[] nums) {
        int start = 0;
        int res = nums[0];
        int end = nums.length - 1;
        //        System.out.print("input:");
        //        for (int i = 0; i < nums.length; i++) {
        //            System.out.print(nums[i] + ",");
        //        }
        //        System.out.println();
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            //            System.out.println("start:" + start + " mid:" + mid + " end:" + end + " nums[mid]:" +
            //                    nums[mid]);
            // 左侧是有序的
            if (nums[mid] >= nums[start]) {
                res = Math.min(res, nums[start]);
                res = Math.min(res, nums[mid]);
                start = mid + 1;
            } else {
                res = Math.min(res, nums[mid]);
                res = Math.min(res, nums[end]);
                end = mid - 1;
            }
        }
        return res;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < numbers.length && end >= 0 && numbers[start] + numbers[end] != target) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                break;
            }
        }
        System.out.println((start + 1) + " _ " + (end + 1));
        return new int[] {start + 1, end + 1};
    }
}
