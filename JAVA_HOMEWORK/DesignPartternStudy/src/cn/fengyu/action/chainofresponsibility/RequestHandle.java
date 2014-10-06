package cn.fengyu.action.chainofresponsibility;
/*
 * 请求处理的接口，实现后继链
 */
public interface RequestHandle {
	void handleRequest(Request request);
}
