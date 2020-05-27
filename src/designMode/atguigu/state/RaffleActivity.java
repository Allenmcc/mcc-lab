package designMode.atguigu.state;

/**
 * 抽奖活动
 * 
 * @author Administrator
 *
 */
public class RaffleActivity {

	// state 表示活动的当前状态，是变化
    State state = null;
    // 奖品数量
    int count = 0;
    
    // 四个属性表示四个状态
    //关联关系,双向一对一
    State noRafflleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);
    
    State dispenseState =   new DispenseState(this);
    State dispensOutState = new DispenseOutState(this);

    //构造器
    //1.初始化当前状态 noRafflleState （即不能抽奖状态）
    //2. 初始化奖品的数量
    public RaffleActivity( int count) {
        //不能抽奖状态
        this.state = getNoRafflleState();
        this.count = count;
    }

    //扣分，调用当前状态的deductMoney
    public void debuctMoney(){
        state.deductMoney();
    }

    //抽奖
    public void raffle(){
    	// 如果当前状态是抽奖成功
        if(state.raffle()){
        	//领取奖品
            state.dispensePrize();
        }

    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    //每领取一次奖品,count--
    public int getCount() {
    	int curCount = count; 
    	count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getNoRafflleState() {
        return noRafflleState;
    }

    public void setNoRafflleState(State noRafflleState) {
        this.noRafflleState = noRafflleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(State canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispensOutState() {
        return dispensOutState;
    }

    public void setDispensOutState(State dispensOutState) {
        this.dispensOutState = dispensOutState;
    }
}
