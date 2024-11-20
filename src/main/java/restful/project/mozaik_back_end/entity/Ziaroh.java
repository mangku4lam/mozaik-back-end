package restful.project.mozaik_back_end.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ziaroh")
public class Ziaroh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_tempat", nullable = false)
    private String namaTempat;

    private String alamat;


    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @Column(nullable = false)
    private String deskripsi;

    @Column(name = "id_video")
    private String idVideo;

    private String photo1;

    private String photo2;

    private String photo3;

    private String photo4;

    private String photo5;

}
