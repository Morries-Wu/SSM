package Tran_sale.Items.Item01.excetion;

//运行时异常
public class NotEnougthException extends RuntimeException {
    public NotEnougthException() {
    }

    public NotEnougthException(String message) {
        super(message);
    }
}
