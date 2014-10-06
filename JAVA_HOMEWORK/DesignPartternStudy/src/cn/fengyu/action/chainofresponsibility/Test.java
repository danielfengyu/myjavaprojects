package cn.fengyu.action.chainofresponsibility;

public class Test {
	public static void main(String[] args) {
        RequestHandle hr = new HRRequestHandle();
        RequestHandle pm = new PMRequestHandle(hr);
        RequestHandle tl = new TLRequestHandle(pm);
        
        //team leader处理离职请求
        /*
         * 离职请求首先发给team leader 处理，如果他没有权限处理
         * 则把该请求传给项目经理，如果 项目经理没有权限处理该请求
         * 则把该请求传给hr.
         */
        Request request = new DimissionRequest();
        tl.handleRequest(request);
        
        System.out.println("===========");
        //team leader处理加薪请求
        request = new AddMoneyRequest();
        tl.handleRequest(request);
        
        System.out.println("========");
        //项目经理上理辞职请求
        request = new DimissionRequest();
        pm.handleRequest(request);
    }

}
