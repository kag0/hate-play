package controllers;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.inject.Inject;
import jdk.nashorn.internal.ir.annotations.Ignore;
import models.Item;
import models.Order;
import models.Pet;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;

import java.util.HashMap;
import java.util.Map;

public class ResourceController extends Controller {

    static {
        Json.mapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    private final JPAApi jpaApi;

    @Inject
    public ResourceController(JPAApi jpaApi){
        this.jpaApi = jpaApi;
    }

    public Result showPet(long id) {
        Pet pet = (Pet) jpaApi.withTransaction(em ->
                em.createQuery("SELECT e FROM Pet e WHERE e.id = :id")
                .setParameter("id", id)
                .getSingleResult());
        return ok(Json.toJson(pet.asEmbedded()));
    }

    public Result showOrder(long id) {
        Order order = (Order) jpaApi.withTransaction(em ->
                em.createQuery("SELECT e FROM Order e WHERE e.id = :id")
                .setParameter("id", id)
                .getSingleResult());
        return ok(Json.toJson(order.asEmbedded()));
    }

    public Result showItem(long id) {
        Item item = (Item) jpaApi.withTransaction(em ->
                em.createQuery("SELECT e FROM Item e WHERE e.id = :id")
                .setParameter("id", id)
                .getSingleResult());
        return ok(Json.toJson(item.asEmbedded()));
    }

}
