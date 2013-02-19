package com.cefalo.cci.restResource;

import com.cefalo.cci.domain.Employee;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: mashiur
 * Date: 2/16/13
 * Time: 7:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestResourceJerseyIntegrationTest extends JerseyTest{
    private static final String BASE_URL = "/cciService/tr";
    private static final String PACKAGE_NAME = "com.cefalo.cci.restResource";

    private WebResource ws;

    public TestResourceJerseyIntegrationTest() {
        super(new WebAppDescriptor.Builder(PACKAGE_NAME).build());
    }

    @Test
    public void getAllEmployeeStatusTest() {
        ws = resource().path(BASE_URL + "/all");
        ClientResponse clientResponse = ws.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
        assertEquals(200, clientResponse.getStatus());
    }

    @Test
    public void getAllEmployeeXmlTest() {
        ws = resource().path(BASE_URL + "/all");
        String employeeList = ws.accept(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("testing the returned xml........." + employeeList);
        assertNotNull(employeeList != null && employeeList.isEmpty());
    }

    @Test
    public void getEmployeeByUserNameTest() {
        String userName = "mashiur";
        ws = resource().path(BASE_URL).path("/employee").path(userName);
        Employee employee = ws.accept(MediaType.APPLICATION_XML).get(Employee.class);
        System.out.println(employee.getEmail() + ".......test..........");
        assertNotNull(employee);
    }
}
