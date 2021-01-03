package src.com.System.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebFilter(urlPatterns ={
        "/*","*.do","*.html","/atuo/test"},
        initParams = {
                @WebInitParam(name="encoding",value = "UTF-8")
        })
public class CssEncodFilter implements Filter {
    private String encoding;
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException, UnsupportedEncodingException, UnsupportedEncodingException {
        //业务逻辑
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response= (HttpServletResponse) resp;

        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        //将当前拦截的请求放行，让请求继续访问他要访问的资源
        chain.doFilter(request,response);
    }
    public void destroy() {
    }
}
