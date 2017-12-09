package com.lxdmp.stock.router;

import java.util.concurrent.*;

public final class ContactDb 
{
	static protected ContactDb _instance;
	private ConcurrentMap<String, Contact> _contacts;

	protected ContactDb() 
	{
		super();
		
		_contacts = new ConcurrentHashMap<String, Contact>();
		
		{
			Contact new_contact = new Contact();
			new_contact.setId("1");
			new_contact.setName("name1");
			new_contact.setNo("123456789");
			this._contacts.put(new_contact.getId(), new_contact);	
		}
		
		{
			Contact new_contact = new Contact();
			new_contact.setId("2");
			new_contact.setName("name2");
			new_contact.setNo("123456789-2");
			this._contacts.put(new_contact.getId(), new_contact);
		}
	}
	
	static public synchronized ContactDb instance()
	{
		if(_instance==null)
			_instance = new ContactDb();
		return _instance;
	}
	
	public ConcurrentMap<String, Contact> getContacts()
	{
		return _contacts;
	}
	
	public Contact getContact(String id)
	{
		return _contacts.get(id);
	}
	
	public void addContact(Contact newContact)
	{
		this._contacts.put(newContact.getId(), newContact);
	}
}
