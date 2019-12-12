package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

/**
 * 〈一句话功能简述〉<br>
 * 〈XSS非法过滤工具类〉
 *
 * @author baiwc
 * @date 2019-12-11 10:09
 * @since 2019.12.11
 */
public class JsoupUtil {

    /**
     * 使用自带的basicWithImages 白名单
     * 允许的便签有a,b,blockquote,br,cite,code,dd,dl,dt,em,i,li,ol,p,pre,q,small,span,
     * strike,strong,sub,sup,u,ul,img
     * 以及a标签的href,img标签的src,align,alt,height,width,title属性
     */
    private static final Whitelist whitelist = Whitelist.basicWithImages();

    /**配置过滤化参数，不对代码进行格式化*/
    public static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);


    static{

         // 富文本编辑时一些样式是使用style来进行实现的
         //比如红色字体 style="color:red;"
         //所以需要给所有标签添加style属性
        whitelist.addAttributes(":all","style");
    }

    public static String clean  (String content){
        if (StringUtils.isNotBlank(content)){
            content = content.trim();
        }
        return Jsoup.clean(content,"",whitelist,outputSettings);
    }

    public static void main(String[] args) {
        String text = "<a href=\"http://www.baidu.com/a\" onclick=\"alert(1);\">sss</a><script>alert(0);</script>sss";
        String url = "<http://localhost:8090/hello?userid=\"onclick=\"alert(1)\"\"<script>>";
        System.out.println(JsoupUtil.clean(url));
        System.out.println(url);
    }



}