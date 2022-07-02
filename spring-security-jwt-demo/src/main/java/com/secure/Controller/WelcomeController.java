package com.secure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.entity.authRequest;
import com.secure.util.JwtUtil;

@RestController
public class WelcomeController {
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private AuthenticationManager autheniticationmanager;

	@GetMapping("/")
	public String welcome() {
		return "welcome to security";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody authRequest Authrequest) throws Exception {
		try {
			System.out.println(Authrequest.getUserName()+"++"+Authrequest.getPassword());
			autheniticationmanager.authenticate(
					new UsernamePasswordAuthenticationToken(Authrequest.getUserName(), Authrequest.getPassword()));

		} catch (Exception e) {
			// TODO: handle exception

			throw new Exception("invalid username and passowrd");
		}
		return jwtutil.generateToken(Authrequest.getUserName());
	}
}
