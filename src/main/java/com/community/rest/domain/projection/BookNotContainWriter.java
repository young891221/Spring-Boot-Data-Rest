package com.community.rest.domain.projection;

import com.community.rest.domain.Book;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "notContainWriter", types = { Book.class })
public interface BookNotContainWriter {

    String getTitle();

}
