package restful.project.mozaik_back_end.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import restful.project.mozaik_back_end.entity.Mahasantri;
import restful.project.mozaik_back_end.entity.User;
import restful.project.mozaik_back_end.model.RegisterUserRequest;
import restful.project.mozaik_back_end.model.UpdateUserRequest;
import restful.project.mozaik_back_end.model.UserResponse;
import restful.project.mozaik_back_end.model.WebResponse;
import restful.project.mozaik_back_end.repository.MahasantriRepository;
import restful.project.mozaik_back_end.repository.UserRepository;
import restful.project.mozaik_back_end.security.BCrypt;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MahasantriRepository mahasantriRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void register(RegisterUserRequest request) {
        validationService.validate(request);
        log.info("REQUEST : {}", request);

        if (userRepository.existsById(request.getNoStambuk())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        // Ambil data profil berdasarkan noStambuk
        Optional<Mahasantri> profilOptional = mahasantriRepository.findById(request.getNoStambuk());

        // Jika noStambuk tidak ada di tabel profil, kembalikan error
        if (profilOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "NoStambuk not found in Profil table");
        }

        Mahasantri profilMahasantri = profilOptional.get();

        // Jika namaIbu tidak cocok dengan data di tabel profil, kembalikan error
        if (!profilMahasantri.getNamaIbu().equals(request.getNamaIbu())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nama Ibu does not match the registered profile");
        }

        User user = new User();
        user.setNamaLengkap(request.getNamaLengkap());
        user.setNamaIbu(request.getNamaIbu());
        user.setNoStambuk(request.getNoStambuk());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setKategoriUser(request.getKategoriUser());
        user.setLabel(request.getLabel());


        userRepository.save(user);

        log.info("USER : {}", user.getNamaLengkap());


    }

    public UserResponse get(User user) {
        return UserResponse.builder()
                .noStambuk(user.getNoStambuk())
                .namaLengkap(user.getNamaLengkap())
                .kategoriUser(user.getKategoriUser())
                .label(user.getLabel())
                .token(user.getToken())
                .build();
    }

    @Transactional
    public UserResponse update(User user, UpdateUserRequest request) {
        validationService.validate(request);

        log.info("REQUEST : {}", request);

        if (Objects.nonNull(request.getNamaLengkap())) {
            user.setNamaLengkap(request.getNamaLengkap());
        }

        if (Objects.nonNull(request.getPassword())) {
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }

        userRepository.save(user);

        log.info("USER : {}", user.getNamaLengkap());

        return UserResponse.builder()
                .noStambuk(user.getNoStambuk())
                .namaLengkap(user.getNamaLengkap())
                .kategoriUser(user.getKategoriUser())
                .label(user.getLabel())
                .build();
    }

}