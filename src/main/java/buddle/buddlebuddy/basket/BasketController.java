package buddle.buddlebuddy.basket;

import buddle.buddlebuddy.basket.request.PostBasketReq;
import buddle.buddlebuddy.basket.response.GetAllBasketRes;
import buddle.buddlebuddy.basket.response.GetCountRes;
import buddle.buddlebuddy.common.exception.NotFoundException;
import buddle.buddlebuddy.common.utils.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BasketController {
    private final S3Uploader s3Uploader;
    private final BasketService basketService;

    // 이미지 저장
    @PostMapping("/img")
    public ResponseEntity<BasketDto> uploadBasket(PostBasketReq postBasketReq) {
        Basket basket = basketService.insertBasket(postBasketReq, 1L)
                .orElseThrow(() -> new NotFoundException("찾지 못했습니다."));

        return new ResponseEntity<>(new BasketDto(basket), HttpStatus.OK);
    }


    // 모든 장바구니 조회
    @GetMapping("/img")
    public ResponseEntity<GetAllBasketRes> allBasket() {
        List<GetAllBasketRes> getAllBasketRes = basketService.allBasket();
        return new ResponseEntity<>(new GetAllBasketRes(getAllBasketRes), HttpStatus.OK);
    }


    // 참가자 현황
    @GetMapping("/count")
    public ResponseEntity<GetCountRes> countBasket() {
        Long cnt = basketService.countBasketUserId();
        return new ResponseEntity<>(new GetCountRes(cnt), HttpStatus.OK);
    }


}
