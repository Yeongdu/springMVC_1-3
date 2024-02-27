package hello.itemservice.domain.item;

import lombok.Data;


// @Data 핵심 도메인 모델에 사용하게 되면 위험. 필요한거 꺼내 사용
// @Getter @Setter
// 예제니까 그냥 @Data 사용
@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price; // 가격이 없을 가능성
    private Integer quantity; // 수량이 null일수도 있기 때문에

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
