package com.po.projectDetailsPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectDetailsPo {
    public WebDriver driver;

    public ProjectDetailsPo(WebDriver driver) {
        this.driver = driver;
    }

    //Folder or screens not found locator.
    public By noFolderScreens = By.xpath("//span[text()='Folders or Screens Not Found!']");

    //Drag and drop box locator.
    public By screenAdd = By.xpath("//div[@class='filepond--drop-label']/label");

    //Verify screen uploaded dialog
    public By screenDialog = By.xpath("//div[text()='Screen is created successfully']");

    //Project name locator.
    public By projectName = By.xpath("//h5[@class='project-name']/a");

    //Click on new folder or new screens locator.
    public By newFolderNewScreen = By.xpath("//a[@class='custom-btn']");

    //New folder popup available or not locator.
    public By newFolderPopup = By.xpath("//div[@class='new-screen-modal']");

    //New folder popup shadow locator.
    public By newFolderShedow = By.xpath("//div[@class='popup-overlay']");

    //New folder popup click on cancel/create button locator.
    public By newFolderPopupCancelCreate = By.xpath("//input[@class='contron-btn']");

    //Folder name field locator.
    public By folderName = By.xpath("//input[@name='name']");

    //Blank or enter blank space locator.
    public By noOrBlankFolderName = By.xpath("//span[text()='Please enter name.']");

    //Less characters validation message locator.
    public By lessCharacterFolderName = By.xpath("//span[text()='Name must contain atleast 3 charaters.']");

    //More characters validation message locator.
    public By moreCharactersFolderName = By.xpath("//span[text()='Name must contain atmost 30 charaters.']");

    //Folder added success message locator.
    public By successMessageFolderName = By.xpath("//div[text()='Folder is created successfully']");

    //After add folder verify folder name locator.
    public By verifyFolderName = By.xpath("//div[@class='box-title']");

    //New folder popup cancel buttton.
    public By newFolderCancelButton = By.xpath("//input[@value='Cancel']");


}
