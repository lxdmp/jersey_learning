package com.lxdmp.stock.router;

import java.net.URI;
import java.util.*;
import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.NotFoundException;

@Path("/contacts")
public class ContactsResource 
{
	@Context
    UriInfo uriInfo;
    @Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Contact> allContacts()
    {
		return ContactDb.instance().getContacts().values();
    }
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{contact_id}")
	public Contact contact(@PathParam("contact_id") String contactId)
	{
		Contact ret = ContactDb.instance().getContact(contactId);
		if(ret==null)
			throw new NotFoundException(
				String.format("no contact with id \"%s\"", contactId));
		return ret;
	}
	
	@POST
	//@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	public void addContact(/*@BeanParam*/ Contact contact2Added) throws IOException
	{
		ContactDb.instance().addContact(contact2Added);
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(contact2Added.getId()).build();
	    Response.created(uri).build();
	    response.sendRedirect(uri.toString());
	}
}
