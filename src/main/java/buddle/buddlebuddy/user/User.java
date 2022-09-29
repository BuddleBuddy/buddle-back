package buddle.buddlebuddy.user;


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


//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;
//
//    public User(String name, String email, Role role) {
//        this.name = name;
//        this.email = email;
//        this.role = role;
//    }
//
//    public String getRoleKey() {
//        return this.role.getKey();
//    }
//
//    public User update(String name) {
//        this.name = name;
//        return this;
//    }
}
