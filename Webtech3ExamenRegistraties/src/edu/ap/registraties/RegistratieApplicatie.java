package edu.ap.registraties;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class RegistratieApplicatie extends Application{
	
	   @Override
	   public synchronized Restlet createInboundRoot() {

	       Router router = new Router(getContext());

	       router.attach("/registratie", RegistratieResource.class);
	       router.attach("/registratie/{registratie_id}", RegistratieResource.class);

	       return router;
	   }
	

}
