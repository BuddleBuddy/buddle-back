package buddle.buddlebuddy.basket;

import buddle.buddlebuddy.basket.request.PostBasketReq;
import buddle.buddlebuddy.basket.response.GetAllBasketRes;
import buddle.buddlebuddy.common.utils.S3Uploader;
import buddle.buddlebuddy.user.User;
import buddle.buddlebuddy.user.UserRepository;
import com.amazonaws.services.kms.model.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BasketService {
    private final BasketRepository basketRepository;
    private final S3Uploader s3Uploader;
    private final UserRepository userRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository, S3Uploader s3Uploader, UserRepository userRepository) {
        this.basketRepository = basketRepository;
        this.s3Uploader = s3Uploader;
        this.userRepository = userRepository;
    }


    public Optional<Basket> insertBasket(PostBasketReq postBasketReq, Long userIdx){
        String imgName = saveFile(postBasketReq.getImg(), postBasketReq.getTitle(), userIdx);

//        User user = userRepository.findByUserId();
        User user = new User();
        user.setIdx(userIdx);

        return Optional.of(
              basketRepository.save(
                    Basket.builder()
                            .userIdx(user)
                            .title(postBasketReq.getTitle())
                            .imageUrl(postBasketReq.getImageUrl())
                            .build()
              )
        );
    }

    public List<GetAllBasketRes> allBasket(){
        List all = basketRepository.findAll();
        return all;
    }

    public Long countBasketUserId(){
        return basketRepository.count();
    }

    private String saveFile(MultipartFile img, String imgName, Long userIdx){
        String imgPath = "images/" + userIdx;
        try {
            s3Uploader.upload(img, imgPath, imgName);
            return imgName;
        } catch (IOException e) {
            throw new NotFoundException("failed to save img");
        }
    }
}
