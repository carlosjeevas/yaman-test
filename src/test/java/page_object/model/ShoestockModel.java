package page_object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import page_object.ShoestockPO;
import selenium.page_object.BaseWebPage;

public class ShoestockModel extends BaseWebPage {

	Actions actions = new Actions(webDriver);
	private ShoestockPO shoes;

	public ShoestockModel(WebDriver webDriver) {
		super(webDriver);
		shoes = new ShoestockPO(webDriver);
	}

	@Override
	public boolean isDisplayed() {
		return shoes.isDisplayed();
	}

	/**
	 * Preenche o campo de busca
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void inputSearch(String pesquisa) throws Exception {
		command.send(shoes.inptSearch(), pesquisa);
	}

	/**
	 * Clica no botão que faz a busca
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void btnSearch() throws Exception {
		command.click(shoes.btnSearch());
	}

	/**
	 * Clica no primeiro item buscado
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void firstChosenItem() throws Exception {
		command.click(shoes.firstChosenItem());
	}

	/**
	 * Clica no tamanho desejado do tênis
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void tennisSize(String size) throws Exception {
		command.click(shoes.tennisSize(size));
	}

	/**
	 * Clica no botão 'Comprar'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void btnComprar() throws Exception {
		Thread.sleep(1000);
		command.click(shoes.btnComprar());
	}

	/**
	 * Valida se o texto 'Meu Carrinho' é exibido
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public boolean txtMeuCarrinho() throws Exception {
		return shoes.txtMeuCarrinho();
	}

	/**
	 * Valida texto da tela de pagamento
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public boolean txtPayment() throws Exception {
		return shoes.txtPayment();
	}

	/**
	 * Clica no botão 'Continuar'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void btnContinuar() throws Exception {
		Thread.sleep(1000);
		command.click(shoes.btnContinuar());
	}

	/**
	 * Preenche o campo 'Email'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void inputUsername(String email) throws Exception {
		WebElement inputEmail = shoes.inputUsername();

		command.clear(inputEmail);
		command.send(inputEmail, email);
	}

	/**
	 * Preenche o campo 'Password'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void inputPassword(String password) throws Exception {
		WebElement inputPassword = shoes.inputPassword();

		command.clear(inputPassword);
		command.send(inputPassword, password);
	}

	/**
	 * Clica no botão 'Acessar conta'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void btnAcessarConta() throws Exception {
		command.click(shoes.btnAcessarConta());
	}
	
	/**
	 * Nome do usuário logado
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public boolean nameUserLogged() throws Exception {
		return shoes.nameUserLogged();
	}
}