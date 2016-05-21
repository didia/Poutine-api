package io.tobima.backend.api.authentication;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.ApiMethod;

@Api(name = "myApi",
version = "v1",
namespace = @ApiNamespace(ownerDomain = "io.tobima.backend",
    ownerName = "io.tobima.backend",
    packagePath = ""))




public class AuthenticationController {	
	@ApiMethod( name = "User/SignUp", httpMethod = ApiMethod.HttpMethod.POST)
	public void signUp(User user){
		user.getEmail();
	}

}
