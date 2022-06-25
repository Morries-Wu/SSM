package Tran_sale.Items.Item01.Service.Impl;

import Tran_sale.Items.Item01.Bean.Goods;
import Tran_sale.Items.Item01.Bean.Sale;
import Tran_sale.Items.Item01.Dao.GoodsDao;
import Tran_sale.Items.Item01.Dao.SaleDao;
import Tran_sale.Items.Item01.Service.BuyGoodsService;
import Tran_sale.Items.Item01.excetion.NotEnougthException;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public SaleDao getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public void buy(Integer goodsId, Integer num) {
        System.out.println("buy方法的开始");
        //生成销售记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNum(num);
        saleDao.insertSale(sale);
        //查询商品
        Goods goods = goodsDao.selectById(goodsId);
        if (goods == null) {
            throw new NullPointerException(goodsId + "商品不存在");
        } else if (goods.getAmount() < num) {
            throw new NotEnougthException(goodsId + "库存不足");
        }

        //更新库存
        Goods buygoods = new Goods();
        buygoods.setId(goodsId);
        buygoods.setAmount(num);
        goodsDao.updateGoods(buygoods);
        System.out.println("buy方法的完成");
    }
}
