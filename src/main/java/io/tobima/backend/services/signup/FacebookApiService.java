package io.tobima.backend.services.signup;

import java.io.IOException;

import com.restfb.FacebookClient.AccessToken;



public interface FacebookApiService {
	
	public AccessToken getPermanentAccessToken(String tokenAcccess) throws IOException;
}
