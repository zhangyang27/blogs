package factory;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PicReader reader;
		Class c = null;
		try {
			c = Class.forName("factory.PngFactory");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Object obj = null;
		try {
			obj = c.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReaderFactory rd = (ReaderFactory)obj;
		reader = rd.createReader();
		reader.read("XͼƬ");
	}

}
