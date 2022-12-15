package model.services;

public class BrazilTaxService {

	public Double tax(double amount) {
		return (amount <= 100.0) ? amount * 0.2 : amount * 0.15;
	}

}
