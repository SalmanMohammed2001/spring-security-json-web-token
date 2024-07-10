package spring_security.security_json_web_token.security.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring_security.security_json_web_token.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {


    private  Long id;

    private  String username;
    private  String password;

    private  Collection<? extends  GrantedAuthority> authorities;



    public static  UserDetailsImpl build(User use){
        List<GrantedAuthority> authorities=use.getRoles().stream().map(roles -> new SimpleGrantedAuthority(roles.getERole().name())).collect(Collectors.toList());
    return  new UserDetailsImpl(use.getId(),use.getUsername(),use.getPassword(),authorities);
   }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return  true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        UserDetailsImpl user=(UserDetailsImpl) obj;
        return Objects.equals(id,user.id);
    }
}
