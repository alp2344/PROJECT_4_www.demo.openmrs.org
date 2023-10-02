package testCase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.BaseDriver;

import static testCase.Parent.waiting;

public class OpenMrs extends BaseDriver {

    @Test(priority = 1, groups = {"Smoke Test"}, dataProviderClass = OpenMrs.class, dataProvider = "userData")
    public void US_OMRS01(String username, String password) { //Sisteme Giriş (Login) Hatalarını Kontrol Etmek

        ElementsPage ep = new ElementsPage();
        driver.get("https://openmrs.org/");
        waiting(1);
        ep.clickFunction(ep.getDemo());
        ep.clickFunction(ep.getDemo2());
        waiting(1);
        ep.clickFunction(ep.getEnterMRS2());
        ep.sendKeysFunction(ep.getUserName(), username);
        ep.sendKeysFunction(ep.getPassword(), password);
        ep.randomClick(ep.getLocationSession());
        ep.clickFunction(ep.getLoginBtn());

        if (username.equals("Admin") && password.equals("Admin123")) {
            ep.verifyContainsText(ep.getLoginSuccess(), "Logged in as");
            ep.clickFunction(ep.getLogout());
        } else {
            ep.verifyContainsText(ep.getErrorMsg(), "Invalid");
        }
    }

    @DataProvider
    public Object[][] userData() {
        Object[][] data =
                {
                        {"admin", "Admin12"},
                        {"Admin", ""},
                        {"", ""},
                        {"", "Admin123"},
                        {"admin", "admin123"},
                        {"xyz", "1234"}
                };
        return data;
    }


    @Test(priority = 2, groups = {"Smoke Test"})
    public void US_OMRS02() { //Sisteme Giriş (Login) Yapmak

        ElementsPage ep = new ElementsPage();

        driver.get("https://openmrs.org/");
        waiting(1);
        ep.clickFunction(ep.getDemo());
        ep.clickFunction(ep.getDemo2());
        waiting(1);
        ep.clickFunction(ep.getEnterMRS2());
        waiting(1);
        ep.sendKeysFunction(ep.getUserName(), "Admin");
        waiting(1);
        ep.sendKeysFunction(ep.getPassword(), "Admin123");
        ep.randomClick(ep.getLocationSession());
        ep.clickFunction(ep.getLoginBtn());
        waiting(1);
        ep.verifyContainsText(ep.getLoginSuccess(), "Logged in as");
    }

    @Test(priority = 10, groups = {"Smoke Test"})
    public void US_OMRS03() { //Sistemden Çıkış (Logout) Yapmak

        ElementsPage ep = new ElementsPage();

        if (driver.getCurrentUrl().equals("data:,")) {
            US_OMRS02();
        }
        ep.clickFunction(ep.getLogout());
        ep.verifyContainsText(ep.getLogoutSuccess(), "LOGIN");
    }

    @Test(priority = 4, groups = {"Smoke Test"}, dataProviderClass = OpenMrs.class, dataProvider = "patientData")
    public void US_OMRS04(String name, String firstName, String day, String year, String adres, String city, String country, String phoneNumber) { //Hasta Kayıt

        ElementsPage ep = new ElementsPage();
        if (driver.getCurrentUrl().equals("data:,")) {
            US_OMRS02();
        }
        ep.clickFunction(ep.getRegister());
        ep.sendKeysFunction(ep.getName(), name);
        ep.sendKeysFunction(ep.getSurname(), firstName);
        ep.clickFunction(ep.getNextButton1());
        ep.clickFunction(ep.getGender());
        ep.clickFunction(ep.getNextButton2());
        ep.sendKeysFunction(ep.getDay(), day);
        ep.clickFunction(ep.getMonth());
        ep.sendKeysFunction(ep.getYear(), year);
        ep.clickFunction(ep.getNextButton3());
        ep.sendKeysFunction(ep.getAddress(), adres);
        ep.sendKeysFunction(ep.getCity(), city);
        ep.sendKeysFunction(ep.getCountry(), country);
        ep.clickFunction(ep.getNextButton4());
        ep.sendKeysFunction(ep.getPhone(), phoneNumber);
        ep.clickFunction(ep.getNextButton5());
        ep.clickFunction(ep.getNextButton6());
        ep.clickFunction(ep.getConfirm());
        ep.verifyContainsText(ep.getAccessMessage(), "Created Patient Record:");
        ep.clickFunction(ep.getHomeButton());
    }

    @DataProvider(name = "patientData")
    public static Object[][] patientData() {
        return new Object[][]{
                {"Can", "AKSOY", "20", "1991", "Student Mah. Techno Cad. 2 Sokak No:44", "Istanbul", "TÜRKİYE", "05554443322"},
                {"Melis", "ASLAN", "07", "1990", "Çayır Çimen Mah. Yeşillik Sokak No:16", "Bursa", "TÜRKİYE", "05444212121"},
                {"Tekin", "KOÇ", "27", "1992", "1910 Angara Mah. AnkaraGücü Sokak No:06", "Ankara", "TÜRKİYE", "05444060606"}
        };
    }

    @Test(priority = 3, groups = {"Smoke Test"})
    public void US_OMRS05() { //Hesabım (My Account)

        ElementsPage ep = new ElementsPage();
        if (driver.getCurrentUrl().equals("data:,")) {
            US_OMRS02();
        }
        ep.clickFunction(ep.getUserIcon());
        waiting(1);
        ep.clickFunction(ep.getMyAccount());
        waiting(1);
        ep.hoverFunction(ep.getChangePassword());
        ep.verifyContainsText(ep.getChangePassword(), "Change Password");
        waiting(1);
        ep.hoverFunction(ep.getMyLanguages());
        ep.verifyContainsText(ep.getMyLanguages(), "My Languages");
        waiting(1);
        ep.clickFunction(ep.getHomeButton());
    }

    @Test(priority = 5, groups = {"Smoke Test"})
    public void US_OMRS06() { //Hasta Listesinde Arama

        ElementsPage ep = new ElementsPage();
        if (driver.getCurrentUrl().equals("data:,")) {
            US_OMRS02();
        }
        ep.clickFunction(ep.getSearchPatient());
        ep.sendKeysFunction(ep.getSearchPatientBox(), "Can AKSOY");
        waiting(1);
        ep.clickFunction(ep.getPatientButton());
        Assert.assertTrue(ep.getNameSuccess().getText().toUpperCase().contains("CAN"));
        Assert.assertTrue(ep.getSurnameSuccess().getText().toUpperCase().contains("AKSOY"));
        waiting(1);
        ep.clickFunction(ep.getHomeButton());
        ep.clickFunction(ep.getSearchPatient());
        ep.sendKeysFunction(ep.getSearchPatientBox(), "olmayan isim");
        Assert.assertTrue(ep.getSearchPatientNegativeSuccess().getText().contains("No matching records found"));
        waiting(2);
        ep.clickFunction(ep.getHomeButton());
    }

    @Test(priority = 9, groups = {"Smoke Test"})
    public void US_OMRS07() { //Hasta Silme

        ElementsPage ep = new ElementsPage();
        if (driver.getCurrentUrl().equals("data:,")) {
            US_OMRS02();
        }
        ep.clickFunction(ep.getSearchPatient());
        ep.sendKeysFunction(ep.getSearchPatientBox(), "Melis ASLAN");
        waiting(1);
        ep.clickFunction(ep.getPatientButton());
        String id1 = ep.getPatientId().getText();
        waiting(1);
        ep.clickFunction(ep.getDeletePatient());
        ep.sendKeysFunction(ep.getDeleteReason(), "YES");
        ep.clickFunction(ep.getConfirmButton());
        ep.sendKeysFunction(ep.getSearchPatientBox(), "Can AKSOY");
        waiting(1);
        ep.clickFunction(ep.getPatientButton());
        waiting(1);
        ep.clickFunction(ep.getDeletePatient());
        ep.sendKeysFunction(ep.getDeleteReason(), "YES");
        ep.clickFunction(ep.getConfirmButton());

        wait.until(ExpectedConditions.visibilityOf(ep.getSearchPatientBox()));
        waiting(1);
        ep.sendKeysFunction(ep.getSearchPatientBox(), id1);
        Assert.assertTrue(ep.getSearchPatientNegativeSuccess().getText().contains("No matching records found"));
        ep.clickFunction(ep.getHomeButton());
    }

    @Test(priority = 6, groups = {"Smoke Test"})
    public void US_OMRS08() { //Hasta Listeleme

        ElementsPage ep = new ElementsPage();
        if (driver.getCurrentUrl().equals("data:,")) {
            US_OMRS02();
        }
        ep.clickFunction(ep.getSearchPatient());
        String fullText = ep.getShowingEntries().getText();
        String[] words = fullText.split(" ");
        int toplamGiris = Integer.parseInt(words[words.length - 2]);
        System.out.println("Toplam Giriş: " + toplamGiris);

        int pageNumber = ep.getPageNumber().size();
        int satirSayisi = 0;

        for (int i = 0; i < pageNumber; i++) {
            ep.getPageNumber().get(i).click();
            satirSayisi += ep.getPageRows().size();
        }
        System.out.println("Toplam Satır Sayısı: " + satirSayisi);
        ep.clickFunction(ep.getHomeButton());
    }

    @Test(priority = 7, groups = {"Smoke Test"})
    public void US_OMRS09() { //Hasta Kayıtlarını Birleştirme (Merge)

        ElementsPage ep = new ElementsPage();
        if (driver.getCurrentUrl().equals("data:,")) {
            US_OMRS02();
        }
        ep.clickFunction(ep.getSearchPatient());
        ep.sendKeysFunction(ep.getSearchPatientBox(), "Can AKSOY");
        waiting(1);
        ep.clickFunction(ep.getPatientButton());
        String id1 = ep.getPatientId().getText();
        ep.clickFunction(ep.getHomeButton());

        ep.clickFunction(ep.getSearchPatient());
        ep.sendKeysFunction(ep.getSearchPatientBox(), "Tekin KOÇ");
        waiting(1);
        ep.clickFunction(ep.getPatientButton());
        String id2 = ep.getPatientId().getText();
        ep.clickFunction(ep.getHomeButton());
        waiting(1);
        ep.clickFunction(ep.getDataManagement());
        ep.clickFunction(ep.getMergePatient());
        ep.sendKeysFunction(ep.getPatient1(), id1);
        ep.sendKeysFunction(ep.getPatient2(), id2);
        ep.clickFunction(ep.getPatientSearchClick());
        waiting(3);
        ep.clickFunction(ep.getContinueButton());
        ep.verifyContainsText(ep.getMergindSuccess(), "Merging cannot be undone");
        ep.clickFunction(ep.getClickPatient());
        ep.clickFunction(ep.getContinueButton());
        ep.verifyContainsText(ep.getMergePatientId1(), id2);
        ep.verifyContainsText(ep.getMergePatientId2(), id1);
        ep.clickFunction(ep.getHomeButton());
    }

    @Test(priority = 8, groups = {"Smoke Test"})
    public void US_OMRS10() {//Hasta randevusu alırken yanlış saat dilimi

        ElementsPage ep = new ElementsPage();
        if (driver.getCurrentUrl().equals("data:,")) {
            US_OMRS02();
        }
        ep.clickFunction(ep.getAppointmentScheduling());
        ep.clickFunction(ep.getManageAppointments());
        ep.sendKeysFunction(ep.getSearchPatientBox(), "Can AKSOY");
        waiting(2);
        ep.clickFunction(ep.getPatientButton());
        ep.verifyContainsText(ep.getAlertText(), "Your computer is not set to the right time zone.");
        ep.clickFunction(ep.getHomeButton());
    }
}