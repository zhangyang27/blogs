package simpleFactory;
/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P59
 * 使用简单工厂模式设计一个可以创建不同几何形状（如圆图、方形和三角形等的）绘图工具
 * 每个绘图工具都有draw()和erase()两个方法，要求在绘制不支持的几何图形时，提示一个UnSupportedShapeException
 *
 */
public class Client {
	public static void main(String[] args) {
		Shape shape = shapeFactory.getShape("t");
		shape.draw();
		shape.erase();
		shape = shapeFactory.getShape("c");
		shape.draw();
		shape.erase();
		shape = shapeFactory.getShape("a");
		shape.draw();
		shape.erase();
	}

}
