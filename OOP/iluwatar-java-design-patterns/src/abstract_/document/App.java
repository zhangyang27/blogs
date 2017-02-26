/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package abstract_.document;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import abstract_.document.domain.Car;
import abstract_.document.domain.HasModel;
import abstract_.document.domain.HasParts;
import abstract_.document.domain.HasPrice;
import abstract_.document.domain.HasType;

/**
 * The Abstract Document pattern enables handling additional, non-static
 * properties. This pattern uses concept of traits to enable type safety and
 * separate properties of different classes into set of interfaces.
 * <p>
 * <p>
 * In Abstract Document pattern,({@link AbstractDocument}) fully implements
 * {@link Document}) interface. Traits are then defined to enable access to
 * properties in usual, static way.
 * <p>
 * <p>
 * 抽象文档模式能够处理额外的、非静态的属性。
 * 
 * 
 * 这个模式利用traits（特性）这个概念来加强类型安全
 * 又能将属性的不同特性分离到各个接口。
 * （代码中有4种trait，trait规定了数据类型，每个属性又可以有四种trait的某一个或几个）
 * <P>
 * 在抽象文档模式中，AbstractDocumen实现了Document接口。而Trait又被设计为能够被各种属性使用。
 * 
 * 
 * 
 */
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("下面制造汽车和汽车的各个部件...");
		
		Map<String,Object> carProperties = new HashMap<>();
		carProperties.put(HasModel.PROPERTY,"300SL"); //这里就是动态（on the fly）为汽没有车添加属性了。
		carProperties.put(HasPrice.PROPERTY,100000L);
		
		//注意，要创建的wheel这个更是动态的，没有预先给汽车设计wheel这个属性
		//实际，汽车类里一个属性都没有，如果不使用这个方式，那么还要设计一个wheel类，wheel类下又有至少下面的两个属性（Model和Price）
		//这里一定要突出事先并不知道汽车到需要什么属性，也只有到了程序运行时（on the fly）才知道
		Map<String,Object> wheelProperties = new HashMap<>();
		wheelProperties.put(HasType.PROPERTY, "wheel");
		wheelProperties.put(HasModel.PROPERTY, "15C");
		wheelProperties.put(HasPrice.PROPERTY, 100L);
		
		Map<String, Object> doorProperties = new HashMap<>();
		doorProperties.put(HasType.PROPERTY, "door");
		doorProperties.put(HasModel.PROPERTY, "Lambo");
		doorProperties.put(HasPrice.PROPERTY, 300L);

		carProperties.put(HasParts.PROPERTY, Arrays.asList(wheelProperties,doorProperties));
		
		Car car = new Car(carProperties);
		
		System.out.println("下面我们已经创建好的汽车：");
		System.out.println(" -> model:"+car.getModel().get());
		System.out.println(" -> price:"+car.getPrice().get());
		System.out.println("汽车的其它部件：");
		car.getParts().forEach(p -> System.out.println("->"+p.getType().get()+","+p.getModel().get()+","+p.getPrice().get()));
	}

}
