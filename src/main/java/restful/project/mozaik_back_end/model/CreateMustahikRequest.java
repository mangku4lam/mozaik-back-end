package restful.project.mozaik_back_end.model;

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
public class CreateMustahikRequest {

    @NotBlank
    @Size(max = 100)
    private String idMustahik;

    @NotBlank
    @Size(max = 100)
    private String namaLengkap;

    @NotBlank
    @Size(max = 100)
    private String tanggalLahir;

    @NotBlank
    @Size(max = 100)
    private String alamat;

    @NotBlank
    @Size(max = 100)
    private String latitude;

    @NotBlank
    @Size(max = 100)
    private String longitude;

    private String noWa;

    private String sosmed;

    private String kesan;

    @Size(max = 100)
    private String keterangan;


    private String linkPhoto;

}

