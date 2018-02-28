
package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.collect.Lists;
import com.wordnik.swagger.annotations.ApiParam;

import api.CommandAPI;
import api.HomeAPI;
import api.PersonAPI;
import opower.Home;
//import fr.tp4sir.tp4sir.Home;
//import fr.tp4sir.tp4sir.ManagerSingleton;
import opower.Person;
import services.HomeServices;


@Path("/home")
public class HomeResource {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addHome(
    	@ApiParam(
        value = "size",
        required = true
    )@FormParam("size") final Double size, 
    	@ApiParam(
        value = "rooms",
        required = true
    )@FormParam("rooms") final Integer rooms, 
    	@ApiParam(
        value = "name",
        required = true
    )@FormParam("name") final String name) {
    	
    		HomeAPI homeQueries = new HomeAPI();
        Home home = new Home(size, rooms, name);
        homeQueries.put(home);

        return Response.status(201).entity(home).build();
        
    }    
    
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllHomes() {

        HomeAPI api = new HomeAPI();
        Collection<Home> resultList = api.findAll();
        
        List<HashMap<?, ?>> listOfLists = Lists.newArrayList();
    

        for (Home next : resultList) {
        	HashMap<String, Object> hmap = new HashMap<String, Object>();
        		hmap.put("Identifier", next.getId());
        		hmap.put("Name", next.getName());
            hmap.put("Size", next.getTaille());
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

        HomeAPI api = new HomeAPI();
        Home home = api.find(Integer.parseInt(identifier));
        List<HashMap<?, ?>> listOfLists = Lists.newArrayList();
        HashMap<String, Object> hmap = new HashMap<String, Object>();

        hmap.put("identifier", home.getId());
        hmap.put("name", home.getName());
        hmap.put("rooms", home.getPieces());
        hmap.put("size", home.getTaille());
        hmap.put("person_id", home.getPerson().getId());
        hmap.put("house_of", home.getPerson().getName() + " " + home.getPerson().getSurname());
        
        listOfLists.addAll(Lists.newArrayList(hmap));

        return Response.status(201).entity(listOfLists).build();
    } 



}
