package testCase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

import java.util.List;

public class ElementsPage extends Parent{

    public ElementsPage() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(linkText = "Demo")
    private WebElement demo;
    @FindBy(xpath = "(//div[@class='elementor-button-wrapper']/a)[2]")
    private WebElement demo2;
    @FindBy(xpath = "//*[text()='Enter the OpenMRS 2 Demo']")
    private WebElement enterMRS2;
    @FindBy(id = "username")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "loginButton")
    private WebElement loginBtn;
    @FindBy(css = "ul#sessionLocation>li")
    private List<WebElement> locationSession;
    @FindBy(css = "li[class='nav-item logout'] a")
    private WebElement logout;
    @FindBy(css = "#content>div:nth-child(2)")
    private WebElement loginSuccess;
    @FindBy(css = ".w-auto")
    private WebElement logoutSuccess;
    @FindBy(id = "error-message")
    private WebElement errorMsg;
    @FindBy(xpath = "//div[@id='apps']//a[4]")
    private WebElement register;
    @FindBy(xpath = "//input[@name='givenName']")
    private WebElement name;
    @FindBy(xpath = "//input[@name='familyName']")
    private WebElement surname;
    @FindBy(xpath = "//icon[@class='fas fa-chevron-right']")
    private WebElement nextButton1;
    @FindBy(css = "select[id='gender-field']>:nth-child(2)")
    private WebElement gender;
    @FindBy(xpath = "//icon[@class='fas fa-chevron-right']")
    private WebElement nextButton2;
    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    private WebElement day;
    @FindBy(xpath = "//option[text()='February']")
    private WebElement month;
    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    private WebElement year;
    @FindBy(xpath = "//button[@id='next-button']/icon")
    private WebElement nextButton3;
    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address;
    @FindBy(xpath = "//input[@id='cityVillage']")
    private WebElement city;
    @FindBy(xpath = "//input[@id='country']")
    private WebElement country;
    @FindBy(xpath = "//button[@id='next-button']/icon")
    private WebElement nextButton4;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phone;
    @FindBy(xpath = "//button[@id='next-button']/icon")
    private WebElement nextButton5;
    @FindBy(xpath = "//button[@id='next-button']/icon")
    private WebElement nextButton6;
    @FindBy(id = "submit")
    private WebElement confirm;
    @FindBy(xpath = "(//p[contains(text(),'Created Patient Record:')])[2]")
    private WebElement accessMessage;
    @FindBy(css = "[class='icon-user small']")
    private WebElement userIcon;
    @FindBy(css = "[href='/openmrs/adminui/myaccount/myAccount.page']")
    private WebElement myAccount;
    @FindBy(xpath = "(//div[@class='task'])[1]")
    private WebElement changePassword;
    @FindBy(xpath = "(//div[@class='task'])[2]")
    private WebElement myLanguages;
    @FindBy(xpath = "//div[@id='apps']//a[1]")
    private WebElement searchPatient;
    @FindBy(xpath = "//input[@id='patient-search']")
    private WebElement searchPatientBox;
    @FindBy(xpath = "(//tr[@class='odd'])[1]")
    private WebElement patientButton;
    @FindBy(css = ".PersonName-givenName")
    private WebElement nameSuccess;
    @FindBy(css = ".PersonName-familyName")
    private WebElement surnameSuccess;
    @FindBy(xpath = "//i[@class='icon-home small']")
    private WebElement homeButton;
    @FindBy(xpath = "//td[text()='No matching records found']")
    private WebElement searchPatientNegativeSuccess;
    @FindBy(id = "patient-search-results-table_info")
    private WebElement showingEntries;
    @FindBy(css = "div[id='patient-search-results-table_paginate'] >span>a[tabindex]")
    private List<WebElement> pageNumber;
    @FindBy(css = "tbody[role='alert']>tr")
    private List<WebElement> pageRows;
    @FindBy(xpath = "(//a[@class='float-left'])[8]")
    private WebElement deletePatient;
    @FindBy(xpath = "//input[@id='delete-reason']")
    private WebElement deleteReason;
    @FindBy(xpath = "(//div[@id='simplemodal-container']//button)[1]")
    private WebElement confirmButton;
    @FindBy(xpath = "//div[@id='apps']//a[7]")
    private WebElement dataManagement;
    @FindBy(xpath = "//div[@id='tasks']//a")
    private WebElement mergePatient;
    @FindBy(xpath = "//div[@class='float-sm-right']/span")
    private WebElement patientId;
    @FindBy(id = "patient1-text")
    private WebElement patient1;
    @FindBy(id = "patient2-text")
    private WebElement patient2;
    @FindBy(id = "patient-search")
    private WebElement patientSearchClick;
    @FindBy(id = "confirm-button")
    private WebElement continueButton;

    @FindBy(id = "first-patient")
    private WebElement clickPatient;

    @FindBy(xpath = "(//div[@class='float-sm-right']/span)[1]")
    private WebElement MergePatientId1;

    @FindBy(xpath = "(//div[@class='float-sm-right']/span)[2]")
    private WebElement MergePatientId2;

    @FindBy(xpath = "//h1[contains(text(),'Merging cannot be undone!')]")
    private WebElement mergindSuccess;

    @FindBy(xpath = "//div[@id='apps']//a[5]")
    private WebElement appointmentScheduling;

    @FindBy(xpath = "(//div[@id='apps']//a)[3]")
    private WebElement manageAppointments;

    @FindBy(css = "[class=\"text\"] p")
    private WebElement alertText;

    public WebElement getDemo() {
        return demo;
    }

    public WebElement getDemo2() {
        return demo2;
    }

    public WebElement getEnterMRS2() {
        return enterMRS2;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public List<WebElement> getLocationSession() {
        return locationSession;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getLoginSuccess() {
        return loginSuccess;
    }

    public WebElement getLogoutSuccess() {
        return logoutSuccess;
    }

    public WebElement getErrorMsg() {
        return errorMsg;
    }

    public WebElement getRegister() {
        return register;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getSurname() {
        return surname;
    }

    public WebElement getNextButton1() {
        return nextButton1;
    }

    public WebElement getGender() {
        return gender;
    }

    public WebElement getNextButton2() {
        return nextButton2;
    }

    public WebElement getDay() {
        return day;
    }

    public WebElement getMonth() {
        return month;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getNextButton3() {
        return nextButton3;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getNextButton4() {
        return nextButton4;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getNextButton5() {
        return nextButton5;
    }

    public WebElement getNextButton6() {
        return nextButton6;
    }

    public WebElement getConfirm() {
        return confirm;
    }

    public WebElement getAccessMessage() {
        return accessMessage;
    }

    public WebElement getUserIcon() {
        return userIcon;
    }

    public WebElement getMyAccount() {
        return myAccount;
    }

    public WebElement getChangePassword() {
        return changePassword;
    }

    public WebElement getMyLanguages() {
        return myLanguages;
    }

    public WebElement getSearchPatient() {
        return searchPatient;
    }

    public WebElement getSearchPatientBox() {
        return searchPatientBox;
    }

    public WebElement getPatientButton() {
        return patientButton;
    }

    public WebElement getNameSuccess() {
        return nameSuccess;
    }

    public WebElement getSurnameSuccess() {
        return surnameSuccess;
    }

    public WebElement getHomeButton() {
        return homeButton;

    }

    public WebElement getSearchPatientNegativeSuccess() {
        return searchPatientNegativeSuccess;
    }

    public WebElement getShowingEntries() {
        return showingEntries;
    }

    public List<WebElement> getPageNumber() {
        return pageNumber;
    }

    public List<WebElement> getPageRows() {
        return pageRows;
    }

    public WebElement getDeletePatient() {
        return deletePatient;
    }

    public WebElement getDeleteReason() {
        return deleteReason;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public WebElement getDataManagement() {
        return dataManagement;
    }

    public WebElement getMergePatient() {
        return mergePatient;
    }

    public WebElement getPatientId() {
        return patientId;
    }

    public WebElement getPatient1() {
        return patient1;
    }

    public WebElement getPatient2() {
        return patient2;
    }

    public WebElement getPatientSearchClick() {
        return patientSearchClick;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getClickPatient() {
        return clickPatient;
    }

    public WebElement getMergePatientId1() {
        return MergePatientId1;
    }

    public WebElement getMergePatientId2() {
        return MergePatientId2;
    }

    public WebElement getMergindSuccess() {
        return mergindSuccess;
    }

    public WebElement getAppointmentScheduling() {
        return appointmentScheduling;
    }

    public WebElement getManageAppointments() {
        return manageAppointments;
    }

    public WebElement getAlertText() {
        return alertText;
    }
}



