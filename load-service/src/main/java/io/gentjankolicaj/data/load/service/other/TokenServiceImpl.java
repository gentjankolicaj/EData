package io.gentjankolicaj.data.load.service.other;

import io.gentjankolicaj.data.load.common.domain.User;
import io.gentjankolicaj.data.load.common.other.CustomToken;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TokenServiceImpl implements TokenService {

    //todo: I need to inject appropriate components to receive assigned tokens from third party

    @Override
    public List<CustomToken> getTokens(String username, String password) {
        return null;
    }

    @Override
    public List<CustomToken> getTokens(String username, String email, String password) {
        return null;
    }

    @Override
    public List<CustomToken> getTokens(User user) {
        return null;
    }
}
