package Tran_sale.Items.Item02.Service.Impl;

import Tran_sale.Items.Item02.Bean.Goods;
import Tran_sale.Items.Item02.Bean.Sale;
import Tran_sale.Items.Item02.Dao.GoodsDao;
import Tran_sale.Items.Item02.Dao.SaleDao;
import Tran_sale.Items.Item02.Service.BuyGoodsService;
import Tran_sale.Items.Item02.excetion.NotEnougthException;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * @Transactional 放在public方法的上面, 表示方法有事务功能
     * 第一种注释方式
     * @Transactional(propagation = Propagation.REQUIRED,
     * isolation = Isolation.DEFAULT,
     * readOnly = false,timeout = 20,
     * rollbackFor = {NullPointerException.class, NotEnougthException.class})
     * 第二种方式
     * @Transactional(propagation = Propagation.REQUIRED,
     * isolation = Isolation.DEFAULT,
     * readOnly = false, timeout = 20)
     * <p>
     * 解释rollbackFor的使用:
     * 1、框架首先检查方法抛出的异常是不是在rollbackFor的数组中,如果在一定回滚
     * 2、如果方法抛出的异常不在rollbackFor数组中,框架会继续检查抛出的异常是不是RumtimeException
     * 如果是runtimeException,一定回滚
     * <p>
     * 例如 抛出SQLException,IOException
     * rollbackFor={SQLException.class,IOException}
     */


    //第三种方式:使用默认值 REQUIRED,发生运行时异常回滚
    @Transactional
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
