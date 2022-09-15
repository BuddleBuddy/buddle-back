package buddle.buddlebuddy.basket.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class PostBasketReq {
    private String title;
    private MultipartFile img;
}
