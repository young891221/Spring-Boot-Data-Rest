package com.community.rest.repository;

import com.community.rest.domain.Writer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WriterRepository extends JpaRepository<Writer, Integer> {
}
