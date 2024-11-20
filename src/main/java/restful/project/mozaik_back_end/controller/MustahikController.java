package restful.project.mozaik_back_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restful.project.mozaik_back_end.entity.Mustahik;
import restful.project.mozaik_back_end.entity.User;
import restful.project.mozaik_back_end.model.*;
import restful.project.mozaik_back_end.repository.MustahikRepository;
import restful.project.mozaik_back_end.service.MustahikService;

import java.util.List;

@RestController
public class MustahikController {


    @Autowired
    private MustahikService mustahikService;

    @Autowired
    private MustahikRepository mustahikRepository;

    @PostMapping(
            path = "/api/mustahik",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MustahikResponse> create(User user, @RequestBody CreateMustahikRequest request) {
        MustahikResponse mustahikResponse = mustahikService.create(user, request);
        return WebResponse.<MustahikResponse>builder().data(mustahikResponse).build();
    }

    @GetMapping(
            path = "/api/mustahik/{idMustahik}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MustahikResponse> get(User user, @PathVariable("idMustahik") String idMustahik) {
        MustahikResponse mustahikResponse = mustahikService.get(user, idMustahik);
        return WebResponse.<MustahikResponse>builder().data(mustahikResponse).build();
    }

    @PutMapping(
            path = "/api/mustahik/{idMustahik}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MustahikResponse> update(User user,
                                                @RequestBody UpdateMustahikRequest request,
                                                @PathVariable("idMustahik") String idMustahik
    ) {
        request.setIdMustahik(idMustahik);

        MustahikResponse mustahikResponse = mustahikService.update(user, request);
        return WebResponse.<MustahikResponse>builder().data(mustahikResponse).build();
    }

    @DeleteMapping(
            path = "/api/mustahik/{idMustahik}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> delete(User user, @PathVariable("idMustahik") String idMustahik) {
        mustahikService.delete(user, idMustahik);
        return WebResponse.<String>builder().data("OK").build();
    }

    // Endpoint untuk mencari Mustahik berdasarkan query
    @GetMapping("api/mustahik/search")
    public WebResponse<List<Mustahik>> searchMustahik(@RequestParam String query) {
        List<Mustahik> mustahikList = mustahikService.searchMustahik(query);
        return WebResponse.<List<Mustahik>>builder().data(mustahikList).build();
    }

    // Endpoint untuk mendapatkan semua Mustahik
    @GetMapping(path = "/api/mustahik",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<List<Mustahik>> getAllMustahik() {
        List<Mustahik> mustahikList = mustahikService.getAllMustahik();
        return WebResponse.<List<Mustahik>>builder().data(mustahikList).build();
    }
}

