package com.alkemy.ong.models.response;

import com.alkemy.ong.models.entity.CategoryEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewsDetailsResponse {

    private Long id;
    private String name;
    private String content;
    private String image;
    private CategoryResponse category;
    private Long categoryId;
}
