package std701.cmms.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import std701.cmms.api.repositories.UserRepository;

@Service
public class CustomUserDetailsService {
//public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        final User appUser = userRepository.findByUsername(username);
//        if (appUser == null) {
//            throw new UsernameNotFoundException(username);
//        }
//
//        return null;
//    }
}
