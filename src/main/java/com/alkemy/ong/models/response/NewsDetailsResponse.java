package com.alkemy.ong.models.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "News Response (Details)", description = "Response with the requested news details")
public class NewsDetailsResponse {

    @ApiModelProperty(name = "ID",
            value = "ID of the news",
            dataType = "Long",
            example = "1")
    private Long id;

    @ApiModelProperty(name = "Name",
            value = "Title of the news",
            dataType = "String",
            example = "Éxito en el concierto organizado por Somos Más")
    private String name;

    @ApiModelProperty(name = "Content",
            value = "Content of the news",
            dataType = "String",
            example = "Lorem Ipsum...")
    private String content;

    @ApiModelProperty(name = "Image",
            value = "Emblematic mage associated with the news",
            dataType = "String",
            example = "image0001.jpg")
    private String image;

    @ApiModelProperty(name = "Category",
            value = "Category at which the news belongs",
            dataType = "String",
            example = "Events")
    private CategoryResponse category;

    @ApiModelProperty(name = "Category ID",
            value = "ID of the category",
            dataType = "Long",
            example = "1")
    private Long categoryId;
}
