package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactsPage extends TestBase {

    @FindBy(xpath= "//div[contains(text(),\"Contacts\")]")
    WebElement contactsLabel;
    @FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]" +
            "/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement firstName;
    @FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]" +
            "/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement lastName;
    @FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]" +
            "/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
    WebElement companyName;
    @FindBy(xpath= "//i[@class='save icon']")
    WebElement saveButton;

    public ContactsPage(){
      //initialization
        PageFactory.initElements(driver,this);
    }
    //Action
    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }

    public void verifyContactsByName(){
        driver.findElement(By.xpath("//a[contains(text(),'Sam Mathew')]")).click();


       //driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
               // + "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    }

    public void addContacts(String fname, String lname, String comp) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(firstName).build().perform();
        //Thread.sleep(2000);
       firstName.sendKeys(fname);
        //Thread.sleep(1000);
       lastName.sendKeys(lname);
        //Thread.sleep(1000);
       companyName.sendKeys(comp);
        //Thread.sleep(1000);
       saveButton.click();

    }


}
