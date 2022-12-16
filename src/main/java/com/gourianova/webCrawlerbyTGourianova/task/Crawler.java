package com.gourianova.webCrawlerbyTGourianova.task;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.gourianova.webCrawlerbyTGourianova.util.UserConstants.*;
import static java.util.Map.Entry.comparingByValue;

@Slf4j
public class Crawler {
    private static int countLinksToSearch = 0;
    private int maxDepth = MAX_DEPTH;
    private int maxLinksToSearch = MAX_DOCS_TO_SEARCH;
    public HashMap<String, Long> totalStatisticsReport = new HashMap<>();
    public HashMap<String, Long> firstTenDocsStatisticsReport = new HashMap<>();
    private final Statistics globalStatistics = new Statistics();
    private final HashSet<String> urlLinks;
    private final List<String> wordsToSearch;

    public Crawler(int maxDepth, int maxLinksToSearch, String wordsToSearch) {
        this.maxDepth = maxDepth;
        this.maxLinksToSearch = maxLinksToSearch;
        this.wordsToSearch = Arrays.asList(wordsToSearch.split(" "));
        //  this.wordsToSearch = Arrays.asList(wordsToSearch.substring(0, wordsToSearch.lastIndexOf('.')).split(" "));
        urlLinks = new HashSet<>();
    }

    int countOfDocs = 0;

    public Statistics getPageLinks(String URL, int depth) {

        if ((!urlLinks.contains(URL) && (depth <= maxDepth) && (countLinksToSearch < maxLinksToSearch))) {
            log.info(">> Depth: " + depth + " [" + URL + "]" + "link №" + countLinksToSearch);
            try {
                Connection con = Jsoup.connect(URL);
                Document doc = con.get();
                if ((con.response().statusCode() == HTTP_200_OK)
                        && (!doc.title().contains("File:"))
                        && (!doc.title().contains("javascript"))) {
                    HashMap<String, Long> linkStats = countWordAmount(doc, wordsToSearch);
                    globalStatistics.getTotalStatistics().put(URL, linkStats);
                    countLinksToSearch++;
                    urlLinks.add(URL);
                    List<Element> availableLinksOnPage = doc.select("a[href]").stream()
                            .filter(element -> !element.attr("abs:href").contains("#")).collect(Collectors.<Element>toList());

                    if (((0 <= countLinksToSearch) && (countLinksToSearch <= MAX_DOCS_TO_REPORT) || (countOfDocs < MAX_DOCS_TO_REPORT))) {
                        long totalWordsInDoc = 0;
                        for (Map.Entry entry : linkStats.entrySet()) {
                            totalWordsInDoc += (long) entry.getValue();
                        }
                        firstTenDocsStatisticsReport.put(URL, totalWordsInDoc);
                        countOfDocs++;
                    }

                    depth++;

                    for (Element page : availableLinksOnPage) {
                        try {


                            getPageLinks(page.attr("abs:href"), depth);
                        } catch (Exception e) {
                            log.info(e.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                log.info(e.getMessage());
            }
        }
        return globalStatistics;
    }

    private HashMap<String, Long> countWordAmount(Document doc, List<String> wordsToSearch) {
        HashMap<String, Long> statistics = new HashMap<>();
        for (String word : wordsToSearch) {
            long count = Pattern.compile(word)
                    .matcher(doc.body().text())
                    .results()
                    .map(MatchResult::group)
                    .count();

            statistics.put(word, count);
            this.totalStatisticsReport.put(word, this.totalStatisticsReport.getOrDefault(word, 0L) + count);
            log.info("******" + totalStatisticsReport + "********!");
            log.info(word + " is founded " + count + " times");
        }
        return statistics;
    }

    public static HashMap<String, Long>
    sortByValue(HashMap<String, Long> mapToSort) {
        HashMap<String, Long> sortedMap = mapToSort.entrySet().stream().distinct().sorted(comparingByValue(new Comparator<Long>() {
                    @Override
                    public int compare(Long o1, Long o2) {
                        return o2.compareTo(o1);
                    }
                }))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        return sortedMap;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("First Ten Docs Statistics Report; \n");
        int i = 0;
        for (Map.Entry entry : sortByValue(firstTenDocsStatisticsReport).entrySet()) {
            result.append(++i).append(";").append(entry.getKey()).append(";").append(entry.getValue()).append("; \n");
        }
        return result.toString();
    }
}
