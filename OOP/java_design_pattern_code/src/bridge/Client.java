package bridge;

public class Client {

	public static void main(String[] args) {
		textParse  tp;
		DBSource dbs;
		dbs = new MysqlDB();
		tp = new pdfParse();
		tp.setDbs(dbs);
		tp.parseFile();
	}
}
