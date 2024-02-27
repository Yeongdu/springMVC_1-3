package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 안에 @Component 있다. 컴포넌트 스캔의 대상이 된다.
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); // 실제로는 HashMap 사용하면 안된다
    // 멀티쓰레드 상태에서 여러개가 store에 동시에 접근하게 되면 HashMap 사용하면 안된다.
    // ItemRepository 가 싱글톤으로 생성됨. static으로 되어있음.
    // 사용하고싶으면 ConcurrentHashMap 사용해야함

    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
