package com.secure.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.secure.service.customUserDetailsService;
import com.secure.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private customUserDetailsService userDetailsSerivice;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServeletrequest, HttpServletResponse httpServeletresponse,
			FilterChain filterChain) throws ServletException, IOException {

		String authorizationHeader = httpServeletrequest.getHeader("Authorization");

		String token = null;
		String userName = null;
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			token = authorizationHeader.substring(7);
			userName = jwtutil.extractUserName(token);
		}

		//if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
		if (userName != null) {
			UserDetails userdetails = userDetailsSerivice.loadUserByUsername(userName);
			if (jwtutil.validateToken(token, userdetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userdetails,null, userdetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServeletrequest));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}

		}
		filterChain.doFilter(httpServeletrequest, httpServeletresponse);
	}

}
