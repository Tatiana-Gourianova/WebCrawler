package com.gourianova.webCrawlerbyTGourianova.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
public class SimpleDto implements Serializable {
    private String statistics;
    private String tenDocsReport;
//    @Override

 //   public String toString() {}
}

