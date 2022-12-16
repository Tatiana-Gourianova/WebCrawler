package com.gourianova.webCrawlerbyTGourianova.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller


public class ShowTextInFormController {

    @RequestMapping(value = "/views/jsp/showTextInForm", method = RequestMethod.POST)
    public String index() {
        return "/views/jsp/file_load.jsp";
    }
}