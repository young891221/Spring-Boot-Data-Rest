package com.community.rest.domain.projection;

import com.community.rest.domain.Book;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "getOnlyTitle", types = { Book.class })
public interface BookOnlyContainTitle {

    String getTitle();
}
