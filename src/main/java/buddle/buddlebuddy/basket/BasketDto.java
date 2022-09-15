package buddle.buddlebuddy.basket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BasketDto {
    private Long idx;
    private String title;
    private String imageUrl;
    private Long userIdx;

    public BasketDto(Basket basket){
        this.idx = basket.getIdx();
        this.title = basket.getTitle();
        this.imageUrl = basket.getImageUrl();
        this.userIdx = basket.getUserIdx().getIdx();
    }

}
