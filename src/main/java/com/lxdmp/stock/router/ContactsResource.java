package com.lxdmp.stock.router;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/contacts")
public class ContactsResource 
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public Collection<Contact> allContacts()
    {
		return ContactDb.instance().getContacts().values();
    }
}
