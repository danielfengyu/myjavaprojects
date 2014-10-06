package cn.fengyu.action.chainofresponsibility;
/*
 * 根据该传入的请求是否是某一具体请求，该处理类是否有权限处理该请求，
 * 如果有，就处理，如果没有就把请求传递给下家。
 */
public class PMRequestHandle implements RequestHandle {
	 RequestHandle rh;
	    
	    public PMRequestHandle(RequestHandle rh) {
	        this.rh = rh;
	    }
	    
	    public void handleRequest(Request request) {
	        if (request instanceof AddMoneyRequest) {
	            System.out.println("要加薪, 项目经理审批!");
	        } else {
	            rh.handleRequest(request);
	        }
	    }

}
