package cc.service_zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: spring_cloud
 * @description:
 * @author: C_xf
 * @create: 2018-12-07 16:17
 **/
@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    public String filterType() {
//        过滤类型：路由之前
        log.debug("判断过滤类型！");
        return "pre";
    }

    public int filterOrder() {
//        过滤顺序
        log.debug("判断过滤顺序！");
        return 0;
    }

    public boolean shouldFilter() {
        log.debug("判断是否需要过滤！");
        return true;
    }

    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(request.getMethod()+" "+request.getRequestURL().toString());
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.debug("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {}

            return null;
        }
        log.debug("转发路由！");
        return null;
    }
}
