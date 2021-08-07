package designMode.atguigu.money;

/**������*/
public class ClientTest {

	public static void main(String[] args) {

		Context context = new Context();
        context.setState(new PublishState());
        //Ȼ����Ը��ݲ����仯״̬.
        
        //publish --> not pay
       context.acceptOrderEvent(context);
//        //not pay --> paid
        context.payOrderEvent(context);
//        // ʧ��, ���ʧ��ʱ�����׳��쳣
//        try {
//        	context.checkFailEvent(context);
//        	System.out.println("��������..");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
        
	}

}
