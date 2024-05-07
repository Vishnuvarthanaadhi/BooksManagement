package com.kooku.Books.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kooku.Books.Role;
import com.kooku.Books.UserEntity;
import com.kooku.Books.Dao.RoleRepository;
import com.kooku.Books.Dao.UserRepository;
import com.kooku.Books.Dto.AuthResponseDto;
import com.kooku.Books.Dto.LoginDto;
import com.kooku.Books.Dto.RegisterDto;
import com.kooku.Books.Security.JWTAuthenticationFilter;
import com.kooku.Books.Security.JWTGenerator;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthenticationManager authenticationManager;
	
	private UserRepository userRepository;
	
	private RoleRepository roleRepository;
	
	private PasswordEncoder passwordEncoder;
	
	private JWTGenerator jwtGenerator;
	
	@Autowired
	public AuthController(AuthenticationManager authenticationManager,UserRepository userRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder,JWTGenerator jwtGenerator)
	{
		this.authenticationManager = authenticationManager;
		
		this.userRepository = userRepository;
		
		this.roleRepository = roleRepository;
		
		this.passwordEncoder = passwordEncoder;
		
		this.jwtGenerator = jwtGenerator;
	}
	
	@PostMapping("login")
	public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), 
				loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtGenerator.generateToken(authentication);
		return new ResponseEntity<>(new AuthResponseDto(token),HttpStatus.OK);
	}
	
	@PostMapping("register")
	public ResponseEntity<String> register (@RequestBody RegisterDto registerDto){
		
		if(userRepository.existsByUsername(registerDto.getUsername())) {
			return new ResponseEntity<>("username is taken", HttpStatus.BAD_REQUEST);
		}
		
		UserEntity user = new UserEntity();
		user.setUsername(registerDto.getUsername());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		
		Role roles = roleRepository.findByName("USER").get();
		user.setRoles(Collections.singletonList(roles));
		
		userRepository.save(user);
		
		return new ResponseEntity<>("user Registered Success!",HttpStatus.OK);
		
	}

}
