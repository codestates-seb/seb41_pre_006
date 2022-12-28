package pre006.stackoverflow.domain.auth.userdetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pre006.stackoverflow.domain.auth.utils.CustomAuthorityUtils;
import pre006.stackoverflow.domain.user.entity.User;
import pre006.stackoverflow.domain.user.repository.UserRepository;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class UserDetailsServiceImplements implements UserDetailsService {
    private final UserRepository repository;
    private final CustomAuthorityUtils authorityUtils;

    public UserDetailsServiceImplements(UserRepository repository, CustomAuthorityUtils authorityUtils) {
        this.repository = repository;
        this.authorityUtils = authorityUtils;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = repository.findByEmail(username);
        User findUser = optionalUser.orElseThrow(() -> new NoSuchElementException("No Such User"));

        return new UserDetailsImplements(findUser);
    }

    private final class UserDetailsImplements extends User implements UserDetails {
      UserDetailsImplements(User user) {
          setUserId(user.getUserId());
          setEmail(user.getEmail());
          setPassword(user.getPassword());
          setRoles(user.getRoles());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorityUtils.createAuthorities(this.getRoles());
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
