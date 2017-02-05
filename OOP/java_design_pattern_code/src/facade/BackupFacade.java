package facade;

public class BackupFacade {
	AddressList al;
	SdCard sd;
	Photo p;
	Message m;
	public BackupFacade(){
		this.al = new AddressList();
		this.sd = new SdCard();
		this.p = new Photo();
		this.m = new Message();
	}
	public void backUp(){
		//拆成几步是为了体现外观类需要与多个业务通信协作。
		String content = this.al.getAllAddressList();
		content	+= this.p.getAllPhoto();
		content += this.m.getAllMessage();
		sd.save(content);
	}
}
