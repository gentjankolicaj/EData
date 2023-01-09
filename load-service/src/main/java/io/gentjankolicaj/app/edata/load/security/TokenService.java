package io.gentjankolicaj.app.edata.load.security;

import io.gentjankolicaj.app.edata.commons.domain.User;

import java.util.List;

public interface TokenService {

    List<CustomToken> getTokens(String username, String password);

    List<CustomToken> getTokens(String username, String email, String password);

    public List<CustomToken> getTokens(User user);

}
