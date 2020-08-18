package com.beecode.util;

import java.util.Collections;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.beecode.entity.User;
import com.beecode.repository.IUserRepository;


@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final UsernamePasswordAuthenticationToken upAuth = (UsernamePasswordAuthenticationToken) authentication;
        System.out.println(upAuth);
        final String name = (String) authentication.getPrincipal();

        final String password = (String) upAuth.getCredentials();
        System.out.println(password);

        System.out.println(userRepository.findByEmailValue(name).map(User::getPassword));
        
        final String storedPassword = userRepository.findByEmailValue(name).map(User::getPassword)
            .orElseThrow(() -> new BadCredentialsException("No hay registro del usuario ingresado.El usuario puede haber sido eliminado."));

        if (Objects.equals(password, "") || !BCryptPasswordDecode.decode(password, storedPassword)) {
            throw new BadCredentialsException("La contraseña no es valida.");
        }

        final Object principal = authentication.getPrincipal();
        final UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
            principal, authentication.getCredentials(),
            Collections.emptyList());
        result.setDetails(authentication.getDetails());

        return result;
    }

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}
