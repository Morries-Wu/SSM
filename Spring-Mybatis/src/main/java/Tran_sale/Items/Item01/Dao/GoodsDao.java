package Tran_sale.Items.Item01.Dao;

import Tran_sale.Items.Item01.Bean.Goods;

public interface GoodsDao {

    Goods selectById(Integer id);

    //参数goods表示本次购买的商品id和购买数量
    //id商品id  amount本次购买的此商品数量
    int updateGoods(Goods goods);
}
