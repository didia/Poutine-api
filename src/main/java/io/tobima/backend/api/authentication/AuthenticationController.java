package io.tobima.backend.api.authentication;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiNamespace;

@Api(name = "myApi",
version = "v1",
namespace = @ApiNamespace(ownerDomain = "io.tobima.backend",
    ownerName = "io.tobima.backend",
    packagePath = ""))


public class AuthenticationController {

}
