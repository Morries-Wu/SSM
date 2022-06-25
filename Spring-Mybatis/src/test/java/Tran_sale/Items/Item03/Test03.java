package Tran_sale.Items.Item03;

import Tran_sale.Items.Item03.Service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
    @Test
    public void test01() {
        String config = "Tran_sale/Items/Item03/item03.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        BuyGoodsService service = (BuyGoodsService) ctx.getBean("buyService");
        service.buy(1001, 10000);
    }
}
