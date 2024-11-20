package restful.project.mozaik_back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import restful.project.mozaik_back_end.entity.Mahasantri;

import java.util.List;
import java.util.Optional;

public interface MahasantriRepository extends JpaRepository<Mahasantri, String> {
    @Query("SELECT m FROM Mahasantri m")

    List<Mahasantri> findAllMahasantri();


    Optional<Mahasantri> findByNoStambuk(String noStambuk);

    Optional<Mahasantri> findFirstByNoStambuk(String noStambuk);

    List<Mahasantri> findByNamaLengkapContainingIgnoreCaseOrAlamatContainingIgnoreCaseOrBagianContainingIgnoreCase(String namaLengkap, String alamat, String bagian);

}
