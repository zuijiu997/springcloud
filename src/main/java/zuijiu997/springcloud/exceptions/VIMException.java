/**
 * *
 * Copyright (c) Ericsson 2018. All Rights Reserved.                          *
 * Reproduction in whole or in part is prohibited without the                 *
 * written consent of the copyright owner.                                    *
 * *
 * ERICSSON MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY      *
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED      *
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR     *
 * PURPOSE, OR NON-INFRINGEMENT. ERICSSON SHALL NOT BE LIABLE FOR ANY         *
 * DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR            *
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.                             *
 * *
 * <p>
 * VIMException.java
 *
 * @author raintang
 * Mar 11, 2015 4:55:32 PM
 * @description
 */

/**
 * VIMException.java
 *
 * @author raintang
 *         Mar 11, 2015 4:55:32 PM
 * @description
 */
package zuijiu997.microservice.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;


/**
 * @author
 * @description
 */
public class VIMException extends Exception {
    private Logger logger = LoggerFactory.getLogger(VIMException.class);

    /**
     * @author
     * @description
     */
    private int errorCode;

    /**
     * @author
     * @description
     */
    private static final long serialVersionUID = -1124572175791407638L;

    public VIMException(int code) {
        super("[EXCEPTION_CODE=" + code + "] ");
        errorCode = code;
    }

    public VIMException(int code, Throwable cause) {
        super("[EXCEPTION_CODE=" + code + "] ");
        errorCode = code;
        logger.error("VIM occurs exception", cause);
    }

    public VIMException(int code, String message) {
        super(message);
        errorCode = code;
    }

    public VIMException(int code, String message, Throwable cause) {
        super(message);
        errorCode = code;
        logger.error("VIM occurs exception", cause);
    }

    public VIMException(int code, Object[] args) {
        super(MessageFormat.format("[EXCEPTION_CODE=" + code + "] ", args));
        errorCode = code;
    }

    public VIMException(int code, Object[] args, Throwable cause) {
        super(MessageFormat.format("[EXCEPTION_CODE=" + code + "] ", args));
        errorCode = code;
        logger.error("VIM occurs exception", cause);
    }

    public int getErrorCode() {
        return errorCode;
    }

}
