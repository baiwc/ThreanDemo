package com.filter;

import lombok.extern.slf4j.Slf4j;
import util.JsoupUtil;
import util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 〈一句话功能简述〉<br>
 * 〈xss攻击过滤器〉
 *
 * @author baiwc
 * @date 2019-12-11 11:31
 * @since 2019.12.11
 */
@Slf4j
public class XssHttpRequestWrapper extends HttpServletRequestWrapper{

    HttpServletRequest orgRequest = null;

    private boolean isIncludeRichText = false;

    public XssHttpRequestWrapper(HttpServletRequest request,boolean isIncludeRichText) {
        super(request);
        log.info("XssHttpRequestWrapper装载");
        orgRequest = request;
        this.isIncludeRichText = isIncludeRichText;
    }

    @Override
    public String getParameter(String name) {
        boolean flag = ("content".equals(name) || name.endsWith("WithHtml"));
        if (flag && !isIncludeRichText){
            return super.getParameter(name);
        }
        name = JsoupUtil.clean(name);
        String value = super.getParameter(name);
        if (StringUtils.isNotBlank(value)){
            value = JsoupUtil.clean(value);
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] arr = super.getParameterValues(name);
        if (arr != null){
            for (int i = 0; i < arr.length; i ++){
                arr[i] = JsoupUtil.clean(arr[i]);
            }
        }
        return arr;
    }

    /**
     * 覆盖getHeader方法，过滤参数名和参数值
     * 如果需要原始值，通过super.getHeaders(name)来获取
     */
    @Override
    public String getHeader(String name) {
        name = JsoupUtil.clean(name);
        String value = super.getHeader(name);
        if (StringUtils.isNotBlank(value)){
            JsoupUtil.clean(value);
        }
        return value;
    }

    public HttpServletRequest getOrgRequest(){
        return orgRequest;
    }

    public HttpServletRequest getOrgRequest(HttpServletRequest request){

        if (request instanceof XssHttpRequestWrapper){
            return ((XssHttpRequestWrapper) request).getOrgRequest();
        }
        return request;
    }

}