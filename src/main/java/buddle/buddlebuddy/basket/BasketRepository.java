package buddle.buddlebuddy.basket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query(value = "SELECT b.title AS title, b.url AS url, count(l.idx) AS countLike FROM Basket b JOIN b.likesList l GROUP BY l.basket")
    List<BasketListResponseInterface> findBasketListResponseInterfaceUsingInterfaceWithNative();

    @Query(value = "SELECT b.title AS title, b.url AS url, count(l.idx) AS countLike FROM Basket b JOIN b.likesList l WHERE b.user.idx = :userIdx GROUP BY l.basket")
    List<BasketListResponseInterface> findBasketListResponseInterfaceUsingInterfaceWithNative(Long userIdx);

    void deleteByIdx(Long idx);
}
