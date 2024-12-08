
package View.View;

public class App {

	private IDisplay[] view;

	private Integer UserId = null;

	public static void main(String[] args) {
		var signInView = new SignInView();
		signInView.Display();
	}

}