package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import data.DataHelper;
import lombok.val;
import static com.codeborne.selenide.Selenide.$$;
import static java.awt.SystemColor.text;
import com.codeborne.selenide.ElementsCollection;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");

    public DashboardPage() {
        heading.shouldHave(text("Личный кабинет")).shouldBe(visible);
    }
}
