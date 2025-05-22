package com.bn.jwt.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UsersModel,Long> {
  UserDetails findByLogin(String role);

}
