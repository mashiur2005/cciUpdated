package com.cefalo.cci.restResource;

import com.cefalo.cci.dao.ResourceDao;
import com.cefalo.cci.domain.Employee;
import com.google.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mashiur
 * Date: 2/16/13
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/tr")
public class TestResource {

    @Context
    UriInfo uriInfo;
    @Context
    HttpHeaders httpHeaders;

    @Inject
    private ResourceDao resourceDao;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_XML)
    public List<Employee> getAllEmployee() {
        return resourceDao.getAllEmployee();
    }

    @GET
    @Path("/employee/{uName}")
    @Produces(MediaType.APPLICATION_XML)
    public Employee getEmployeeByUserName(@PathParam("uName") String userName) {
        return resourceDao.getEmployeeByUserName(userName);
    }

    @POST
    @Path("/insertEmployee")
    public void saveEmployee(@FormParam("username") String userName, @FormParam("password") String password,
                             @FormParam("firstname") String firstName, @FormParam("lastname") String lastName,
                             @FormParam("email") String email, @FormParam("company") String compnay) {
        Employee employee = new Employee();
        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setCompany(compnay);

        resourceDao.saveEmployee(employee);
    }

    @DELETE
    @Path("/delete/{userName}")
    public void deleteEmployee(@PathParam("userName") String userName) {
        Employee employee = resourceDao.getEmployeeByUserName(userName);
        resourceDao.deleteEmployee(employee);
    }
}
