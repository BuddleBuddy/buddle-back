package buddle.buddlebuddy.user;

import buddle.buddlebuddy.basket.Basket;
import buddle.buddlebuddy.like.Likes;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long idx;
    private String name;
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Basket> basketList;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Likes> likesList;

}
