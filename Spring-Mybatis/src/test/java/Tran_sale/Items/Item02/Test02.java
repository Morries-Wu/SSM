package Tran_sale.Items.Item02;

import Tran_sale.Items.Item02.Service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    @Test
    public void test01() {
        String config = "Tran_sale/Items/Item02/item02.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        BuyGoodsService service = (BuyGoodsService) ctx.getBean("buyService");
        service.buy(1005, 10);
    }
}
