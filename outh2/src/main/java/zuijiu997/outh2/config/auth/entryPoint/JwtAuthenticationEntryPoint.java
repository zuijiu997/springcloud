package zuijiu997.outh2.config.auth.entryPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {

        logger.info("JwtAuthenticationEntryPoint:"+authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"没有凭证");

//        //验证为未登陆状态会进入此方法，认证错误
//        System.out.println("认证失败：" + authException.getMessage());
//        response.setStatus(200);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter printWriter = response.getWriter();
//        String body = ResultJson.failure(ResultCode.UNAUTHORIZED, authException.getMessage()).toString();
//        printWriter.write(body);
//        printWriter.flush();
    }
}
