package restful.project.mozaik_back_end.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.StringUtils;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MahasantriResponse {

    private String noStambuk;

    private String namaLengkap;

    private String bagian;

    private String alamat;

    private String latitude;

    private String longitude;

    private String khidmah;

    private String noWa;

    private String status;

    private String quotes;

    private String linkPhoto;
}
