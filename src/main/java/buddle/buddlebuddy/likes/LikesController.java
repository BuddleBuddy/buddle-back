package buddle.buddlebuddy.likes;

import buddle.buddlebuddy.basket.Basket;
import buddle.buddlebuddy.basket.BasketRepository;
import buddle.buddlebuddy.config.auth.SessionUser;
import buddle.buddlebuddy.user.User;
import buddle.buddlebuddy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;
    private final HttpSession httpSession;
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;

    @GetMapping("/user/like/{basket_id}")
    public ResponseEntity<LikesDto> likeBasket(@PathVariable("basket_id") Long basketIdx) {

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        Optional<User> findUser = userRepository.findByName(user.getName());
        Optional<Basket> findBasket = basketRepository.findById(basketIdx);
        likesService.likeAnimal(findUser.get(), findBasket.get());

        return null;


        /*return new ResponseEntity<>(new LikesDto())*/

    }
}
