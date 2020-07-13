package zuijiu997.outh2.config.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import zuijiu997.outh2.config.auth.decision.AccessDecisionManagerIml;
import zuijiu997.outh2.config.auth.deine.CustomAccessDeineHandler;
import zuijiu997.outh2.config.auth.entryPoint.JwtAuthenticationEntryPoint;
import zuijiu997.outh2.config.auth.filter.JwtAuthorizationTokenFilter;
import zuijiu997.outh2.config.auth.filter.MyLoginAuthenticationFilter;
import zuijiu997.outh2.config.auth.filter.PhoneLoginAuthenticationFilter;
import zuijiu997.outh2.config.auth.filter.QrLoginAuthenticationFilter;
import zuijiu997.outh2.config.auth.handler.MyLoginAuthSuccessHandler;
import zuijiu997.outh2.config.auth.provider.PhoneAuthenticationProvider;
import zuijiu997.outh2.config.auth.provider.QrAuthenticationProvider;
import zuijiu997.outh2.config.auth.provider.MyLoginAuthenticationProvider;
import zuijiu997.outh2.config.service.PhoneUserDetailService;
import zuijiu997.outh2.config.service.QrUserDetailService;
import zuijiu997.outh2.config.service.UsernameUserDetailService;

/**
 * Created by fp295 on 2018/4/15.
 */
@Configuration
//@Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 自动注入UserDetailsService
    @Autowired
    private UsernameUserDetailService usernameUserDetailService;

    @Autowired
    private PhoneUserDetailService phoneUserDetailService;

    @Autowired
    private QrUserDetailService qrUserDetailService;

    @Autowired
    private JwtAuthorizationTokenFilter jwtAuthorizationTokenFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    CustomAccessDeineHandler customAccessDeineHandler;



    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtAuthorizationTokenFilter,UsernamePasswordAuthenticationFilter.class)
//                .addFilterAt(getMyLoginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(getPhoneLoginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(getQrLoginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)

                // 配置登陆页/login并允许访问
//                .formLogin().loginPage("/login").successForwardUrl("/system/user").permitAll()
                .authorizeRequests().antMatchers("/system/login").permitAll()
                // 登出页
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/backReferer")
//                .and().authorizeRequests().antMatchers("/oauth/**").permitAll()
                // 其余所有请求全部需要鉴权认证
                .and().authorizeRequests()
                .accessDecisionManager(getAccessDecisionManager())
                .anyRequest().authenticated()
                // 由于使用的是JWT，我们这里不需要csrf
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //添加自定义异常入口，处理accessdeine异常
        http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeineHandler);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/swagger-resources/configuration/ui",
                "/swagger-resources",
                "/swagger-resources/configuration/security",
                "/swagger-ui.html"
        );
    }

    /**
     * 用户验证
     * @param auth
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(myLoginAuthenticationProvider());
        auth.authenticationProvider(phoneAuthenticationProvider());
        auth.authenticationProvider(qrAuthenticationProvider());
    }

    @Bean
    public AccessDecisionManager getAccessDecisionManager() {
        return new AccessDecisionManagerIml();
    }

    @Bean
    public BCryptPasswordEncoder myEncoder(){
        return new BCryptPasswordEncoder(6);
    }

    @Bean
    public MyLoginAuthenticationProvider myLoginAuthenticationProvider(){
        MyLoginAuthenticationProvider provider1 = new MyLoginAuthenticationProvider();
        // 设置userDetailsService
        provider1.setUserDetailsService(usernameUserDetailService);
        // 禁止隐藏用户未找到异常
        provider1.setHideUserNotFoundExceptions(false);
        // 使用BCrypt进行密码的hash
//        provider1.setPasswordEncoder(myEncoder());
        return provider1;
    }


    @Bean
    public PhoneAuthenticationProvider phoneAuthenticationProvider(){
        PhoneAuthenticationProvider provider = new PhoneAuthenticationProvider();
        // 设置userDetailsService
        provider.setUserDetailsService(phoneUserDetailService);
        // 禁止隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        return provider;
    }

    @Bean
    public QrAuthenticationProvider qrAuthenticationProvider(){
        QrAuthenticationProvider provider = new QrAuthenticationProvider();
        // 设置userDetailsService
        provider.setUserDetailsService(qrUserDetailService);
        // 禁止隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        return provider;
    }

    @Bean
    public MyLoginAuthenticationFilter getMyLoginAuthenticationFilter() {
        MyLoginAuthenticationFilter filter = new MyLoginAuthenticationFilter();
        try {
            filter.setAuthenticationManager(this.authenticationManagerBean());
        } catch (Exception e) {
            e.printStackTrace();
        }
        filter.setAuthenticationSuccessHandler(new MyLoginAuthSuccessHandler());
        filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/login?error"));
        return filter;
    }


    /**
     * 手机验证码登陆过滤器
     * @return
     */
    @Bean
    public PhoneLoginAuthenticationFilter getPhoneLoginAuthenticationFilter() {
        PhoneLoginAuthenticationFilter filter = new PhoneLoginAuthenticationFilter();
        try {
            filter.setAuthenticationManager(this.authenticationManagerBean());
        } catch (Exception e) {
            e.printStackTrace();
        }
        filter.setAuthenticationSuccessHandler(new MyLoginAuthSuccessHandler());
        filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/login?error"));
        return filter;
    }

    @Bean
    public QrLoginAuthenticationFilter getQrLoginAuthenticationFilter() {
        QrLoginAuthenticationFilter filter = new QrLoginAuthenticationFilter();
        try {
            filter.setAuthenticationManager(this.authenticationManagerBean());
        } catch (Exception e) {
            e.printStackTrace();
        }
        filter.setAuthenticationSuccessHandler(new MyLoginAuthSuccessHandler());
        filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/login?error"));
        return filter;
    }
}
