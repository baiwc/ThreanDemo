package com.array.sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈找出数组中重复的数字〉
 * 在一个长度为n的数组中所有的数字都在0—n-1的范围内。数组中某一些数字是重复的，但是不知道有几个数字重复了。也不知道重复了几次
 * 请找出数组中任意一个重复的数字。
 * 例如：长度为7的数组，{2,1,4,5,6,2,0}，那么输出的重复的数字是2
 *
 * @author baiwc
 * @date 2019-10-14 16:08
 * @since 2019.10.14
 */
public class DuplicateNumbers {

    public boolean duplicate(int[] data) {
        if (data.length <= 0) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0 || data[i] > data.length - 1) {
                return false;
            }
        }
//        for (int j = 0; j < data.length; j++) {
//            while ()
//        }
        return false;
    }
}