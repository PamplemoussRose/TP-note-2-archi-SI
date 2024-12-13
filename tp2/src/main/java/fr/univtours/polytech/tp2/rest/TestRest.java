package fr.univtours.polytech.tp2.rest;

import java.util.List;

import fr.univtours.polytech.tp2.business.TestBusiness;
import fr.univtours.polytech.tp2.model.TestBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
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

    // ---------- POST ----------
    @POST
    @Path("")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void addTest(TestBean testBean) {
        this.testBusiness.addTest(testBean);
    }

    // ---------- GET ----------
    // GET /
    @GET
    @Path("")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<TestBean> getTests(@QueryParam("desc") boolean desc, @QueryParam("note") String note) {
        return this.testBusiness.getTests(desc, note);
    }

    // GET /id
    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public TestBean getTest(@PathParam("id") int id) {
        return this.testBusiness.getTest(id);
    }

    // ---------- PUT ----------
    // PUT /id
    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void updateTest(@PathParam("id") int id, TestBean testBean) {
        testBean.setId(id);
        this.testBusiness.updateTest(testBean);
    }

    // ---------- PATCH ----------
    // PATCH /id
    @PATCH
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void patchTest(@PathParam("id") int id, TestBean testBean) {
        TestBean bean = this.testBusiness.getTest(id);
        if (testBean.getNote() != null) {
            bean.setNote(testBean.getNote());
        } else if (testBean.getTitle() != null) {
            bean.setTitle(testBean.getTitle());
        } else if (testBean.getActeur() != null) {
            bean.setActeur(testBean.getActeur());
        } else if (testBean.getSortie() != null) {
            bean.setSortie(testBean.getSortie());
        } else if (testBean.getImage() != null) {
            bean.setImage(testBean.getImage());
        }
        this.testBusiness.updateTest(bean);
    }

    // ---------- DELETE ----------
    // DELETE /id
    @DELETE
    @Path("{id}")
    public void deleteTest(@PathParam("id") int id) {
        this.testBusiness.deleteTest(id);
    }

}
