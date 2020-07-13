package zuijiu997.outh2.config.auth.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.oauth2.provider.token.TokenStore;
import zuijiu997.outh2.constant.Constant;
import zuijiu997.outh2.model.BaseModuleResources;
import zuijiu997.outh2.model.BaseRole;
import zuijiu997.outh2.model.BaseUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@Configuration
public class AccessTokenUtils {
//    @Autowired
//    private TokenStore tokenStore;

//    @Autowired
//    private HttpServletRequest request;

//    @Autowired
//    private TokenExtractor tokenExtractor;

//    @Autowired
//    private RedisTemplate<String, BaseRole> baseRoleTemplate;

//    @Autowired
//    private RedisTemplate<String, BaseModuleResources> baseModelTemplate;

    /**
     * 从token获取用户信息
     * @return
     */
//    public BaseUser getUserInfo(){
//        return (BaseUser) getAccessToken().getAdditionalInformation().get(Constant.USER_INFO);
//    }

//    public List<BaseRole> getRoleInfo(){
//        String userId = getUserInfo().getId();
//        long size = baseRoleTemplate.opsForList().size(userId);
//        return baseRoleTemplate.opsForList().range(userId, 0, size);
//    }

//    public List<BaseModuleResources> getMenuInfo(){
//        String key = getUserInfo().getId() + "-menu";
//        long size = baseModelTemplate.opsForList().size(key);
//        return baseModelTemplate.opsForList().range(key, 0, size);
//    }

//    private OAuth2AccessToken getAccessToken() throws AccessDeniedException {
//        OAuth2AccessToken token;
//        // 抽取token
//        Authentication a = tokenExtractor.extract(request);
//        try {
//            // 调用JwtAccessTokenConverter的extractAccessToken方法解析token
//            token = tokenStore.readAccessToken((String) a.getPrincipal());
//        } catch(Exception e) {
//            throw new AccessDeniedException("AccessToken Not Found.");
//        }
//        return token;
//    }
}
