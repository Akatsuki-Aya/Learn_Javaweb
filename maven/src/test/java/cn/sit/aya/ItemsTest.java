package cn.sit.aya;

import cn.sit.aya.domain.Items;
import cn.sit.aya.service.Impl.ItemsServiceImpl;
import cn.sit.aya.service.ItemsService;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    @Test
    public void findAll(){
        ItemsService service = new ItemsServiceImpl();
        List<Items> list = service.findAll();
        for (Items items : list) {
            System.out.println(items.getId()+" : "+items.getName());
        }
    }
}
