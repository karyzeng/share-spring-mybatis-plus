package com.zzp.base.exceptions;


/**
 * <p>
 * FeignAPI异常
 * </p>
 *
 * @author Garyzeng
 * @since 2019.12.27
 */
public class FeignApiException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -666380838543178595L;


    public FeignApiException(String message) {
        super(message);
    }
    
    public FeignApiException(Throwable cause) {
        super(cause);
    }

    public FeignApiException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
