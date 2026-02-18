package com.api.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode


public class Users {
    private String id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;
}