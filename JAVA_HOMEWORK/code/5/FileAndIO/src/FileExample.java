import java.io.*; //ʵ�ִ�ӡĳ��Ŀ¼��ȫ�����ļ����ƣ�������Ŀ¼��

public class FileExample { // �����в�����Ҫ�ṩһ��Ŀ¼����
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.out.println("Usage: java FileExample directory");
			System.exit(0);
		}
		new FileExample().printFile(new File(args[0]));
	}

	public void printFile(File f) throws Exception {
		if (!f.isDirectory()) {
			System.out.println("FileExample only accept directory parameter.");
			System.exit(0);
		}
		System.out.println(f.getCanonicalPath()); // ����淶�ľ���·��
		File[] children = f.listFiles(); // �õ�Ŀ¼�����ļ���������Ŀ¼��
		for (int i = 0; i < children.length; i++) {
			if (children[i].isDirectory()) { // �������Ŀ¼����ݹ�
				printFile(children[i]);
			} else {
				System.out.println(children[i]);
			}
		}
	}
}
