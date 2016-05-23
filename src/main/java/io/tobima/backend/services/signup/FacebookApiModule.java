package io.tobima.backend.services.signup;

import com.google.inject.AbstractModule;

public class FacebookApiModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(FacebookApiService.class).to(restFbService.class);
		
	}

}
