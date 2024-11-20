package restful.project.mozaik_back_end.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Mustahik {

    @Id
    @Column(name = "id_mustahik")
    private String idMustahik;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "tanggal_lahir")
    private String tanggalLahir;

    private String alamat;

    private String latitude;

    private String longitude;

    @Column(name = "no_wa")
    private String noWa;

    private String sosmed;

    private String kesan;

    private String keterangan;

    @Column(name = "link_photo")
    private  String linkPhoto;
}