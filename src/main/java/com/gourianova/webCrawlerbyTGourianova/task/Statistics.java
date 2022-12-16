package com.gourianova.webCrawlerbyTGourianova.task;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class Statistics {
    private static final AtomicLong counter = new AtomicLong();
    private final HashMap<String, HashMap<String, Long>> totalStatistics = new HashMap<>();

    public HashMap<String, HashMap<String, Long>> getTotalStatistics() {
        return totalStatistics;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean firstValueOfHashMap = true;
        HashMap<String, Long> resultMap = new HashMap<>();

        for (Map.Entry<String, HashMap<String, Long>> entry : totalStatistics.entrySet()) {
            result.append(counter.incrementAndGet()).append(";").append(entry.getKey()).append(";");
            HashMap<String, Long> urlStats = entry.getValue();
            for (Map.Entry<String, Long> pageEntry : urlStats.entrySet()) {
                if (firstValueOfHashMap) {
                    resultMap.put(pageEntry.getKey(), pageEntry.getValue());
                } else {
                    String wordToSearch = pageEntry.getKey();
                    if (resultMap.containsKey(wordToSearch)) {
                        Long countOfWordToSearch = resultMap.get(wordToSearch);
                        countOfWordToSearch += pageEntry.getValue();
                        resultMap.replace(wordToSearch, countOfWordToSearch);
                    }
                }
                result.append(pageEntry.getValue()).append(";");
            }
            firstValueOfHashMap = false;
            result.append("\n");
        }
        result.append(" \n ;Total statistics;");
        for (Map.Entry entry : resultMap.entrySet()) {
            result.append(entry).append(";");
            log.info("!!!" + entry);
        }
        log.info(result.toString());
        return result.toString();
    }
}
