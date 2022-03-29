package com.loljoa.server.security.filter;

import com.loljoa.server.security.util.AuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.loljoa.server.security.util.GetAccount.getAccount;
import static com.loljoa.server.security.util.GetCookie.getCookieValue;
import static org.springframework.util.StringUtils.hasText;

public class SocialLoginFilter extends AbstractAuthenticationProcessingFilter {

    protected SocialLoginFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String auth_token = getCookieValue(request, "auth_token");
        String platform = getCookieValue(request, "token_platform");

        if (!hasText(auth_token)) {
            throw new InvalidCookieException("토큰이 없습니다.");
        }

        AuthenticationToken token = new AuthenticationToken(getAccount(platform, auth_token), null);
        return this.getAuthenticationManager().authenticate(token);
    }
}
