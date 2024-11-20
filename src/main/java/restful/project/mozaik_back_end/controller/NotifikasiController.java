package restful.project.mozaik_back_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restful.project.mozaik_back_end.entity.Notifikasi;
import restful.project.mozaik_back_end.entity.User;
import restful.project.mozaik_back_end.model.CreateNotifikasiRequest;
import restful.project.mozaik_back_end.model.NotifikasiResponse;
import restful.project.mozaik_back_end.model.WebResponse;
import restful.project.mozaik_back_end.service.NotifikasiService;

import java.util.List;

@RestController
public class NotifikasiController {

    @Autowired
    private NotifikasiService notifikasiService;

    @PostMapping(
            path = "/api/notifikasi",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<NotifikasiResponse> createNotifikasi(User user, @RequestBody CreateNotifikasiRequest request) {
        NotifikasiResponse notifikasiResponse = notifikasiService.createNotifikasi(user, request);
        return WebResponse.<NotifikasiResponse>builder().data(notifikasiResponse).build();
    }

    @GetMapping(
            path = "api/notifikasi",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<NotifikasiResponse>> getAllNotifikasi() {
        List<NotifikasiResponse> notifikasiList = notifikasiService.getAllNotifikasiResponse();
        return new ResponseEntity<>(notifikasiList, HttpStatus.OK);
    }

    @DeleteMapping("api/notifikasi/{idNotifikasi}")
    public ResponseEntity<Void> deleteNotifikasi(User user, @PathVariable Integer idNotifikasi) {
        notifikasiService.deleteNotifikasi(user, idNotifikasi);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("api/notifikasi/{idNotifikasi}/read")
    public ResponseEntity<Notifikasi> markNotificationAsRead(@PathVariable Long idNotifikasi) {
        Notifikasi updatedNotification = notifikasiService.markAsRead(idNotifikasi);
        return ResponseEntity.ok(updatedNotification);
    }
}

