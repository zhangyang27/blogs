package factory;

/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P73
 * 使用工厂方法模式设计一个程序来读取各种不同类型的图片格式，针对每一种图片格式都设计一个图片读取器
 * 例如：GIF图片读取器读取GIF格式的图片，JPG图片读取器读取JPG格式的图片。
 * 需要充分考虑系统的灵活性和扩展性。
 * @author zhangyang27
 *
 */
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
		reader.read("X图片");
	}

}
