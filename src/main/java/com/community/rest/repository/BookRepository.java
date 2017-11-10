package com.community.rest.repository;

import com.community.rest.domain.Book;
import com.community.rest.domain.projection.BookOnlyContainTitle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource(excerptProjection = BookOnlyContainTitle.class)
public interface BookRepository extends JpaRepository<Book, Integer> {

    @RestResource(path = "title")
    @PreAuthorize("hasRole('ROLE_USER')")
    List<Book> findByTitle(@Param("title") String title);

    @Override
    @PreAuthorize("hasRole('ROLE_USER')")
    <S extends Book> S save(S entity);
}
