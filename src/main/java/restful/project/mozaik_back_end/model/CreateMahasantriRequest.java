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
public class CreateMahasantriRequest {

    @NotBlank
    @Size(max = 100)
    private String noStambuk;

    @NotBlank
    @Size(max = 100)
    private String namaLengkap;

    @NotBlank
    @Size(max = 100)
    private String namaIbu;

    @NotBlank
    @Size(max = 100)
    private String bagian;

    @NotBlank
    @Size(max = 100)
    private String alamat;

    @NotBlank
    @Size(max = 100)
    private String latitude;

    @NotBlank
    @Size(max = 100)
    private String longitude;

    private String khidmah;

    private String noWa;

    private String status;

    private String quotes;

    private String linkPhoto;

}
