package com.crudjpaHeranca.model.entity;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Entity
    public class Usuario implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String login;
        private String password;

    @ManyToMany
    @JoinTable(
            name = "usuario_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
        private List<Role> perfis;

        public Long getId() {
            return id;
        }

        public String getLogin() {
            return login;
        }

        public List<Role> getPerfis() {
            return perfis;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setPerfis(List<Role> perfis) {
            this.perfis = perfis;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return perfis;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return login;
        }

        @Override
        public boolean isAccountNonExpired() {
            return false;
        }

        @Override
        public boolean isAccountNonLocked() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }

   }

