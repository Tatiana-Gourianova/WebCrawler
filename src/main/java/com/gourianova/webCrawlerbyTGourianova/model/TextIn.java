package com.gourianova.webCrawlerbyTGourianova.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Entity
public class TextIn implements Serializable {
    @Id
    private long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private String text_title;
    private String text_url;
    private Language language;
    @Lob
    @Column(length = Integer.MAX_VALUE)
    private byte[] statistics;
    private LocalDate create_time;
    private long parent_id;

    public TextIn(String text_title, String text_url) {
        {
            this.text_title = text_title;
            this.text_url = text_url;
        }
    }
}