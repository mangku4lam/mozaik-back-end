package restful.project.mozaik_back_end.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import restful.project.mozaik_back_end.entity.Mustahik;
import restful.project.mozaik_back_end.entity.User;
import restful.project.mozaik_back_end.model.*;
import restful.project.mozaik_back_end.repository.MustahikRepository;

import java.util.List;

@Service
public class MustahikService {

    @Autowired
    private MustahikRepository mustahikRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public MustahikResponse create(User user, CreateMustahikRequest request) {
        validationService.validate(request);

        Mustahik mustahik = new Mustahik();
        mustahik.setIdMustahik(request.getIdMustahik());
        mustahik.setNamaLengkap(request.getNamaLengkap());
        mustahik.setTanggalLahir(request.getTanggalLahir());
        mustahik.setAlamat(request.getAlamat());
        mustahik.setLatitude(request.getLatitude());
        mustahik.setLongitude(request.getLongitude());
        mustahik.setNoWa(request.getNoWa());
        mustahik.setSosmed(request.getSosmed());
        mustahik.setKesan(request.getKesan());
        mustahik.setKeterangan(request.getKeterangan());
        mustahik.setLinkPhoto(request.getLinkPhoto());

        mustahikRepository.save(mustahik);

        return  toMustahikResponse(mustahik);
    }

    private MustahikResponse toMustahikResponse(Mustahik mustahik) {
        return MustahikResponse.builder()
                .idMustahik(mustahik.getIdMustahik())
                .namaLengkap(mustahik.getNamaLengkap())
                .tanggalLahir(mustahik.getTanggalLahir())
                .alamat(mustahik.getAlamat())
                .latitude(mustahik.getLatitude())
                .longitude(mustahik.getLongitude())
                .noWa(mustahik.getNoWa())
                .sosmed(mustahik.getSosmed())
                .kesan(mustahik.getKesan())
                .keteranagan(mustahik.getKeterangan())
                .linkPhoto(mustahik.getLinkPhoto())
                .build();
    }

    @Transactional
    public MustahikResponse get(User user, String idMustahik) {
        Mustahik mustahik = mustahikRepository.findById(idMustahik)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Mustahik tidak ditemukan"));

        return  toMustahikResponse(mustahik);
    }

    public MustahikResponse update(User user, UpdateMustahikRequest request) {
        validationService.validate(request);

        Mustahik mustahik = mustahikRepository.findFirstByIdMustahik(request.getIdMustahik())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mustahik not found"));

        mustahik.setNamaLengkap(request.getNamaLengkap());
        mustahik.setAlamat(request.getAlamat());
        mustahik.setLatitude(request.getLatitude());
        mustahik.setLongitude(request.getLongitude());
        mustahik.setNoWa(request.getNoWa());
        mustahik.setSosmed(request.getSosmed());
        mustahik.setKeterangan(request.getKeterangan());

        mustahikRepository.save(mustahik);

        return  toMustahikResponse(mustahik);
    }

    public  void delete(User user, String idMustahik) {
         Mustahik mustahik = mustahikRepository.findFirstByIdMustahik(idMustahik)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mustahik not found"));

        mustahikRepository.delete(mustahik);

    }

    @Transactional
    public List<Mustahik> searchMustahik(String query) {
        return mustahikRepository.findByNamaLengkapContainingIgnoreCaseOrAlamatContainingIgnoreCaseOrKeteranganIgnoreCase(query, query, query);
    }

    // Metode untuk mendapatkan semua Siswa
    public List<Mustahik> getAllMustahik() {
        return mustahikRepository.findAll();
    }


}
