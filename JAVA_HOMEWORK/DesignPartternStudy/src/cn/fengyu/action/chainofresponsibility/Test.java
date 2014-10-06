package cn.fengyu.action.chainofresponsibility;

public class Test {
	public static void main(String[] args) {
        RequestHandle hr = new HRRequestHandle();
        RequestHandle pm = new PMRequestHandle(hr);
        RequestHandle tl = new TLRequestHandle(pm);
        
        //team leader������ְ����
        /*
         * ��ְ�������ȷ���team leader ���������û��Ȩ�޴���
         * ��Ѹ����󴫸���Ŀ������� ��Ŀ����û��Ȩ�޴��������
         * ��Ѹ����󴫸�hr.
         */
        Request request = new DimissionRequest();
        tl.handleRequest(request);
        
        System.out.println("===========");
        //team leader�����н����
        request = new AddMoneyRequest();
        tl.handleRequest(request);
        
        System.out.println("========");
        //��Ŀ���������ְ����
        request = new DimissionRequest();
        pm.handleRequest(request);
    }

}
