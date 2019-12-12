package si.fri.prpo.nakupovalniseznami.priporocila.api.v1.viri;


import si.fri.prpo.nakupovalniseznami.priporocila.api.v1.dtos.Artikel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Path("priporocila")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PriporocilaVir {

    private Logger log = Logger.getLogger(PriporocilaVir.class.getName());

    private Map<Artikel, Integer> priporocila;

    @PostConstruct
    private void init() {
        priporocila = new HashMap<>();
        priporocila.put(new Artikel("Kajmak"), 2);
        priporocila.put(new Artikel("Marmelada"), 10);
    }

    @GET
    public Response pridobiPriporocila() {

        Map<Artikel, Integer> sorted = priporocila
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return Response.ok(sorted)
                .build();
    }

    @POST
    public Response dodajVnos(Artikel artikel) {
        if(!priporocila.containsKey(artikel)) {
            priporocila.put(artikel, 1);
        } else {
            priporocila.put(artikel, priporocila.get(artikel) + 1);
        }

        log.info("Artikel posodobljen. Nova vrednost: " + priporocila.get(artikel));

        return Response.ok().build();
    }
}
