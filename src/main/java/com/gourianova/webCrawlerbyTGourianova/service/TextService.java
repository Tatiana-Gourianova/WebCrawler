package com.gourianova.webCrawlerbyTGourianova.service;

import com.gourianova.webCrawlerbyTGourianova.exception.TextNotFoundException;
import com.gourianova.webCrawlerbyTGourianova.model.TextIn;
import com.gourianova.webCrawlerbyTGourianova.repo.TextInRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextService {
    private final TextInRepo textInRepo;
    private final static String TEXT_NOT_FOUND_MSG = "text with id %s not found";

    @Autowired
    public TextService(TextInRepo textInRepo) {
        this.textInRepo = textInRepo;
    }

    public List<TextIn> findAllTextsIn() {
        return textInRepo.findAll();
    }

    public TextIn updateTextIn(TextIn textIn) {
        return textInRepo.save(textIn);
    }

    public TextIn findTextInById(Long id) {
        return textInRepo.findTextInById(id).orElseThrow(() -> new TextNotFoundException(TEXT_NOT_FOUND_MSG));
    }

    public void deleteText(Long id) {
        this.findTextInById(id);
    }
}

