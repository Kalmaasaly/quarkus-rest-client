package com.sirpe.resources;

import com.sirpe.model.TvSeries;
import com.sirpe.proxies.TVSeriesProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/tvseries")
public class TVSeriesResource {

    @RestClient
    private TVSeriesProxy proxy;
    private List<TvSeries> series=new ArrayList();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("title") String title){
        TvSeries tvSeries= proxy.get(title);
        series.add(tvSeries);
        return Response.ok(series).build();
    }
}
