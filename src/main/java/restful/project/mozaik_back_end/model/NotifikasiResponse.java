package restful.project.mozaik_back_end.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotifikasiResponse {

    private Integer idNotifikasi;

    private String noStambuk;

    private String namaLengkap;

    private String isiNotifikasi;

    private String label;

    private String tanggal;

    private boolean isRead;

}
