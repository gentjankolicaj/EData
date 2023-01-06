package io.gentjankolicaj.data.load.security;

import io.gentjankolicaj.data.commons.domain.User;
import io.gentjankolicaj.data.load.common.token.CustomToken;

import java.util.List;

public interface TokenService {

    List<CustomToken> getTokens(String username, String password);

    List<CustomToken> getTokens(String username, String email, String password);

    public List<CustomToken> getTokens(User user);

}
