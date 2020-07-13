package zuijiu997.outh2.config.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import zuijiu997.outh2.model.BaseUser;

import java.util.Date;

/**
 * Created by fp295 on 2018/11/25.
 */
@Service("UsernameUserDetailService")
public class UsernameUserDetailService extends BaseUserDetailService {

    private Logger logger = LoggerFactory.getLogger(UsernameUserDetailService.class);

    @Override
    protected BaseUser getUser(String username) {
//        // 账号密码登陆调用FeignClient根据用户名查询用户
//        ResponseData<BaseUser> baseUserResponseData = baseUserService.getUserByUserName(username);
//        if(baseUserResponseData.getData() == null || !ResponseCode.SUCCESS.getCode().equals(baseUserResponseData.getCode())){
//            logger.error("找不到该用户，用户名：" + username);
//            throw new UsernameNotFoundException("找不到该用户，用户名：" + username);
//        }
//        return baseUserResponseData.getData();

        BaseUser baseUser = new BaseUser();
        baseUser.setActive(1);
        baseUser.setAge(10);
        baseUser.setCreateDate(new Date());
        baseUser.setGender("male");
        baseUser.setId("1");
        baseUser.setPassword("ls");
        baseUser.setUserName("ls");
        baseUser.setPhone("18428362223");
        baseUser.setUpdateDate(new Date());
        return baseUser;
    }
}
