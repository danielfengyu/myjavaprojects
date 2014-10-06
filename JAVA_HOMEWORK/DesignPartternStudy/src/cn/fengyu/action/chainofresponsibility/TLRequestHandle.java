package cn.fengyu.action.chainofresponsibility;

public class TLRequestHandle implements RequestHandle{
	 RequestHandle rh;
	    
	    public TLRequestHandle(RequestHandle rh) {
	        this.rh = rh;
	    }

	    public void handleRequest(Request request) {
	        if (request instanceof LeaveRequest) {
	            System.out.println("Ҫ���, ��Ŀ�鳤����!");
	        } else {
	            rh.handleRequest(request);
	        }
	    }

}
