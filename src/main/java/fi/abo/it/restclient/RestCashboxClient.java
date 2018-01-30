/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.abo.it.restclient;

import java.util.Optional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 *
 * @author bbyholm
 */
public class RestCashboxClient implements CashboxClient {

	private static final String PROTOCOL = "http";
	private static final String SERVER = "localhost";
	private static final int PORT = 9001;
	private static final String PREFIX = "/cashbox/";
	private static final String STATUS = "status";
	private static final String OPEN = "open";
	private static final int STATUS_OK = 200;

	private final String protocol;
	private final String server;
	private final int port;
	private final String prefix;

	private static final Client CLIENT = ClientBuilder.newClient();

	public RestCashboxClient(Optional<String> protocol, Optional<String> server,
		Optional<Integer> port, Optional<String> prefix) {
		this.protocol = protocol.orElse(PROTOCOL);
		this.server = server.orElse(SERVER);
		this.port = port.orElse(PORT);
		this.prefix = prefix.orElse(PREFIX);
	}

	@Override
	public Status getStatus() {
		Response response = CLIENT.target(
			protocol + "://" + server + ":" + Integer.toString(port) + prefix + STATUS).
			request().get();
		int status = response.getStatus();
		if (status != STATUS_OK) {
			throw new RuntimeException("Bad response from server");
		}

		switch (response.readEntity(String.class)) {
			case "OPEN":
				return Status.OPEN;
			case "CLOSED":
				return Status.CLOSED;
			default:
				throw new RuntimeException("Bad response from server");
		}
	}

	@Override
	public void open() {
		Response response = CLIENT.target(
			protocol + "://" + server + ":" + Integer.toString(port) + prefix + OPEN).
			request().post(null);
		int status = response.getStatus();
		if (status != STATUS_OK) {
			throw new RuntimeException("Bad response from server");
		}
	}
}
