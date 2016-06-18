package io.tobima.backend.dependencyInjection;

import io.tobima.backend.services.signup.FacebookApiModule;
import io.tobima.backend.services.signup.FacebookApiService;
import io.tobima.backend.services.signup.SignUpService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.api.server.spi.guice.GuiceSystemServiceServletModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;



public class GuiceContextListener extends GuiceServletContextListener {
	
	@Override
	protected Injector getInjector() {
		List<Module> moduleList = new ArrayList<Module>();
		moduleList.add(new FacebookApiModule());
		return Guice.createInjector(moduleList);
	}

	private static class GuiceSSSModule extends GuiceSystemServiceServletModule {
		@Override
		protected void configureServlets() {
			super.configureServlets();
			Set<Class<?>> serviceClasses = createSetOfServiceClasses();
			this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);
		}

		private Set<Class<?>> createSetOfServiceClasses() {
			Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
			serviceClasses.add(FacebookApiService.class);
			serviceClasses.add(SignUpService.class);
			return serviceClasses;
		}
	}

}
