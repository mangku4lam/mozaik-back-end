package restful.project.mozaik_back_end.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import restful.project.mozaik_back_end.entity.Mahasantri;
import restful.project.mozaik_back_end.entity.User;
import restful.project.mozaik_back_end.model.*;
import restful.project.mozaik_back_end.repository.MahasantriRepository;

import java.util.List;

@Service
public class MahasantriService {

    @Autowired
    private MahasantriRepository mahasantriRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public MahasantriResponse create(User user, CreateMahasantriRequest request) {
        validationService.validate(request);

        Mahasantri mahasantri = new Mahasantri();
        mahasantri.setNoStambuk(request.getNoStambuk());
        mahasantri.setNamaLengkap(request.getNamaLengkap());
        mahasantri.setNamaIbu(request.getNamaIbu());
        mahasantri.setBagian(request.getBagian());
        mahasantri.setAlamat(request.getAlamat());
        mahasantri.setLatitude(request.getLatitude());
        mahasantri.setLongitude(request.getLongitude());
        mahasantri.setKhidmah(request.getKhidmah());
        mahasantri.setNoWa(request.getNoWa());
        mahasantri.setStatus(request.getStatus());
        mahasantri.setQuotes(request.getQuotes());
        mahasantri.setLinkPhoto(request.getLinkPhoto());

        mahasantriRepository.save(mahasantri);

        return  toMahasantriResponse(mahasantri);
    }

    private MahasantriResponse toMahasantriResponse(Mahasantri mahasantri) {
        return MahasantriResponse.builder()
                .noStambuk(mahasantri.getNoStambuk())
                .namaLengkap(mahasantri.getNamaLengkap())
                .bagian(mahasantri.getBagian())
                .alamat(mahasantri.getAlamat())
                .latitude(mahasantri.getLatitude())
                .longitude(mahasantri.getLongitude())
                .khidmah(mahasantri.getKhidmah())
                .noWa(mahasantri.getNoWa())
                .status(mahasantri.getStatus())
                .quotes(mahasantri.getQuotes())
                .linkPhoto(mahasantri.getLinkPhoto())
                .build();
    }

    @Transactional
    public MahasantriResponse get(User user, String noStambuk) {
        Mahasantri mahasantri = mahasantriRepository.findById(noStambuk)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Mahasantr tidak ditemukan"));

        return  toMahasantriResponse(mahasantri);
    }

    public MahasantriResponse update(User user, UpdateMahasantriRequest request) {
        validationService.validate(request);

        Mahasantri mahasantri = mahasantriRepository.findFirstByNoStambuk(request.getNoStambuk())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mahasantri not found"));

        mahasantri.setAlamat(request.getAlamat());
        mahasantri.setLatitude(request.getLatitude());
        mahasantri.setLongitude(request.getLongitude());
        mahasantri.setKhidmah(request.getKhidmah());
        mahasantri.setStatus(request.getStatus());

        mahasantriRepository.save(mahasantri);

        return  toMahasantriResponse(mahasantri);
    }

    public  void delete(User user, String noStambuk) {
        Mahasantri mahasantri = mahasantriRepository.findFirstByNoStambuk(noStambuk)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mahasantri not found"));

        mahasantriRepository.delete(mahasantri);

    }

   @Transactional
    public List<Mahasantri> searchMahasantri(String query) {
        return mahasantriRepository.findByNamaLengkapContainingIgnoreCaseOrAlamatContainingIgnoreCaseOrBagianContainingIgnoreCase(query, query, query);
    }

    // Metode untuk mendapatkan semua Siswa
    public List<Mahasantri> getAllSiswa() {
        return mahasantriRepository.findAll();
    }


}
