package buddle.buddlebuddy.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long saveUser(SaveUserReq saveUserReq) {
        Optional<Long> findUser = userRepository.findByEmail(saveUserReq.getEmail());

        if (!findUser.isEmpty()) {
            return -1L;
        }
        else{
            User user = new User(saveUserReq.getName(), saveUserReq.getEmail());
            User savedUser = userRepository.save(user);
            return savedUser.getIdx();
        }
    }
}
