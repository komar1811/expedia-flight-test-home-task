package org.example.pageobject.blocks.pop_ups;

import lombok.SneakyThrows;
import org.example.pageobject.blocks.BaseBlock;
import org.example.pageobject.custom_selenium.CustomWebElement;
import org.example.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.Locale;

public class CalendarPopUpBlock extends BaseBlock {

    @FindBy(xpath = ".//button[@data-stid=\"apply-date-picker\"]")
    private CustomWebElement doneButton;


    public CalendarPopUpBlock(By locator) {
        super(locator);
    }

    public CalendarPopUpBlock(WebElement webElement) {
        super(webElement);
    }

    public CalendarPopUpBlock(WebElement webElement, String blockName) {
        super(webElement, blockName);
    }

    @SneakyThrows
    public void setDates(LocalDate startDate, LocalDate returnDate){
        String startMonth = startDate.getMonth().toString().charAt(0) + startDate.getMonth().toString().substring(1).toLowerCase(Locale.ROOT);;
        CustomWebElement selectedStartDate = new CustomWebElement(this.getSelf().getWrappedElement().findElement(
                By.xpath(".//h2[contains(text(),\""+ startMonth +"\")]//ancestor::div[1]//button[@data-day=\""+ startDate.getDayOfMonth() +"\"]")));
        String returnMonth = returnDate.getMonth().toString().charAt(0) + returnDate.getMonth().toString().substring(1).toLowerCase(Locale.ROOT);;
        CustomWebElement selectedReturnDate = new CustomWebElement(this.getSelf().getWrappedElement().findElement(
                By.xpath(".//h2[contains(text(),\""+ returnMonth +"\")]//ancestor::div[1]//button[@data-day=\""+ returnDate.getDayOfMonth() +"\"]")));
        Wait.forMillis(3000);
        selectedStartDate.click();
        Wait.forMillis(3000);
        selectedReturnDate.click();
        Wait.forMillis(3000);
        doneButton.click();
    }
}
