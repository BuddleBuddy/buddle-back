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
    private Long userIdx;
    private String url;

    public BasketDto(Basket basket){
        this.idx = basket.getIdx();
        this.title = basket.getTitle();
        this.userIdx = basket.getUserIdx().getIdx();
        this.url = basket.getUrl();
    }


}
