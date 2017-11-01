package com.community.rest.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue
    private Integer idx;

    @Column
    private String title;

    @Column
    private LocalDateTime publishedAt;

    @ManyToOne(optional = false)
    private Writer writer;

    @Builder
    public Book(String title, LocalDateTime publishedAt, Writer writer) {
        this.title = title;
        this.publishedAt = publishedAt;
        this.writer = writer;
    }
}
