package restful.project.mozaik_back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import restful.project.mozaik_back_end.entity.Mustahik;

import java.util.List;
import java.util.Optional;

public interface MustahikRepository extends JpaRepository<Mustahik, String> {

    @Query("SELECT m FROM Mustahik m")
    List<Mustahik> findAllMustahik();


    Optional<Mustahik> findByIdMustahik(String idMustahik);

    Optional<Mustahik> findFirstByIdMustahik(String idMustahik);

    List<Mustahik> findByNamaLengkapContainingIgnoreCaseOrAlamatContainingIgnoreCaseOrKeteranganIgnoreCase(String namaLengkap, String alamat, String keterangan);
}
