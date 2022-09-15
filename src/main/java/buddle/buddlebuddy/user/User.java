package buddle.buddlebuddy.user;

import buddle.buddlebuddy.basket.Basket;
import buddle.buddlebuddy.like.Likes;
import lombok.*;
import org.springframework.lang.Nullable;

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
    private Long idx;
    private String name;
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Basket> basketList;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Likes> likesList;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}
