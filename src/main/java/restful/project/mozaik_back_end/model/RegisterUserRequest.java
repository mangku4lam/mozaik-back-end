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
public class RegisterUserRequest {

    @NotBlank
    @Size(max = 100)
    private String namaLengkap;

    @NotBlank
    @Size(max = 100)
    private String namaIbu;

    @NotBlank
    @Size(max = 100)
    private String noStambuk;

    @NotBlank
    @Size(max = 100)
    private String password;


    @Builder.Default
    @NotBlank
    @Size(max = 20)
    private String kategoriUser = "biasa";  // Default value if not provided

    @Builder.Default
    @NotBlank
    @Size(max = 20)
    private String label = "mahasantri";
}