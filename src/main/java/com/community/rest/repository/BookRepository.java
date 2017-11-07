package com.community.rest.repository;

import com.community.rest.domain.Book;
import com.community.rest.domain.projection.BookNotContainWriter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = BookNotContainWriter.class)
public interface BookRepository extends JpaRepository<Book, Integer> {
    @RestResource
    List<Book> findByTitle(@Param("title") String title);
}
