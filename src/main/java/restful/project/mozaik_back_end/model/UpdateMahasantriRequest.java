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
public class UpdateMahasantriRequest {

    @JsonIgnore
    @NotBlank
    private String noStambuk;

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

}
