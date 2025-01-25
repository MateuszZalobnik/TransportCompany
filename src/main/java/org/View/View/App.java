
package org.View.View;

import org.Model.Model.*;
import org.Presenter.Presenter.Facade;

public class App {

	private IDisplay[] view;

	private Integer UserId = null;

	public static void main(String[] args) {
		var signInView = new SignInView();
		signInView.Display();
	}

}