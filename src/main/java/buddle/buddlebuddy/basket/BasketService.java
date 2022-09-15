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
        System.out.println(imgName);

        //user 추가되면 수정
        User user = new User();
        user.setIdx(userIdx);

        return Optional.of(
              basketRepository.save(
                    Basket.builder()
                            .title(postBasketReq.getTitle())
                            .url(imgName)
                            .user(user)
                            .build()
              )
        );
    }

    public List<BasketListResponseInterface> myBasket(Long userId){
        return basketRepository.findBasketListResponseInterfaceUsingInterfaceWithNative(userId);
    }

    public List<BasketListResponseInterface> allBasket(){
        List<BasketListResponseInterface> all = basketRepository.findBasketListResponseInterfaceUsingInterfaceWithNative();
        return all;
    }

    public Long countBasketUserId(){
        return basketRepository.count();
    }

    private String saveFile(MultipartFile img, String title, Long userIdx){
        String imgName = title + "_" + img.getOriginalFilename();
        String imgPath = "images/" + userIdx;
        try {
            String uploadName = s3Uploader.upload(img, imgPath, imgName);
            return uploadName;
        } catch (IOException e) {
            throw new NotFoundException("failed to save img");
        }
    }
}
