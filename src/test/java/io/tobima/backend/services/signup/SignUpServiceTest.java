package io.tobima.backend.services.signup;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class SignUpServiceTest {

	
	
	private SignUpService signUpService;
	private FacebookApiService facebookApiService;
	
	private static final String ACCESS_TOKEN = "token";
	
	@Before
	public void initialize(){
		facebookApiService = Mockito.mock(FacebookApiService.class);
		signUpService = new SignUpService(facebookApiService);
	}
	
	@Test
	public void givenAnAccessTokenWhenAskedToGetThePermanentAccessTokenFacebookApiServiceShouldBeCalled() throws IOException{
		signUpService.signUp(ACCESS_TOKEN);
		
		Mockito.verify(facebookApiService).getPermanentAccessToken(ACCESS_TOKEN);
	}
	
	
}
