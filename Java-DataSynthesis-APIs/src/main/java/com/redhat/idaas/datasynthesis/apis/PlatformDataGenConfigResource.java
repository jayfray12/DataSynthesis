package com.redhat.idaas.datasynthesis.apis;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.idaas.datasynthesis.models.PlatformDataGenConfigEntity;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/platformdatagenconfig")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlatformDataGenConfigResource {

    @GET
    @Path("all")
    public List<PlatformDataGenConfigEntity> get() {
        return PlatformDataGenConfigEntity.listAll();
    }

    @GET
    @Path("{status}")
    public List<PlatformDataGenConfigEntity> getByStatus(@PathParam Short status) {
        return PlatformDataGenConfigEntity.findByStatusId(status);
    }
}
