package io.tobima.backend.api.ServiceExceptions;

import com.google.api.server.spi.ServiceException;

public class FailedToGetPermanentAccessTokenException  extends ServiceException {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = -2314084548347146572L;

	public FailedToGetPermanentAccessTokenException(String message) {
		    super(500, message);
		  }
}
