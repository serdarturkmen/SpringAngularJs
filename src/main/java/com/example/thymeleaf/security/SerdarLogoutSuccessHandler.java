package com.example.thymeleaf.security;

import com.example.thymeleaf.model.mon.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring Security logout handler, specialized for Ajax requests.
 * @author Serdar Turkmen
 */
@Component
public class SerdarLogoutSuccessHandler implements LogoutSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(SerdarAuthenticationFailureHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication)
        throws IOException, ServletException {
        User user = (User)authentication.getPrincipal();
        logger.info("Logout succeed for username : {}", user.getEmail());
        response.sendRedirect(request.getContextPath() + "/");
    }
}
