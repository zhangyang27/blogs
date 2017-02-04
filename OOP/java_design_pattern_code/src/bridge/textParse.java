package bridge;

public abstract class textParse {
	protected DBSource dbs;

	public DBSource getDbs() {
		return dbs;
	}

	public void setDbs(DBSource dbs) {
		this.dbs = dbs;
	}
	public abstract void parseFile();
	
}
