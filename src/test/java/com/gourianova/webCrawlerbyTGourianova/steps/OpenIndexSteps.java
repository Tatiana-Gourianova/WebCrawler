package com.gourianova.webCrawlerbyTGourianova.steps;

import com.gourianova.webCrawlerbyTGourianova.junit.hooks.DriverHooks;
import com.gourianova.webCrawlerbyTGourianova.pages.HomePage;
import com.gourianova.webCrawlerbyTGourianova.pages.WebCrawlerPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenIndexSteps {
    private HomePage homePage = new HomePage();
    private WebCrawlerPage docsPage = new WebCrawlerPage();

    @When("the user opens index page")
    public void openIndexPage() { homePage.the_user_opens_index_page(); }

    @Then("page with Webcrawler title is displayed") public void verifyPageTitlePresence( ) {
        assertThat(homePage.isPageWithTitleDisplayed("Webcrawler"))
                .overridingErrorMessage("Page with Webcrawler title is not display")
                .isTrue();
    }
}
