package org.cro.springbanque.controlers;

import java.util.ArrayList;
import java.util.List;

import org.cro.springbanque.models.Client;

public class ClientControler {
	private List<Client> clients = new ArrayList<Client>(List.of(new Client(2464986, "ROMANO","Cyril",20), new Client(795620133, "ROMANO", "Marco", 55), new Client(457992023, "STRIFE", "Clad", 23)));
}
