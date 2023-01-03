package io.gentjankolicaj.data.load.service.other;

import io.gentjankolicaj.data.load.common.domain.User;
import io.gentjankolicaj.data.load.common.other.CustomToken;

import java.util.List;

public interface TokenService {

    List<CustomToken> getTokens(String username, String password);

    List<CustomToken> getTokens(String username, String email, String password);

    public List<CustomToken> getTokens(User user);

}
