package buddle.buddlebuddy.user;

import buddle.buddlebuddy.basket.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Basket, Long> {
}
