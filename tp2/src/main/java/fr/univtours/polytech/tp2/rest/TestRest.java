package fr.univtours.polytech.tp2.rest;

import java.util.List;

import fr.univtours.polytech.tp2.business.TestBusiness;
import fr.univtours.polytech.tp2.model.TestBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/test")
public class TestRest {

    @Inject
    private TestBusiness testBusiness;

    // POST
    @POST
    @Path("")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void addTest(TestBean testBean) {
        this.testBusiness.addTest(testBean);
    }

    // GET
    @GET
    @Path("")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<TestBean> getTests(@QueryParam("desc") boolean desc) {
        return this.testBusiness.getTests(desc);
    }

    // GET /id
    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public TestBean getTest(@PathParam("id") int id) {
        return this.testBusiness.getTest(id);
    }

    // PUT /id
    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void updateTest(@PathParam("id") int id, TestBean testBean) {
        testBean.setId(id);
        this.testBusiness.updateTest(testBean);
    }

    // DELETE /id
    @DELETE
    @Path("{id}")
    public void deleteTest(@PathParam("id") int id) {
        this.testBusiness.deleteTest(id);
    }

}
