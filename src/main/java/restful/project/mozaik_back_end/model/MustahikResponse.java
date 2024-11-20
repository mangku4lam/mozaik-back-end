package restful.project.mozaik_back_end.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MustahikResponse {

    private String idMustahik;

    private String namaLengkap;

    private String tanggalLahir;

    private String alamat;

    private String latitude;

    private String longitude;

    private String noWa;

    private  String sosmed;

    private String kesan;

    private String keteranagan;

    private String linkPhoto;
}
