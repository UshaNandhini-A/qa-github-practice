// Login test flow - Practice branch

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class FirstMobileTest {
    public static void main(String[] args) throws MalformedURLException{
        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.google.android.deskclock");
        options.setAppActivity("com.android.deskclock.DeskClock");

        AndroidDriver driver = new AndroidDriver( new URL("http://127.0.0.1:4723"), options);

        System.out.println("Appium session started successfully!");

        boolean alarmDisplayed = driver.findElement((AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Alarm\"]/android.widget.FrameLayout[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_container\"]"))).isDisplayed();
        System.out.println("Alarm on " + alarmDisplayed);

        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Alarm\"]/android.widget.FrameLayout[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_container\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.Switch[@content-desc=\"8:30 AM alarm\"]")).click();

        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.Switch[@content-desc=\"8:30 AM alarm\"]"))
                        .getAttribute("checked")
        );

        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.Switch[@content-desc=\"8:30 AM alarm\"]"))
                        .getAttribute("resource-id")
        );

        boolean alarmSelected = driver.findElement(AppiumBy.xpath("//android.widget.Switch[@content-desc=\"8:30 AM alarm\"]")).isSelected();

        if (alarmSelected) {
            System.out.println("PASS - Alarm is ON");
        } else {
            System.out.println("FAIL - Alarm is OFF");
        }

        boolean alarmEnabled = driver.findElement(AppiumBy.xpath("//android.widget.Switch[@content-desc=\"8:30 AM alarm\"]")).isEnabled();
        System.out.println("Alarm enabled: " + alarmEnabled);



        String notification = driver.findElement((AppiumBy.id("com.google.android.deskclock:id/snackbar_text"))).getText();

        System.out.println(notification + "Alarm saved");


        driver.findElement(AppiumBy.xpath("//android.widget.Switch[@content-desc=\"9:00 AM alarm\"]")).click();
        String notification2 = driver.findElement((AppiumBy.id("com.google.android.deskclock:id/snackbar_text"))).getText();
        System.out.println(notification2 + "Alarm saved");

    }

    // Fixed login error message validation - Issue #2
   // String password = "invalidPassword";

//if (password.equals("invalidPassword")) {
       // System.out.println("Invalid username or password");
    }
}