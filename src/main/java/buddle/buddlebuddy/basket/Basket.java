package buddle.buddlebuddy.basket;

import buddle.buddlebuddy.like.Likes;
import buddle.buddlebuddy.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private Long idx;

    private String title;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Likes> likesList;
}
