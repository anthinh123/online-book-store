package com.thinh.onlinebookstore.service;

import com.thinh.onlinebookstore.entity.Customer;
import com.thinh.onlinebookstore.entity.Role;
import com.thinh.onlinebookstore.entity.Roles;
import com.thinh.onlinebookstore.repository.CustomerRepository;
import com.thinh.onlinebookstore.repository.RoleRepository;
import com.thinh.onlinebookstore.requestdto.LoginRequest;
import com.thinh.onlinebookstore.requestdto.SignupRequest;
import com.thinh.onlinebookstore.response.JwtResponse;
import com.thinh.onlinebookstore.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public JwtResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        return new JwtResponse(jwt, userDetails.getName(), userDetails.getEmail(), roles);
    }

    @PostMapping("/signup")
    public void registerUser(@RequestBody SignupRequest signUpRequest) {
        if (customerRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is already in use!");
        }

        // Create new user's account
        Role customerRole = roleRepository.findByName(Roles.CUSTOMER.value);
        List<Role> roles = List.of(customerRole);
        Customer customer = new Customer();
        customer.setName(signUpRequest.getName());
        customer.setEmail(signUpRequest.getEmail());
        customer.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        customer.setPhoneNumber(signUpRequest.getPhoneNumber());
        customer.setRoles(roles);

        customerRepository.save(customer);
    }

}
