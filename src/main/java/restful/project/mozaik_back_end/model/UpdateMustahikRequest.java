package restful.project.mozaik_back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateMustahikRequest {

    @JsonIgnore
    @NotBlank
    private String idMustahik;

    private String namaLengkap;

    @Size(max = 100)
    private String alamat;

    @Size(max = 100)
    private String latitude;

    @Size(max = 100)
    private String longitude;

    private String sosmed;

    private String noWa;

    private String keterangan;


}
