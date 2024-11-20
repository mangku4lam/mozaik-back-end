package restful.project.mozaik_back_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restful.project.mozaik_back_end.entity.Mahasantri;
import restful.project.mozaik_back_end.entity.User;
import restful.project.mozaik_back_end.model.CreateMahasantriRequest;
import restful.project.mozaik_back_end.model.MahasantriResponse;
import restful.project.mozaik_back_end.model.UpdateMahasantriRequest;
import restful.project.mozaik_back_end.model.WebResponse;
import restful.project.mozaik_back_end.repository.MahasantriRepository;
import restful.project.mozaik_back_end.service.MahasantriService;

import java.util.List;

@RestController
public class MahasantriController {

    @Autowired
    private MahasantriService mahasantriService;

    @Autowired
    private MahasantriRepository mahasantriRepository;

    @PostMapping(
            path = "/api/mahasantri",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MahasantriResponse> create(User user, @RequestBody CreateMahasantriRequest request){
        MahasantriResponse mahasantriResponse = mahasantriService.create(user, request);
        return  WebResponse.<MahasantriResponse>builder().data(mahasantriResponse).build();
    }

    @GetMapping(
            path = "/api/mahasantri/{noStambuk}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public  WebResponse<MahasantriResponse> get(User user, @PathVariable("noStambuk") String noStambuk) {
        MahasantriResponse mahasantriResponse = mahasantriService.get(user, noStambuk);
        return  WebResponse.<MahasantriResponse>builder().data(mahasantriResponse).build();
    }

    @PutMapping(
            path =  "/api/mahasantri/{noStambuk}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public  WebResponse<MahasantriResponse> update(User user,
                                                   @RequestBody UpdateMahasantriRequest request,
                                                   @PathVariable("noStambuk") String noStambuk
                                                   ){
        request.setNoStambuk(noStambuk);

        MahasantriResponse mahasantriResponse = mahasantriService.update(user, request);
        return  WebResponse.<MahasantriResponse>builder().data(mahasantriResponse).build();
    }

    @DeleteMapping(
            path = "/api/mahasantri/{noStambuk}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public  WebResponse<String> delete(User user, @PathVariable("noStambuk") String noStambuk) {
        mahasantriService.delete(user, noStambuk);
        return  WebResponse.<String>builder().data("OK").build();
    }

    // Endpoint untuk mencari Mahasantri berdasarkan query
    @GetMapping("api/mahasantri/search")
    public WebResponse<List<Mahasantri>> searchMahasantri(@RequestParam String query) {
        List<Mahasantri> mahasantriList = mahasantriService.searchMahasantri(query);
        return WebResponse.<List<Mahasantri>>builder().data(mahasantriList).build();
    }

    // Endpoint untuk mendapatkan semua Siswa
    @GetMapping(path = "/api/mahasantri",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<List<Mahasantri>> getAllSiswa() {
        List<Mahasantri> mahasantriList = mahasantriService.getAllSiswa();
        return WebResponse.<List<Mahasantri>>builder().data(mahasantriList).build();
    }
}