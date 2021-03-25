package nl.agilicy.passman.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nl.agilicy.passman.model.AppUserDetails;
import nl.agilicy.passman.model.User;
import nl.agilicy.passman.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByEmail(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(AppUserDetails::new).get();
    }
    
}
