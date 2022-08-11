public class Consume {
    String goods, time;
    double sell, balance;

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSell() {
        return "-" + sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public String getBalance() {
        return "余额:" + balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
