package buddle.buddlebuddy.like;

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
    private Long idx;

    @ManyToOne
    private User likeUser;
    @ManyToOne
    private Basket basket;
}
