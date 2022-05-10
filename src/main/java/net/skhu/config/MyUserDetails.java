package net.skhu.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import net.skhu.entity.User;
import net.skhu.entity.UserRole;

@Data
public class MyUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    final boolean accountNonExpired = true;
    final boolean accountNonLocked = true;
    final boolean credentialsNonExpired = true;
    final String password;
    final String username;
    final boolean isEnabled;
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

    final String name;
    final String email;

    public MyUserDetails(User user) {
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        for (UserRole userRole : user.getUserRoles())
            authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        this.username = user.getLoginName();
        this.password = user.getPassword();
        this.isEnabled = user.isEnabled();

        this.name = user.getName();
        this.email = user.getEmail();
    }
}

