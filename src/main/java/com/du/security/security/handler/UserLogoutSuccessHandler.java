package com.du.security.security.handler;

import com.du.security.util.ResultUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登出成功处理类
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    /**
     * 用户登出返回结果
     * 这里应该让前端清除掉Token
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Map<String,Object> resultData = new HashMap<>();
        resultData.put("code","200");
        resultData.put("msg","登出成功");
        SecurityContextHolder.clearContext();
        ResultUtil.responseJson(httpServletResponse,ResultUtil.resultSuccess(resultData));
    }
}