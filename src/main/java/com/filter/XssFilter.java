package com.filter;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉<br>
 * 〈拦截Xss注入〉
 *
 * @author baiwc
 * @date 2019-12-11 13:54
 * @since 2019.12.11
 */
@Slf4j
public class XssFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(XssFilter.class);

    //是否过滤富文本内容
    private static boolean IS_INCLUDE_RICH_TEXT =false;

    private List<String> excludes = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("filter装载。。。");
        if (logger.isDebugEnabled()){
            logger.debug("xss filter is init===========>");
        }
        String isIncludeRichText = filterConfig.getInitParameter("isIncludeRichText");
        if (StringUtils.isNotBlank(isIncludeRichText)){
            IS_INCLUDE_RICH_TEXT = BooleanUtils.toBoolean(isIncludeRichText);
        }
        String temp = filterConfig.getInitParameter("excludes");
        if (StringUtils.isNotBlank(temp)){
            String[] urls = temp.split(",");
            for (int i = 0 ; i < urls.length; i++){
                //数据量较小
                excludes.add(urls[i]);
                //数据量较大
                //Collections.addAll(excludes,urls[i]);
            }
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器");
        if (logger.isDebugEnabled()){
            logger.debug("XSS Filter is open !!!");
        }
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (HandleExcludeURI(req)){
            filterChain.doFilter(req,resp);
            return;
        }
        XssHttpRequestWrapper xssRequest = new XssHttpRequestWrapper(req,IS_INCLUDE_RICH_TEXT);
        filterChain.doFilter(xssRequest,resp);
    }

    private boolean HandleExcludeURI(HttpServletRequest req) {

        if (excludes == null || excludes.isEmpty()){
            return false;
        }
        String url = req.getServletPath();
        logger.info("ServletPath: " + url);
        for (String pattern:excludes) {
            Pattern p = Pattern.compile("^" + pattern);
            if (p.matcher(url).find()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}