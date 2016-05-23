package io.tobima.backend.services.signup;

import java.io.IOException;

import com.google.inject.Inject;

public class SignUpService {
	
	private FacebookApiService fbAPiService;
	
	@Inject
	public SignUpService(FacebookApiService fbApiService) {
		this.fbAPiService = fbApiService;
	}
	
	
	public void signUp(String accessToken) throws IOException{
		
		fbAPiService.getPermanentAccessToken(accessToken);		
	}
}
