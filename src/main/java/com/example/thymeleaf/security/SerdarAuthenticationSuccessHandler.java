package com.example.thymeleaf.security;

import com.example.thymeleaf.bs.IUserBS;
import com.example.thymeleaf.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Spring Security success handler, specialized for Ajax requests.
 */
@Component
public class SerdarAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(SerdarAuthenticationSuccessHandler.class);


    @Autowired
    private IUserBS userBS;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication)
        throws IOException, ServletException {

        log.debug("login success");

        User user = (User)authentication.getPrincipal();
        user.setLastLogin(new Date());
        userBS.save(user);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
