package com.xss;

import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉<br>
 * 〈正则测试〉
 *
 * @author baiwc
 * @date 2019-12-10 14:49
 * @since 2019.12.10
 */
public class RexTest {
    public static void main(String[] args) {

        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern pattern = Pattern.compile(regEx);
		String str = "<img%20src=1%20onerror=alert(1)>";
		if (pattern.matcher(str).find()){
            System.out.println("生效了");
        }else {
            System.out.println("没有生效");
        }
    }
}