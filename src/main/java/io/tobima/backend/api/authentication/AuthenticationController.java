package io.tobima.backend.api.authentication;

import java.io.IOException;

import io.tobima.backend.api.ServiceExceptions.FailedToGetPermanentAccessTokenException;
import io.tobima.backend.services.signup.SignUpService;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.inject.Inject;

@Api(name = "tobimaApi",
version = "v1",
namespace = @ApiNamespace(ownerDomain = "io.tobima.backend",
    ownerName = "io.tobima.backend",
    packagePath = ""))




public class AuthenticationController{	
	

	private SignUpService signUpService;
	
	@Inject
	public AuthenticationController(SignUpService signUpService) {
		this.signUpService = signUpService;
	}
	
	@ApiMethod( path = "User/Authentication/SignUp", httpMethod = ApiMethod.HttpMethod.POST)
	public void  signUp(@Named("accessToken") String accessToken) throws FailedToGetPermanentAccessTokenException{
		try {
			signUpService.signUp(accessToken);
		} catch (IOException e) {
			throw new FailedToGetPermanentAccessTokenException("Something went wrong");
		}
	}
}
