package buddle.buddlebuddy.basket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query(value = "SELECT b.imageUrl, b.title, count(l.likeUser) FROM Basket b JOIN Likes l ON b.idx = l.basket.idx GROUP BY l.basket")
    List findAll();

}
