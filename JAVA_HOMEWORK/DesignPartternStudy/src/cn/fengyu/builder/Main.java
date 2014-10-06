package cn.fengyu.builder;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 PersonDirector pd = new PersonDirector();
	     Person person = pd.constructPerson(new ManBuilder());
	     System.out.println(person.getBody());
	     System.out.println(person.getFoot());
	     System.out.println(person.getHand());
	     System.out.println(person.getHead());

	}

}
