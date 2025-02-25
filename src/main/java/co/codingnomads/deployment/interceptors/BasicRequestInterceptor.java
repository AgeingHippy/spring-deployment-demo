package co.codingnomads.deployment.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.text.MessageFormat;

@Slf4j
@Component
public class BasicRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = String.valueOf(request.getRequestURL());
        String sourceIp = request.getHeader("X-Forwarded-For");
        String method = request.getMethod();

        log.info(MessageFormat.format("{0} : {1} : {2}", sourceIp, method, url));

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
