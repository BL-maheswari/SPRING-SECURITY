package com.bl.school_management_system.repository;

public class UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}