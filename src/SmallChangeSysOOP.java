
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class SmallChangeSysOOP {
    boolean flag = true;
    String goods, date = null, choice;
    String Details = " ";
    double cash = 0, sell, money;
    Scanner scanner = new Scanner(System.in);
    Date date_ = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public void MainMenus() {
        do {
            System.out.println("==========零钱通===========");
            System.out.println("       1.零钱通明细         ");
            System.out.println("       2.收 益入 账         ");
            System.out.println("       3.消     费         ");
            System.out.println("       4.退     出         ");
            System.out.println("====请选择需要的功能(1-4)=====");
            choice = scanner.next();
            switch (choice) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.consume();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("==========输入错误==========");
            }
        } while (flag);
    }

    public void detail() {
        System.out.println("==========零钱明细==========");
        System.out.println(Details);
    }

    public void income() {
        Earnings earnings = new Earnings();
        //收益入账
        System.out.println("=========请输入金额=========");
        money = scanner.nextDouble();
        if (money <= 0) {
            System.out.println("=====收益入账金额需要>=0=====");
            return;
        }
        earnings.setMoney(money);
        //Date类来获取
        date_ = new Date();
        date = sdf.format(date_);
        earnings.setTime(date);
        earnings.setBalance(cash + money);
        cash += money;
        Details += "\n" + "收益入账\t" + earnings.getMoney() + "\t" + earnings.getTime() + "\t" + earnings.getBalance();
    }

    public void consume() {
        Consume consume = new Consume();
        System.out.println("=========请输入说明=========");
        goods = scanner.next();
        consume.setGoods(goods);
        System.out.println("=========请输入金额=========");
        sell = scanner.nextDouble();
        if (sell <= 0 || sell > cash) {
            if (sell <= 0) {
                System.out.println("========消费金额应>0=======");
            } else {
                System.out.printf("==余额不足,消费金额应在0-%f===\n", cash);
            }
            return;
        }
        consume.setSell(sell);
        //Date类来获取
        date_ = new Date();
        date = sdf.format(date_);
        consume.setTime(date);
        //获取余额
        consume.setBalance(cash - sell);
        cash = cash - sell;
        Details += "\n" + consume.getGoods() + "\t" + consume.getSell() + "\t" + consume.getTime() + "\t" + consume.getBalance();

    }

    public void exit() {
        String key;
        while (true) {
            System.out.println("======是否确定退出(y/n)======");
            key = scanner.next();
            if ("y".equals(key) || "n".equals(key)) {
                break;

            }
            System.out.println("======输入错误请重新输入======");
        }
        if ("y".equals(key)) {
            System.out.println("========即将退出系统=========");
            flag = false;
        }
    }
}
