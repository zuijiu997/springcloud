package zuijiu997.outh2.bussiness.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import zuijiu997.outh2.config.auth.utils.JwtTokenUtil;
import zuijiu997.outh2.config.service.BaseUserDetailService;
import zuijiu997.outh2.config.service.UsernameUserDetailService;
import zuijiu997.outh2.model.BaseUser;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/system")
public class IndexCtrl {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UsernameUserDetailService usernameUserDetailService;

    @PostMapping("/login")
    public String login(@RequestBody BaseUser baseUser, HttpServletRequest request){
        final UserDetails userDetails = usernameUserDetailService.loadUserByUsername(baseUser.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }
//
//    public ResponseUserToken login(String username, String password) {
//        //用户验证
//        final Authentication authentication = authenticate(username, password);
//        //存储认证信息
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        //生成token
//        final User user = (User) authentication.getPrincipal();
////        User user = (User) userDetailsService.loadUserByUsername(username);
//        final String token = jwtTokenUtil.generateAccessToken(user);
//        //存储token
//        jwtTokenUtil.putToken(username, token);
//        return new ResponseUserToken(token, user);
//    }
//
//    private Authentication authenticate(String username, String password) {
//        try {
//            //该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，如果正确，则存储该用户名密码到“security 的 context中”
//            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException | BadCredentialsException e) {
//            throw new CustomException(ResultJson.failure(ResultCode.LOGIN_ERROR, e.getMessage()));
//        }
//    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/api/hello")
    public String apiHello() {
        return "Hello World";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/api/user")
    public Object user() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }
}
