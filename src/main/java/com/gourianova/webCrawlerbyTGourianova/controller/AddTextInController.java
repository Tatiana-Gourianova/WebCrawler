package com.gourianova.webCrawlerbyTGourianova.controller;

import com.gourianova.webCrawlerbyTGourianova.dto.SimpleDto;
import com.gourianova.webCrawlerbyTGourianova.exception.TextNotFoundException;
import com.gourianova.webCrawlerbyTGourianova.model.TextIn;
import com.gourianova.webCrawlerbyTGourianova.repo.TextInRepo;
import com.gourianova.webCrawlerbyTGourianova.task.Crawler;
import com.gourianova.webCrawlerbyTGourianova.task.Statistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import static com.gourianova.webCrawlerbyTGourianova.util.UserConstants.*;

@Slf4j
@Controller
public class AddTextInController {
    private static final AtomicLong counter = new AtomicLong();
    private TextInRepo textInRepo;

    public TextInRepo getTextRepo() {
        return textInRepo;
    }

    public void setTextInRepo(TextInRepo textInRepo) {
        this.textInRepo = textInRepo;
    }

    @RequestMapping(value = "/text-in", method = RequestMethod.GET)
    public ModelAndView text() {
        return new ModelAndView("/views/jsp/file_load.jsp", "showTextInForm", new TextIn());
    }

    @RequestMapping(value = "/views/jsp/addTextIn", method = RequestMethod.POST)
    public String addTextIn(@ModelAttribute("SpringWeb") TextIn textIn,
                            ModelMap model) throws TextNotFoundException {
        new TextIn();
        model.addAttribute("language", textIn.getLanguage());
        model.addAttribute("text_title", textIn.getText_title());
        model.addAttribute("text_path", textIn.getText_url());

        textIn.setCreate_time(LocalDate.now());
        textIn.setId(counter.incrementAndGet());

        log.info(String.valueOf(textIn.getLanguage()));

        Crawler newCrawler = new Crawler(MAX_DEPTH, MAX_DOCS_TO_SEARCH, textIn.getText_title());
        Statistics statistics = newCrawler.getPageLinks(textIn.getText_url(), BEGIN_FROM_DEPTH);

        textIn.setStatistics(statistics.toString().getBytes());

        SimpleDto simpleDto = new SimpleDto(statistics.toString(), newCrawler.toString());
        try (FileOutputStream fos = new FileOutputStream(REPORT_NAME)) {
            byte[] buffer = simpleDto.getStatistics().getBytes();
            fos.write(buffer, 0, buffer.length);
            log.info("The file has been written");
        } catch (IOException ex) {
            log.info(ex.getMessage());
        }
        try (FileOutputStream fos = new FileOutputStream(RATING_NAME)) {
            byte[] buffer = simpleDto.getTenDocsReport().getBytes();
            fos.write(buffer, 0, buffer.length);
            log.info("The file has been written");
        } catch (IOException ex) {
            log.info(ex.getMessage());
        }
        model.addAttribute("statistics", simpleDto.getStatistics());
        model.addAttribute("statistics2", simpleDto.getTenDocsReport());
        getTextRepo().save(textIn);
        return "/views/jsp/result.jsp";
    }

    @Bean
    CommandLineRunner commandLineRunner(TextInRepo textInRepo) {
        return args -> setTextInRepo(textInRepo);
    }
}