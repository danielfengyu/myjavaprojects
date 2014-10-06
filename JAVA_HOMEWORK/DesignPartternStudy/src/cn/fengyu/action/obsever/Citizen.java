package cn.fengyu.action.obsever;

import java.util.ArrayList;
import java.util.List;
/*
 * Ŀ��֪�����Ĺ۲��ߡ��������������۲��߹۲�ͬһ��Ŀ�ꡣ�ṩע���ɾ���۲��߶���Ľӿڡ�
 */
public abstract class Citizen {
	 List<Policeman> pols;
	    
	    String help = "normal";
	    
	    public void setHelp(String help) {
	        this.help = help;
	    }
	    
	    public String getHelp() {
	        return this.help;
	    }
	    
	    abstract void sendMessage(String help);

	    public void setPolicemen() {
	        this.pols = new ArrayList<Policeman>();
	    }
	    
	    public void register(Policeman pol) {
	        this.pols.add(pol);
	    }

	    public void unRegister(Policeman pol) {
	        this.pols.remove(pol);
	    }
}
