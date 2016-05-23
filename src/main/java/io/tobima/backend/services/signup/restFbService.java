package io.tobima.backend.services.signup;

import java.io.IOException;

import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultWebRequestor;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.WebRequestor;

public class restFbService implements FacebookApiService {

	public AccessToken getPermanentAccessToken(String tokenAcccess)
			throws IOException {

		String queryString = buildGetAccessTokenQueryString(tokenAcccess);
		WebRequestor wr = new DefaultWebRequestor();
		WebRequestor.Response accessTokenResponse = wr.executeGet(queryString);

		return DefaultFacebookClient.AccessToken
				.fromQueryString(accessTokenResponse.getBody());
	}

	private String buildGetAccessTokenQueryString(String tokenAcccess) {
		String queryString = String
				.format("{0}client_id={1}&client_secret={2}&grant_type={3}&fb_exchange_token={4}",
						AuthenticationConstantManager.GET_ACCESS_TOKEN_URL,
						AuthenticationConstantManager.APP_ID,
						AuthenticationConstantManager.CREDITENTIALS_GRANT_TYPE,
						tokenAcccess);
		return queryString;
	}
}
