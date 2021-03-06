package com.backend.Controllers;

import com.backend.Models.AuthToken;
import com.backend.Models.LoginUser;
import com.backend.Models.PersonEntity;
import com.backend.Security.JwtTokenUtil;
import com.backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@Controller
public class PersonLoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @GetMapping("/api/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final PersonEntity user = userService.findByNickname(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new AuthToken(token,loginUser.getUsername()));
    }

    @GetMapping("/api/isLogged")
    public ResponseEntity isLogged(@RequestHeader("Authorization") String token)
    {
        token=token.substring(7);
        String username=jwtTokenUtil.getUsernameFromToken(token);
        Boolean result= jwtTokenUtil.validateToken(token,userService.loadUserByUsername(username));
        return ResponseEntity.ok(result);
    }
}
