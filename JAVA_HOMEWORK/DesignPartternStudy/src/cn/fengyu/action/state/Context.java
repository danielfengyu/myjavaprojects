package cn.fengyu.action.state;
/*
 * ����ͻ�����Ȥ�Ľӿڡ� ά��һ��ConcreteState�����ʵ�������ʵ�����嵱ǰ״̬��
 */
public class Context {
	 private Weather weather;

	    public void setWeather(Weather weather) {
	        this.weather = weather;
	    }

	    public Weather getWeather() {
	        return this.weather;
	    }

	    public String weatherMessage() {
	        return weather.getWeather();
	    }
}
