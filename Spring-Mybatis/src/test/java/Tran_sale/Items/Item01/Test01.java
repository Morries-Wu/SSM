package Tran_sale.Items.Item01;

import Tran_sale.Items.Item01.Service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test01() {
        String config = "Tran_sale/Items/Item01/item01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        BuyGoodsService service = (BuyGoodsService) ctx.getBean("buyService");
        service.buy(1001, 1);
    }
}
