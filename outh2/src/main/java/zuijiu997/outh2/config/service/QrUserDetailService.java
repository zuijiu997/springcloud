package zuijiu997.outh2.config.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import zuijiu997.outh2.model.BaseUser;

/**
 * Created by fp295 on 2018/11/25.
 */
@Service
public class QrUserDetailService extends BaseUserDetailService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected BaseUser getUser(String qrCode) {
        return null;
    }
}
