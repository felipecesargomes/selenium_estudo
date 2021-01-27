package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\estudo-sql\\drivers\\chromedriver.exe");
        //Abrindo o navegador
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit/");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {

        //Clicar no link que possui o texto "sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificando formulário de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"

        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        //Digitar no campo com name "password" está dentro do formulário de id "signinbox" o texto "123456"

        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SIGN IN"

        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a class "me"

        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "MORE DATA ABOUT YOU"

        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //Clicar no botão através do seu xpath //button[@data-target="addmoredata"]

        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar a popup onde está o formulário de id addmoredata

        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //Na combo de name "type" escolher uma das opções
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        //No campo de name "contact" digitar "+541199999999"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5411999999999");

        //Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));

    }
    @After
    public void tearDown() {
        //Fechar o navegador
        //navegador.quit();
    }
}
