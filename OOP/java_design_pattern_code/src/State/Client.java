package State;

import simpleFactory.Shape;
import simpleFactory.shapeFactory;


/**
 * ���ģʽ���������������Ա�ڹ�����֮��_��ΰ P366
 * ����ֽ����Ϸ
 * ��Ϸ�н�ɫ�����ֽ�ɫ�����ż���Primary��/��������Secondary��/���ּ���Professional��/�ǻҼ���Final��
 * ��ɫ����ֶ�Ӧ����Ϸʤ�������ӻ��֣�ʧ����ۼ���
 * ���ż��Ļ������ܣ�Play()
 * ��������doubleScore()
 * ���ּ���changeCards()
 * �ǻҼ���peekCards
 * 
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		Actor actor = new Actor("zhangsan");
		actor.play();
		actor.win();
		actor.play();
		actor.win();
		actor.play();
		actor.win();
		actor.play();
		actor.win();
		actor.play();
		actor.win();
		actor.play();
		actor.win();
		actor.doubleScore();
		actor.peekCard();
		actor.changeCard();
	}

}
