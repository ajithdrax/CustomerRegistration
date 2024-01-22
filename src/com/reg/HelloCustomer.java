package com.reg;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entity.Customer;
 
@Path("/hello")
public class HelloCustomer{
	private static List<Customer> list = new ArrayList<Customer>(){
		{
			add(new Customer(1,"Deepika"));
			add(new Customer(2,"Ajith"));
		}
		
	};
	@Path("/sayHello")
@GET
@Produces(MediaType.TEXT_PLAIN)
public String direBonjour() {
        return "Hello World!!";
    }
    
	@Path("getCustomers")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
	public Response getAllCustomers(){
		return Response.status(200).entity("List values :\n "+list).build();
	}
    

    
    @POST
    @Path("/createCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    public Response createCustomer(Customer newCustomer){
    	list.add(newCustomer);
    	return Response.status(200).entity("New entry created!! \nID : "+newCustomer.getId()+"\nName : "+newCustomer.getName()).build();
    }
    
    
    
    @PUT
    @Path("/updateCustomerWithID/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    public Response updateCustomerWithID(@PathParam("id") int id,Customer customer){
    	
    	Customer findCustomer=list.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
    	if(findCustomer != null){
    		findCustomer.setName(customer.getName());
    		return Response.status(200).entity("Updated!! \nID : "+id+"\nName : "+findCustomer.getName()).build();
    	}
    	return Response.status(200).entity("ID not found").build();
    }

    
    
    
    @DELETE
    @Path("/deleteCustomer/{id}")
    public Response deleteCustomer(@PathParam("id") int id){
    	Customer findCustomer=list.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
    	if(findCustomer != null){
    		list.remove(findCustomer);
    		return Response.status(200).entity("Record Deleted").build();
    	}
    	return Response.status(200).entity("ID not found").build();}
}
