package com.example.springcloud.app.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Book {
    private Long id;
    private String author;
    private String title;

}
