package com.garanti.endpoints;

import com.garanti.model.Ogretmen;
import com.garanti.repo.OgretmenRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "/ogretmen")
public class OgretmenEndpoints {

    private OgretmenRepo repo;

    public OgretmenEndpoints() {
        this.repo = new OgretmenRepo();
    }

    //getAll
    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ogretmen> getAll() {
        // localhost:9090/FirstRestfulService/ogretmen/getAll
        return repo.getAll();
    }

    //getById
    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdQueryParam(@QueryParam(value = "id") Integer id) {
        // localhost:9090/FirstRestfulService/ogretmen/getById?id=1
        return repo.getById(id);
    }

    @GET
    @Path(value = "/getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    //web servisin dışarıya vereceği türü belirtir --> Produces
    public Ogretmen getByIdPathParam(@PathParam(value = "id") Integer id) {
        // localhost:9090/FirstRestfulService/ogretmen/getById/1
        return repo.getById(id);
    }

    //save
    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ogretmen ogretmen) {
        // localhost:9090/FirstRestfulService/ogretmen/save
        repo.save(ogretmen);
        return "Başarı ile kaydedildi";
    }

    //delete
    @DELETE
    @Path(value = "deleteById/{id}")
    public String deleteById(@PathParam(value = "id") Integer id) {
        // localhost:9090/FirstRestfulService/ogretmen/deleteById/1
        if (repo.deleteById(id)) {
            return "Başarı ile silindi.";
        } else {
            return "Başarı ile silinemedi.";
        }
    }

    //header
    @GET
    @Path(value = "getByIdHeader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdHeader(@HeaderParam(value = "id") Integer id) {
        return repo.getById(id);
    }
}
