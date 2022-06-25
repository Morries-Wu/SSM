package Tran_sale.Items.Item01.Bean;

public class Sale {

    //主键
    private Integer id;
    //购买商品的id
    private Integer gid;
    //购买商品的数量
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", gid=" + gid +
                ", num=" + num +
                '}';
    }
}
