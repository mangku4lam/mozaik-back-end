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
public class CreateNotifikasiRequest {

    private String noStambuk;

    @NotBlank
    @Size(max = 100)
    private String namaLengkap;

    @NotBlank
    private String isiNotifikasi;

    @NotBlank
    private  String label;

}
