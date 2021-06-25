package test;

import com.halcyon.service.IOrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test {

    @Autowired
    private IOrderService orderService;

    @Test
    public void test1(){
        orderService.getList(111111L);

    }
}
