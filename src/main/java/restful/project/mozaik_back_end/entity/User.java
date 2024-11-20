package restful.project.mozaik_back_end.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "no_stambuk")
    private String noStambuk;

    private String password;

    @Column(name = "nama_ibu")
    private String namaIbu;

    private String namaLengkap;

    @Column(name = "kategori_user")
    private String kategoriUser;

    private String label;

    private String token;

}