import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guangfuhe on 2017/9/12.
 */
public class TwoSum {

    /**
     * TwoSum O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] res= new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }

        return res;
    }

    /**
     * TwoSum O(n)
     * 转变为搜索问题，用map存，加速搜索。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int l = nums.length;
        for (int i = 0; i < l; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < l; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && i != map.get(tmp)) {
                res[0] = i;
                res[1] = map.get(tmp);
                break;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 4};

        int target = 6;
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }
}
