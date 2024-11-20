package restful.project.mozaik_back_end.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restful.project.mozaik_back_end.entity.Notifikasi;
import restful.project.mozaik_back_end.entity.User;
import restful.project.mozaik_back_end.model.CreateNotifikasiRequest;
import restful.project.mozaik_back_end.model.NotifikasiResponse;
import restful.project.mozaik_back_end.repository.NotifikasiRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotifikasiService {

    @Autowired
    private NotifikasiRepository notifikasiRepository;

    @Autowired
    private ValidationService validationService;


    @Transactional
    public NotifikasiResponse createNotifikasi(User user, CreateNotifikasiRequest request) {
        validationService.validate(request);

        Notifikasi notifikasi = new Notifikasi();
        notifikasi.setNoStambuk(request.getNoStambuk());
        notifikasi.setNamaLengkap(request.getNamaLengkap());
        notifikasi.setIsiNotifikasi(request.getIsiNotifikasi());
        notifikasi.setLabel(request.getLabel());
        notifikasi.setTanggal(LocalDateTime.now());
        notifikasi.setTerbaca(false);
        notifikasiRepository.save(notifikasi);

        return toNotifikasiResponse(notifikasi);

    }

    private NotifikasiResponse toNotifikasiResponse(Notifikasi notifikasi) {
        return NotifikasiResponse.builder()
                .idNotifikasi(notifikasi.getIdNotifikasi())
                .noStambuk(notifikasi.getNoStambuk())
                .namaLengkap(notifikasi.getNamaLengkap())
                .isiNotifikasi(notifikasi.getIsiNotifikasi())
                .label(notifikasi.getLabel())
                .tanggal(String.valueOf(notifikasi.getTanggal()))
                .build();
    }


    public List<Notifikasi> getAllNotifikasi() {
        return notifikasiRepository.findAll(); // Kembalikan list langsung
    }

    // Misalnya Anda memiliki DTO untuk notifikasi
    public List<NotifikasiResponse> getAllNotifikasiResponse() {
        return notifikasiRepository.findAll().stream()
                .map(this::toNotifikasiResponse)
                .collect(Collectors.toList());
    }

    public void deleteNotifikasi(User user, Integer idNotifikasi) {
        notifikasiRepository.deleteById(Long.valueOf(idNotifikasi));
    }

    public Notifikasi markAsRead(Long idNotifikasi) {
        Notifikasi notifikasi = notifikasiRepository.findById(idNotifikasi)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notifikasi.setTerbaca(true);
        return notifikasiRepository.save(notifikasi);
    }


}
