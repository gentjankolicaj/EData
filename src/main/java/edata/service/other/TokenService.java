package edata.service.other;

import edata.common.domain.User;
import edata.common.other.CustomToken;

import java.util.List;

public interface TokenService {

    List<CustomToken> getTokens(String username,String password);

    List<CustomToken> getTokens(String username,String email,String password);

    public List<CustomToken> getTokens(User user);

}
