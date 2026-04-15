package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {

    public static void main(String[] args) {

        // Headless setup for Jenkins
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            // Login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            System.out.println("Login Successful ✅");

            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("Test Failed ❌");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
