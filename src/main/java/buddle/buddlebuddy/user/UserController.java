package buddle.buddlebuddy.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/join")
    public ResponseEntity<SaveUserRes> saveUser(@RequestBody SaveUserReq saveUserReq){

        Long idx = userService.saveUser(saveUserReq);
        if (idx == -1L) {
            return new ResponseEntity<>(new SaveUserRes(idx, "중복된 이메일입니다."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new SaveUserRes(idx, "유저 저장 성공"), HttpStatus.OK);
        }
    }


}
