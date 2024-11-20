package restful.project.mozaik_back_end.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String noStambuk;

    private String namaLengkap;

    private String kategoriUser;

    private String label;

    private String token;
}
