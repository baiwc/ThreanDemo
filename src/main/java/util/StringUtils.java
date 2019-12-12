package util;

/**
 * 〈一句话功能简述〉<br>
 * 〈字符串工具类〉
 *
 * @author baiwc
 * @date 2019-12-11 10:32
 * @since 2019.12.11
 */
public class StringUtils{

    public static boolean isBlank(String s){

        return (s == null ||"".equals(s));
    }

    public static boolean isNotBlank(String s){
        return !isBlank(s);
    }


}