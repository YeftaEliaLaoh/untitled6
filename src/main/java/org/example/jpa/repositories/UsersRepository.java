package org.example.jpa.repositories;

import org.example.jpa.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>
{
    Optional<Object> findByUserNameAndPassword(String userName, String password);

    Users findByUserName(String username);
}