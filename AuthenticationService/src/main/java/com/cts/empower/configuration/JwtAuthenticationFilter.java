/*
 * package com.cts.empower.configuration;
 * 
 * import java.io.IOException;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.web.filter.GenericFilterBean;
 * 
 * import com.cts.empower.service.CustomerUserDetailService; import
 * com.cts.empower.util.JwtUtil;
 * 
 * import jakarta.servlet.FilterChain; import jakarta.servlet.ServletException;
 * import jakarta.servlet.ServletRequest; import
 * jakarta.servlet.ServletResponse; import
 * jakarta.servlet.http.HttpServletRequest;
 * 
 * public class JwtAuthenticationFilter extends GenericFilterBean {
 * 
 * @Autowired private JwtUtil jwtUtil;
 * 
 * @Autowired private CustomerUserDetailService userDetailsService;
 * 
 * @Override public void doFilter(ServletRequest request, ServletResponse
 * response, FilterChain chain) throws IOException, ServletException {
 * HttpServletRequest httpRequest = (HttpServletRequest) request; String
 * authHeader = httpRequest.getHeader("Authorization"); if (authHeader != null
 * && authHeader.startsWith("Bearer ")) { String token =
 * authHeader.substring(7); String email = jwtUtil.extractEmail(token); if
 * (email != null && SecurityContextHolder.getContext().getAuthentication() ==
 * null) { if (jwtUtil.validateToken(token, email)) { UserDetails userDetails =
 * userDetailsService.loadUserByUsername(email);
 * UsernamePasswordAuthenticationToken authentication = new
 * UsernamePasswordAuthenticationToken(userDetails, null,
 * userDetails.getAuthorities());
 * SecurityContextHolder.getContext().setAuthentication(authentication); } } }
 * chain.doFilter(request, response); } }
 */