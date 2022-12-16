package com.gourianova.webCrawlerbyTGourianova;

import com.gourianova.webCrawlerbyTGourianova.exception.TextNotFoundException;
import com.gourianova.webCrawlerbyTGourianova.model.Language;
import com.gourianova.webCrawlerbyTGourianova.model.TextIn;
import com.gourianova.webCrawlerbyTGourianova.repo.TextInRepo;
import com.gourianova.webCrawlerbyTGourianova.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TextServiceTest {
    @Mock
    private TextInRepo textInRepo;

    @InjectMocks
    private TextService textService;

    private TextIn textIn = null;

    @BeforeEach
    public void setup() {
        textIn = TextIn.builder().id(1).create_time(LocalDate.now()).language(Language.English).parent_id(11).build();
    }

    @Test
    public void findTextInByIdSuccess() {
        long id = textIn.getId();
        when(textInRepo.findTextInById(id)).thenReturn(Optional.of(textIn));
        assertEquals(textService.findTextInById(id), textIn);
    }

    @Test
    public void findTextInByIdThrowException() {
        long id = textIn.getId() + 1;
        when(textInRepo.findTextInById(id)).thenReturn(Optional.ofNullable(null));
        assertThrows(TextNotFoundException.class, () -> textService.findTextInById(id));
    }
}
