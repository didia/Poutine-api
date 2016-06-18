package io.tobima.backend.api.authentication;

import java.io.IOException;
import io.tobima.backend.api.ServiceExceptions.FailedToGetPermanentAccessTokenException;
import io.tobima.backend.services.signup.SignUpService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AuthenticationControllerTest {

	private AuthenticationController authenticationController;
	private SignUpService signUpService;
	
	private static final String ACCESS_TOKEN = "accessToken";
	
	@Before
	public void intialize(){
		
		signUpService = Mockito.mock(SignUpService.class);
		authenticationController = new AuthenticationController(signUpService);
	}
	
	@Test
	public void givenANewUserWhenAskedToSignhimUpSignupServiceShouldBeCalled() throws FailedToGetPermanentAccessTokenException, IOException{
		authenticationController.signUp(ACCESS_TOKEN);
		
		Mockito.verify(signUpService).signUp(ACCESS_TOKEN);
	}
	

	@Test(expected=FailedToGetPermanentAccessTokenException.class)
	public void givensignUpServiceWhenFailedToSignUpUserExceptionShoudlBeThrown() throws IOException, FailedToGetPermanentAccessTokenException{
		Mockito.doThrow(new IOException()).when(signUpService).signUp(ACCESS_TOKEN);
		
		authenticationController.signUp(ACCESS_TOKEN);
	}
	
	
	
	
}
