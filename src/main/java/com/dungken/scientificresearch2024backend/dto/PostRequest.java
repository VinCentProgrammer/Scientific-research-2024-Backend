package com.dungken.scientificresearch2024backend.dto;

import lombok.Data;

@Data
public class PostRequest {
    private int postId;
    private String title;
    private String desc;
    private String detail;
    private String thumbnail;
    private int postCatId;
    private int userId;
}
