package org.sid.demographql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoRequest {
    private String name;
    private String url;
    private String description;
    private Date datePublication;
    private CreatorRequest creator;
}
