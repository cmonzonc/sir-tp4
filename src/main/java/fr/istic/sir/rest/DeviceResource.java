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

import services.DeviceServices;

@Path("/device")
public class DeviceResource {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public DeviceResource() {
        entityManager = LocalEntityManagerFactory.getInstance();

        // LocalEntityManager.getInstance();
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addDevice(@ApiParam(
        value = "name",
        required = true
    )
    @FormParam("name") final String name, @ApiParam(
        value = "power",
        required = true
    )
    @FormParam("power") final Integer power, @ApiParam(
        value = "type",
        required = true
    )
    @FormParam("type") final String type, @ApiParam(
        value = "unit",
        required = false
    )
    @FormParam("unit") final String unit, @ApiParam(
        value = "location",
        required = false
    )
    @FormParam("location") final String location) {
        DeviceAPI queries = new DeviceAPI();

        if (type.equals("heater")) {
            System.out.println(type);

            Heater inserted = new Heater(name, power, unit, location);

            queries.put(inserted);

            return Response.status(201).entity(inserted).build();
        } else if (type.equals("electronic")) {
            ElectronicDevice inserted = new ElectronicDevice(name, power, unit);

            queries.put(inserted);

            return Response.status(201).entity(inserted).build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("/{identifier}")
    @Produces({ MediaType.APPLICATION_JSON })
    public void deleteDevice(@PathParam("identifier") Integer identifier) {
        System.out.println("Delete<> " + identifier);

        PersonAPI api = new PersonAPI();

        api.remove(identifier);

        // return Response.status(201).entity("Success").build();
    }

    @GET
    @Path("/id/{identifier}")
    @Consumes("application/x-www-form-urlencoded")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getDeviceById(@PathParam("identifier") String identifier) {
        DeviceAPI api = new DeviceAPI();
        Device device = api.findHeater(Long.parseLong(identifier));
        List<HashMap<?, ?>> listOfLists = Lists.newArrayList();
        HashMap<String, Object> hmap = new HashMap<String, Object>();

        hmap.put("identifier", device.getId());
        hmap.put("type", device.getClass().getName());
        listOfLists.addAll(Lists.newArrayList(hmap));

        return Response.status(201).entity(listOfLists).build();
    }

    @GET
    @Path("/electronic")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getElectronic() {
        DeviceServices devices = new DeviceServices();
        List<Heater> electronicsTemporal = devices.listHeater();
        List<HashMap<?, ?>> listOfLists = Lists.newArrayList();

        for (Heater next : electronicsTemporal) {
            HashMap<String, Object> hmap = new HashMap<String, Object>();

            hmap.put("identifier", next.getId());
            hmap.put("power", next.getPower());

            // hmap.put("person", next.getPerson());
            hmap.put("name_device", next.getName());
            listOfLists.addAll(Lists.newArrayList(hmap));
        }

        return Response.status(201).entity(listOfLists).build();
    }

    @GET
    @Path("/heater")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHeater() {
        DeviceServices devices = new DeviceServices();
        List<Heater> heaters = devices.listHeater();
        List<HashMap<?, ?>> listOfLists = Lists.newArrayList();

        for (Heater next : heaters) {
            HashMap<String, Object> hmap = new HashMap<String, Object>();

            hmap.put("identifier", next.getId());
            hmap.put("power", next.getPower());
            hmap.put("location", next.getLocationHome());

            // hmap.put("home_identifier", next.getHome().getId());
            hmap.put("name_heater", next.getNameHeater());

            if (next.getHome() != null) {
                hmap.put("home_id", next.getHome().getId().toString());
            } else {
                hmap.put("home_id", "NULL");
            }

            listOfLists.addAll(Lists.newArrayList(hmap));
        }

        return Response.status(201).entity(listOfLists).build();
    }
}