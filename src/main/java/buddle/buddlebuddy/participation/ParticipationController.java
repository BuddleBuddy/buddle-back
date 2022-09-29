package buddle.buddlebuddy.participation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ParticipationController {
    private final ParticipationService participationService;

    // 참여자 횟수 증가
    @PostMapping("/participation")
    public ResponseEntity<String> createParticipation(){
        participationService.createParticipation();
        return new ResponseEntity<>("참여자 횟수 증가 완료", HttpStatus.OK);
    }

    // 참여자 조회
    @GetMapping("/part")
    public ResponseEntity<Long> getParticipation(){
        Long participation = participationService.getParticipation();
        return new ResponseEntity<>(participationService.getParticipation(), HttpStatus.OK);
    }
}
