package com.yoojone.design.parttern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuqiang.zhang
 * @date 2021/9/16
 * description: 访问者模式
 */
public class VisitorPattern {

    // 单子接口
    public interface Bill {

        void accept(AccountBookViewer viewer);
    }

    //消费的单子
    public static class ConsumeBill implements Bill {

        private double amount;

        private String item;

        public ConsumeBill(double amount, String item) {
            this.amount = amount;
            this.item = item;
        }

        @Override
        public void accept(AccountBookViewer viewer) {
            viewer.view(this);
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }
    }

    //收入单子
    public static class IncomeBill implements Bill {

        private double amount;

        private String item;

        public IncomeBill(double amount, String item) {
            this.amount = amount;
            this.item = item;
        }

        @Override
        public void accept(AccountBookViewer viewer) {
            viewer.view(this);
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }
    }

    //账单查看者接口(相当于 visitor)
    public interface AccountBookViewer {

        //void view(Bill bill);

        //查看消费的单子
        void view(ConsumeBill bill);

        //查看收入的单子
        void view(IncomeBill bill);
    }

    //老板类, 查看账本的类之一
    public static class Boss implements AccountBookViewer {
        private double totalIncome;

        private double totalConsume;

        //老板只关心一共花了多少钱以及一共收入多少钱，其余不关心
        @Override
        public void view(ConsumeBill bill) {
            totalConsume += bill.getAmount();
        }

        @Override
        public void view(IncomeBill bill) {
            totalIncome += bill.getAmount();
        }

        public double getTotalIncome() {
            System.out.println("老板查看一共收入了多少， ： " + totalIncome);
            return totalIncome;
        }

        public double getTotalConsume() {
            System.out.println("老板查看一共消费了多少， ： " + totalIncome);
            return totalConsume;
        }
    }

    //注册会计师类，查看账本的类之一
    public static class CPA implements AccountBookViewer {

        //注会在看账本时，如果是支出，则如果支出是工资，则需要看应该交的税交了没
        public void view(ConsumeBill bill) {
            if (bill.getItem().equals("工资")) {
                System.out.println("注会查看工资是否交个人所得税。");
            }
        }
        //如果是收入，则所有的收入都要交税
        public void view(IncomeBill bill) {
            System.out.println("注会查看收入交税了没。");
        }

    }

    //老板只关心收入和支出的总额，而注会只关注该交税的是否交税


    //账本类
    public static class AccountBook {
        //单子列表
        private List<Bill> billList = new ArrayList<>();
        //添加单子
        public void addBill(Bill bill) {
            billList.add(bill);
        }
        //工账本的查看者查看账本
        public void show(AccountBookViewer viewer) {
            for (Bill bill : billList) {
                bill.accept(viewer);
            }
        }

    }


    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();

        //添加两条收入
        accountBook.addBill(new IncomeBill(10000, "卖商品"));
        accountBook.addBill(new IncomeBill(12000, "卖广告位"));

        //添加两条支出
        accountBook.addBill(new ConsumeBill(10000, "工资"));
        accountBook.addBill(new ConsumeBill(12000, "材料费"));

        AccountBookViewer boss = new Boss();

        AccountBookViewer cpa = new CPA();

        //两个访问者 分别访问账本
        accountBook.show(cpa);
        accountBook.show(boss);

        ((Boss) boss).getTotalConsume();
        ((Boss) boss).getTotalIncome();
    }
}
