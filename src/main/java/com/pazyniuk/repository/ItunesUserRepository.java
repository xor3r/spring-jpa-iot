package com.pazyniuk.repository;

import com.pazyniuk.domain.ItunesUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItunesUserRepository extends JpaRepository<ItunesUser, Long> {
}
