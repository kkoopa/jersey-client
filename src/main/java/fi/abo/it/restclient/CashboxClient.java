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
public interface CashboxClient {

	public static enum Status {
		OPEN, CLOSED
	}

	public Status getStatus();

	public void open();
}
