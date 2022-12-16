package com.gourianova.webCrawlerbyTGourianova.repo;


import com.gourianova.webCrawlerbyTGourianova.model.TextIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TextInRepo extends JpaRepository<TextIn, Integer> {

    void deleteTextInById(Long id);

    Optional<TextIn> findTextInById(Long id);
}

