package br.edu.ifba.paae.spring;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
 
@Component
public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
 
   private Map<String, String> roleUrlMap;
 
   @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
 
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String role = userDetails.getAuthorities().isEmpty() ? null : userDetails.getAuthorities().toArray()[0].toString();
            response.sendRedirect(request.getContextPath() + roleUrlMap.get(role));
        }
    }
 
    public void setRoleUrlMap(Map<String, String> roleUrlMap) {
        this.roleUrlMap = roleUrlMap;
    }
} 

