package restful.project.mozaik_back_end.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notifikasi")
public class Notifikasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotifikasi;

    @Column(name = "no_stambuk")
    private String noStambuk;

    @Column(name = "nama_lengkap", nullable = false)
    private String namaLengkap;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "isi_notifikasi", nullable = false)
    private String isiNotifikasi;

    @Column(name = "tanggal", nullable = false)
    private LocalDateTime tanggal;

    private boolean terbaca = false;

}
