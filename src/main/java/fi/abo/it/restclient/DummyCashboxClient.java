/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.abo.it.restclient;

/**
 *
 * @author bbyholm
 */
public class DummyCashboxClient implements CashboxClient {

	Status status;

	public DummyCashboxClient() {
		status = Status.CLOSED;
	}

	@Override
	public Status getStatus() {
		return status;
	}

	@Override
	public void open() {
		status = Status.OPEN;
	}

}
