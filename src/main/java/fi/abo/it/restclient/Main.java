/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.abo.it.restclient;

import java.util.Optional;

/**
 *
 * @author bbyholm
 */
public class Main {

	public static void cashboxTest(CashboxClient c) {
		System.out.println(c.getStatus().name());
		c.open();
		System.out.println(c.getStatus().name());
	}

	public static void main(String[] args) {
		System.out.println("Dummy Client:");
		cashboxTest(new DummyCashboxClient());
		System.out.println("REST Client:");
		cashboxTest(new RestCashboxClient(Optional.empty(), Optional.
			empty(),
			Optional.empty(), Optional.empty()));
	}
}
