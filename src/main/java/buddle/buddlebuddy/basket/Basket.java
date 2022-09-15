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
    private Long idx;

    private String title;
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private User userIdx;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Likes> likesList;



}
