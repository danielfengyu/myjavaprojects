package cn.fengyu.action.chainofresponsibility;
/*
 * ���ݸô���������Ƿ���ĳһ�������󣬸ô������Ƿ���Ȩ�޴��������
 * ����У��ʹ������û�оͰ����󴫵ݸ��¼ҡ�
 */
public class PMRequestHandle implements RequestHandle {
	 RequestHandle rh;
	    
	    public PMRequestHandle(RequestHandle rh) {
	        this.rh = rh;
	    }
	    
	    public void handleRequest(Request request) {
	        if (request instanceof AddMoneyRequest) {
	            System.out.println("Ҫ��н, ��Ŀ��������!");
	        } else {
	            rh.handleRequest(request);
	        }
	    }

}
