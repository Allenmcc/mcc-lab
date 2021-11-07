package designMode.atguigu.responsibilitychain;

public abstract class Approver {

    //默认public 子类可以直接访问，不需要提供public 的get方法
    Approver approver;  //下一个处理者
    String name; // 名字

    public Approver(String name) {
        this.name = name;
    }

    //下一个处理这
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    // private和abstract也不能同时修饰方法。因为private组织继承，
    // 也就阻止了重写实现，与abstract的意义相违背。

    //处理审批请求的方法，得到一个请求，处理是子类完成，因此该方法做成抽象
    public abstract void processRequest(PurchaseRequest purchaseRequest);

}
