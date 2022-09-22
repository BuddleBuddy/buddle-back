package buddle.buddlebuddy.likes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikesDto {

    private Long userIdx;
    private Long animalIdx;
    private boolean isLike;

}
