package io.tobima.backend.api.ServiceExceptions;

import com.google.api.server.spi.ServiceException;

public class FailedToGetPermanentAccessTokenException  extends ServiceException {
	
	  public FailedToGetPermanentAccessTokenException(String message) {
		    super(500, message);
		  }
}
