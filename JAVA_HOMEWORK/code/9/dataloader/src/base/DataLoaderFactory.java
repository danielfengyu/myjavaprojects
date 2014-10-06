//DataLoader�Ĺ����࣬DataLoaderFactory.java�ļ�
package base;

import java.beans.Beans;
import java.io.*;
import java.util.*;

public class DataLoaderFactory {
	// ��ȡ�����ļ����ݣ�����DataLoader����
	public DataLoader getDataLoader() {
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("loader.properties"));
			String loaderClass = p.getProperty("loaderClass");
			// ͨ��java.beans.Beans��������ĳ���ಢʵ��������
			return (DataLoader) Beans.instantiate(getClass().getClassLoader(),loaderClass);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ֱ��ָ��DataLoader�ӿڵ�ʵ�����������
	public DataLoader getDataLoader(String loaderClass) {
		try {
			return (DataLoader) Beans.instantiate(getClass().getClassLoader(),
					loaderClass);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
