package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.page_object.BaseWebPage;

/**
 * Page Object de Shop
 * 
 * @author Carlos Moreira
 */
public class ShoestockPO extends BaseWebPage {

	private static By INPT_SEARCH = By.id("search-input");
	private static By BTN_SEARCH = By.xpath("//button[@title='Buscar']");
	private static By IMG_SHOESTOCK = By.xpath("//h1[@class='logo image']");
	private static By CHOSEN_ITEM = By.xpath("(//a[@title='Sapatênis Couro Democrata Hit Masculino']/img)[1]");
	private static By BTN_COMPRAR = By.id("buy-button-now");
	private static By TXT_MEU_CARRINHO = By.xpath("//h1[contains(text(),'Meu carrinho')]");
	private static By TXT_PAYMENT = By.xpath("//h2[text()='Pagamento']");
	private static By BTN_CONTINUAR = By.xpath("//a[contains(text(),'Continuar')]");
	private static By INPT_USERNAME = By.id("username");
	private static By INPT_PASSWORD = By.id("password");
	private static By BTN_ACESSAR_CONTA = By.id("login-button");
	private static By NAME_USER_LOGGED = By.id("username-logged");

	public ShoestockPO(WebDriver webDriver) {
		super(webDriver);
	}

	@Override
	public boolean isDisplayed() {
		return searchElement.existsNoLog(IMG_SHOESTOCK, "Elemento usado para validacao da pagina 'Shoestock'", 1);
	}

	/**
	 * Caixa de busca
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement inptSearch() throws Exception {
		return searchElement.findElementBy(INPT_SEARCH, "Caixa de busca");
	}

	/**
	 * Botão de busca
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement btnSearch() throws Exception {
		return searchElement.findElementBy(BTN_SEARCH, "Botão de busca");
	}

	/**
	 * Primeiro item da busca
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement firstChosenItem() throws Exception {
		return searchElement.findElementBy(CHOSEN_ITEM, "Primeiro item da busca");
	}

	/**
	 * Tamanho do tênis
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement tennisSize(String size) throws Exception {
		By TENNIS_SIZE = By.xpath("(//a[@data-label='" + size + "'])[1]");

		return searchElement.findElementBy(TENNIS_SIZE, "Tamanho do tênis");
	}
	
	/**
	 * Botão 'Comprar'
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement btnComprar() throws Exception {
		return searchElement.findElementBy(BTN_COMPRAR, "Botão 'Comprar'");
	}
	
	/**
	 * Texto 'Meu carrinho'
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean txtMeuCarrinho() throws Exception {
		return searchElement.existsNoLog(TXT_MEU_CARRINHO, "Texto 'Meu carrinho'", 1);
	}
	
	/**
	 * Texto 'Pagamento'
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean txtPayment() throws Exception {
		return searchElement.existsNoLog(TXT_PAYMENT, "Texto 'Pagamento'", 1);
	}
	
	/**
	 * Botão 'Continuar'
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement btnContinuar() throws Exception {
		return searchElement.findElementBy(BTN_CONTINUAR, "Botão 'Continuar'");
	}	
	
	/**
	 * Campo 'Email'
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement inputUsername() throws Exception {
		return searchElement.findElementBy(INPT_USERNAME, "Campo 'Email'");
	}	
	
	/**
	 * Campo 'Password'
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement inputPassword() throws Exception {
		return searchElement.findElementBy(INPT_PASSWORD, "Campo 'Senha'");
	}	
	
	/**
	 * Botão 'Acessar conta'
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement btnAcessarConta() throws Exception {
		return searchElement.findElementBy(BTN_ACESSAR_CONTA, "Botão 'Acessar conta'");
	}	
	
	/**
	 * Nome do usuário logado
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean nameUserLogged() throws Exception {
		return searchElement.existsNoLog(NAME_USER_LOGGED, "Nome do usuário logado", 1);
	}
}