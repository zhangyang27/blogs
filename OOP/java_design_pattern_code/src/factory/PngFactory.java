package factory;

public class PngFactory implements ReaderFactory {

	@Override
	public PicReader createReader() {
		// TODO Auto-generated method stub
		return new PngReader();
	}

}
