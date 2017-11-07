package pl.tomekdudek.GymManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.tomekdudek.GymManagement.model.CustomUserDetails;
import pl.tomekdudek.GymManagement.model.User;
import pl.tomekdudek.GymManagement.model.repository.UserRepository;

import java.util.Optional;

/**
 * Created by Tomek on 2017-11-06.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByName(name);
        userOptional
                .orElseThrow(() -> new UsernameNotFoundException("Name not found"));
        return userOptional.map(CustomUserDetails::new).get();
    }
}
