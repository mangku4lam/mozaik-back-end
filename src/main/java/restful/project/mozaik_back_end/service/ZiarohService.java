package restful.project.mozaik_back_end.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restful.project.mozaik_back_end.entity.Ziaroh;
import restful.project.mozaik_back_end.repository.ZiarohRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ZiarohService {
    @Autowired
    private ZiarohRepository ziarohRepository;

    public List<Ziaroh> getAllZiaroh() {
        return ziarohRepository.findAll();
    }

    public Optional<Ziaroh> getZiarohById(Long id) {
        return ziarohRepository.findById(id);
    }

    public Ziaroh createZiaroh(Ziaroh ziaroh) {
        return ziarohRepository.save(ziaroh);
    }

    public Ziaroh updateZiaroh(Long id, Ziaroh updatedZiaroh) {
        return ziarohRepository.findById(id).map(ziaroh -> {
            ziaroh.setNamaTempat(updatedZiaroh.getNamaTempat());
            ziaroh.setAlamat(updatedZiaroh.getAlamat());
            ziaroh.setLatitude(updatedZiaroh.getLatitude());
            ziaroh.setLongitude(updatedZiaroh.getLongitude());
            ziaroh.setDeskripsi(updatedZiaroh.getDeskripsi());
            ziaroh.setIdVideo(updatedZiaroh.getIdVideo());
            ziaroh.setPhoto1(updatedZiaroh.getPhoto1());
            ziaroh.setPhoto2(updatedZiaroh.getPhoto3());
            ziaroh.setPhoto3(updatedZiaroh.getPhoto3());
            ziaroh.setPhoto4(updatedZiaroh.getPhoto4());
            ziaroh.setPhoto5(updatedZiaroh.getPhoto5());
            return ziarohRepository.save(ziaroh);
        }).orElseThrow(() -> new RuntimeException("Ziaroh not found"));
    }

    public void deleteZiaroh(Long id) {
        ziarohRepository.deleteById(id);
    }
}


