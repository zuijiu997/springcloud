package zuijiu997.outh2.config.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fp295 on 2018/5/15.
 */
//@Controller
//@SessionAttributes({"authorizationRequest"})
//@RestController
public class MvcController {

//    @Autowired
//    private BaseClientService baseClientService;
//
//    /**
//     * 登出回调
//     * @param request
//     * @param response
//     */
//    @RequestMapping("/backReferer")
//    public void sendBack(HttpServletRequest request, HttpServletResponse response) {
//
//        try {
//            //sending back to client app
//            String referer = request.getHeader("referer");
//            if (referer != null) {
//                int index = referer.indexOf("?");
//                if(index != -1)
//                    referer = referer.substring(0, index);
//                response.sendRedirect(referer);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 授权页面
//     * @param model
//     * @return
//     */
//    @RequestMapping("/oauth/confirm_access")
//    public ModelAndView authorizePage(Map<String, Object> model) {
//        // 获取用户名
//        String userName = ((UserDetails) SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getPrincipal())
//                .getUsername();
//        model.put("userName", userName);
//        return new ModelAndView("authorize", model);
//    }
//
//    /**
//     * 主页，未从客户端跳转直接登陆会显示
//     * @param model
//     * @return
//     */
//    @RequestMapping("/")
//    public ModelAndView indexPage(Map<String, Object> model) {
//        // 获取用户名
//        String userName = ((UserDetails) SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getPrincipal())
//                .getUsername();
//        model.put("userName", userName);
//        // 获取全部客户端应用
//        ResponseData responseData = baseClientService.getAllClient();
//        if(ResponseCode.SUCCESS.getCode().equals(responseData.getCode()) && responseData.getData() != null) {
//            model.put("client",responseData.getData());
//        } else {
//            model.put("client",new ArrayList<>());
//        }
//        return new ModelAndView("index", model);
//    }


}
