package View.View;

public class SignInView implements IDisplay {

	/**
	 * 
	 * @param login
	 * @param password
	 */
	public Integer SignIn(String login, String password) {
		// TODO - implement SignInView.SignIn
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Login
	 * @param Password
	 * @param Role
	 */
	public void CreateAccount(String Login, String Password, int Role) {
		// TODO - implement SignInView.CreateAccount
		throw new UnsupportedOperationException();
	}

	@Override
	public void Display() {
		String login;
		String password;
		Integer userId = null;

		while (userId == null) {
			System.out.println("Sign in");
			System.out.println("Press 1 to create account");
			System.out.println("Press 2 to sign in");
			System.out.println("Press 3 to exit");
			var choice = System.console().readLine();

			if (choice.equals("3")) {
				return;
			}

			if (choice.equals("1")) {
				var role = 0;
				System.out.println("Login: ");
				login = System.console().readLine();
				System.out.println("Password: ");
				password = System.console().readLine();
				System.out.println("Role: ");
				System.out.println("0 - Klient");
				System.out.println("1 - Kierowca");
				role = Integer.parseInt(System.console().readLine());
				CreateAccount(login, password, role);
				System.out.println("Account created");
				continue;
			}


			System.out.println("Login: ");
			login = System.console().readLine();
			System.out.println("Password: ");
			password = System.console().readLine();
			userId = SignIn(login, password);
			if (userId == null) {
				System.out.println("Invalid login or password");
			}
		}
	}
}