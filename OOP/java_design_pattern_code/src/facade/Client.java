package facade;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P194
 * 手机的一键备份功能，是将手机通讯录、照片、短信等复制到sd卡内。
 * 过程需要与多个业务类交流（通讯类、照片、短信等）
 * 使用外观模式降低完成。
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		BackupFacade backup = new BackupFacade();
		backup.backUp();
	}
}
