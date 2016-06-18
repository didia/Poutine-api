package io.tobima.backend.dependencyInjection;

import javax.servlet.http.HttpServlet;

import io.tobima.backend.api.authentication.AuthenticationController;

import com.google.inject.servlet.ServletModule;

public class AuthenticationServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		serve("/*").with(HttpServlet.class);
	}
}
