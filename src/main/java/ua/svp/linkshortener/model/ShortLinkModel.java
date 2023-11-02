package ua.svp.linkshortener.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkModel {

    private String userLink;
    private String shortLink;
    private Date createdDate;

}
