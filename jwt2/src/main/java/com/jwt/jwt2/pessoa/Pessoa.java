package com.jwt.jwt2.pessoa;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "user")
@Table(name = "user")
public class Pessoa implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String login;
    private PessoaRole role;

        public Pessoa() {
        }

        public Long getId () {
            return id;
        }

        public void setId (Long id){
            this.id = id;
        }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            if(this.role == PessoaRole.ADMIN) return List.of(new SimpleGrantedAuthority("ADMIN")
            , new SimpleGrantedAuthority("USER"));
        return null;
    }

    public String getPassword () {
            return password;
        }

    @Override
    public String getUsername() {
        return login;
    }

    public void setPassword (String password){
            this.password = password;
        }

        public String getLogin () {
            return login;
        }

        public void setLogin (String login){
            this.login = login;
        }

        public PessoaRole getRole () {
            return role;
        }

        public void setRole (PessoaRole role){
            this.role = role;
        }
    }