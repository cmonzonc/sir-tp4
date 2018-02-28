package fr.istic.sir.rest;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.collect.Lists;

import com.wordnik.swagger.annotations.ApiParam;

import api.*;

//import io.swagger.annotations.*;
import opower.*;

@Path("/person")
public class PersonResource {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public PersonResource() {
        entityManager = LocalEntityManagerFactory.getInstance();

        // LocalEntityManager.getInstance();
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(@ApiParam(
        value = "email",
        required = true
    )
    @FormParam("email") final String email, @ApiParam(
        value = "First Name",
        required = true
    )
    @FormParam("firstname") final String firstname, @ApiParam(
        value = "Last Name",
        required = true
    )
    @FormParam("lastname") final String lastname) {

    		PersonAPI queries = new PersonAPI();
        Person inserted = new Person(lastname, firstname, email);
        queries.put(inserted);    	
    	
        return Response.status(201).entity(inserted).build();
    }

    @DELETE
    @Path("/{identifier}")
    @Produces({ MediaType.APPLICATION_JSON })
    public void deletePerson(@PathParam("identifier") Integer identifier) {
    		System.out.println("Delete<> " + identifier);
        	PersonAPI api = new PersonAPI();
        	api.remove(identifier);
        	//return Response.status(201).entity("Success").build();
    }

    @SuppressWarnings("unchecked")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPerson() {
        PersonAPI api = new PersonAPI();
        Collection<Person> resultList = api.findAll();
        List<HashMap<?, ?>> listOfLists = Lists.newArrayList();

        for (Person next : resultList) {
            HashMap<String, Object> hmap = new HashMap<String, Object>();

            hmap.put("identifier", next.getId());
            hmap.put("firstname", next.getName());
            hmap.put("surname", next.getSurname());
            hmap.put("email", next.getEmail());
            listOfLists.addAll(Lists.newArrayList(hmap));
        }

        return Response.status(201).entity(listOfLists).build();
    }

    @GET
    @Path("/id/{identifier}")
    @Consumes("application/x-www-form-urlencoded")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getPerson(@PathParam("identifier") String identifier) {
        System.out.println(identifier);

        PersonAPI api = new PersonAPI();
        Person person = api.find(Integer.parseInt(identifier));
        List<HashMap<?, ?>> listOfLists = Lists.newArrayList();
        HashMap<String, Object> hmap = new HashMap<String, Object>();

        hmap.put("identifier", person.getId());
        hmap.put("firstname", person.getName());
        hmap.put("surname", person.getSurname());
        hmap.put("email", person.getEmail());
        listOfLists.addAll(Lists.newArrayList(hmap));

        return Response.status(201).entity(listOfLists).build();
    }    
    
    @PUT
    @Path("/{identifier}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Person updatePerson(@PathParam("identifier") String personId, Person pers) {
        PersonAPI api = new PersonAPI();
        Person person = api.find(Long.parseLong(personId));

        person.setName(pers.getName());
        person.setSurname(pers.getSurname());
        person.setEmail(pers.getEmail());

        return api.update(pers);
    }
    
}