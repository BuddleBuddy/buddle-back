package buddle.buddlebuddy.likes;

import buddle.buddlebuddy.basket.Basket;
import buddle.buddlebuddy.user.User;
import buddle.buddlebuddy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikesService {

    private final LikesRepository likesRepository;

    public LikesDto likeAnimal(User likeUser, Basket basket) {
        Optional<Likes> findLikes = likesRepository.findByLikeUserAndBasket(likeUser, basket);
        //System.out.println("findLikes.get().getIdx() = " + findLikes.get().getIdx());

        if(findLikes.isEmpty()){
            Likes newLike = new Likes();
            newLike.modifyUserAndBasket(likeUser, basket);
            likesRepository.save(newLike);
        }

        else{
            likesRepository.delete(findLikes.get());
        }

        return null;
    }
}
