package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginUdemy {

    @Test
    public void fazerLoginUdemy() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\estudo-sql\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegar para a pagina do udemy
        navegador.get("https://www.udemy.com/");

        //clicar no link da classe header-login
        navegador.findElement(By.linkText("Fazer login")).click();

        //Identificando formulário de login - id login-form

        WebElement formularioLoginForm = navegador.findElement(By.id("login-form"));

        //Digitar no campo de email que está dentro do formulário de id login-form, o valor www.felipecesargomes@gmail.com

        formularioLoginForm.findElement(By.id("email--1")).sendKeys("felipecesarbd@gmail.com");

        //Digitar no campo de senha que está dentro do formulário de id login-form, o valor Ciencia1#

        formularioLoginForm.findElement(By.id("id_password")).sendKeys("ciencia1");

        //Clicar no botão com id submit-id-submit

        navegador.findElement(By.id("submit-id-submit")).click();

        //Clicar no botão com id u407-popper-trigger--18

        WebElement classDesejada = navegador.findElement(By.className("list-menu--list-menu-container--21IlT"));
        classDesejada.findElement(By.xpath("//a[@href ='/user/edit-profile/']")).click();

        //Verificar se no elemento user-short está escrito Felipe César

        WebElement nomeUsuario = navegador.findElement(By.className("tooltip-container"));
        String textoNoElemento = nomeUsuario.getText();
        Assert.assertEquals("Felipe César",textoNoElemento);

        //Fechar navegador

    }
}