package com.community.rest.repository;

import com.community.rest.domain.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface StoreRepository extends JpaRepository<Store, Integer> {
}
