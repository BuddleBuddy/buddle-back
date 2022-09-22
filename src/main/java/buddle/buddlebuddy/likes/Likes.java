package buddle.buddlebuddy.likes;

import buddle.buddlebuddy.basket.Basket;
import buddle.buddlebuddy.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User likeUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public void modifyUserAndBasket(User likeUser, Basket basket) {
        this.likeUser = likeUser;
        this.basket = basket;
        likeUser.getLikesList().add(this);
        basket.getLikesList().add(this);
    }
}
