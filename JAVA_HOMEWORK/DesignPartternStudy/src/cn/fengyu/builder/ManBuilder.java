package cn.fengyu.builder;
/**
 * 
 * @author ����
 * ����Ľ����ߣ�ʵ���˽����߽ӿڡ����콨�����һ���ˣ���Ȼ�ø���һ���˵�ģ�ͣ������ܰ��ո�ģ�ͽ�����
 * ��ģ���ˣ����ÿ�ʼ���ˣ�������Ҳ�ǳ�������
 *
 */
public class ManBuilder implements PersonBuilder{
	Person person;//ģ��
	/**
	 * ���˵Ļ�������ʼ���ˣ�ָ����һ��ʲô�����ˣ����������һ�������ˡ�
	 */
	public ManBuilder(){
		this.person=new Man();
	}
	public void buildHead(){
		person.setHead("man��ͷ");
	}
	public void buidHand(){
		person.setHand("man����");
	}
	public void buidBody(){
		person.setBody("man������");
	}
	
	public void buildFoot(){
		person.setFoot("man �Ľ�");
	}
	//����ú󣬻������ⷢ������Ȼ����Ҳ��֪��������ˡ�
	public Person buildPerson() {
        return person;
    }

}
