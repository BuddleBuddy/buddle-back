package buddle.buddlebuddy.basket.response;

import buddle.buddlebuddy.basket.Basket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class GetAllBasketRes {
    List<Basket> all;
}
