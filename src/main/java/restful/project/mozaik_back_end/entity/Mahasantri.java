package restful.project.mozaik_back_end.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Mahasantri {

    @Id
    @Column(name = "no_stambuk")
    private String noStambuk;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "nama_ibu")
    private String namaIbu;

    private String bagian;

    private String alamat;

    private String latitude;

    private String longitude;

    private String khidmah;

    @Column(name = "no_wa")
    private String noWa;

    private String status;

    private String quotes;

    @Column(name = "link_photo")
    private  String linkPhoto;
}
