package edata.config.security;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Component;

//This component is to initialize security with class of configs as argument
@Component
public class WebApplicationSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public WebApplicationSecurityInitializer() {
        super(WebSecurityConfig.class);
    }
}
