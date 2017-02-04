package factory;

public class GifFactory implements ReaderFactory {

	@Override
	public PicReader createReader() {
		// TODO Auto-generated method stub
		return new GifReader();
	}

}
