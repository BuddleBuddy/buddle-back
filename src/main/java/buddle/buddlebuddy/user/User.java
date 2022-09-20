package buddle.buddlebuddy.user;

import buddle.buddlebuddy.basket.Basket;
import buddle.buddlebuddy.likes.Likes;
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
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Basket> basketList;

    @OneToMany(mappedBy = "likeUser", fetch = FetchType.LAZY)
    private List<Likes> likesList;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public User(String name, String email, Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public User update(String name) {
        this.name = name;
        return this;
    }
}
