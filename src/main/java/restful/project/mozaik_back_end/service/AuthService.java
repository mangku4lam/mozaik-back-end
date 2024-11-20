package restful.project.mozaik_back_end.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import restful.project.mozaik_back_end.entity.User;
import restful.project.mozaik_back_end.model.LoginUserRequest;
import restful.project.mozaik_back_end.model.TokenResponse;
import restful.project.mozaik_back_end.repository.UserRepository;
import restful.project.mozaik_back_end.security.BCrypt;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public TokenResponse login(LoginUserRequest request) {
        validationService.validate(request);

        User user = userRepository.findById(request.getNoStambuk())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No stambuk atau password salah"));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            user.setToken(UUID.randomUUID().toString());
            userRepository.save(user);

            return TokenResponse.builder()
                    .token(user.getToken())
                    .build();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No stambuk atau password salah");
        }
    }

    @Transactional
    public void logout(User user) {
        user.setToken(null);
        userRepository.save(user);
    }
}


