package Others;

/**
 * Created by lwy on 2016/9/19.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class HardJump {
    private int hardJump(int target) {
        if (target <= 1)
            return 1;
        else
            return 2 * hardJump(target - 1);
    }
}
