package buddle.buddlebuddy.likes;

import buddle.buddlebuddy.basket.Basket;
import buddle.buddlebuddy.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

    Optional<Likes> findByLikeUserAndBasket(User likeUser, Basket basket);

}
