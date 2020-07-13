package zuijiu997.outh2.config.auth.deine;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeineHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/javascript;charset=utf-8");
        response.getWriter().print("没有访问权限!");


//        //登陆状态下，权限不足执行该方法
//        System.out.println("权限不足：" + e.getMessage());
//        response.setStatus(200);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter printWriter = response.getWriter();
//        String body = ResultJson.failure(ResultCode.FORBIDDEN, e.getMessage()).toString();
//        printWriter.write(body);
//        printWriter.flush();
    }
}
