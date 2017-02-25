/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * An in memory implementation of {@link CustomerDao}, which stores the customers in JVM memory
 * and data is lost when the application exits.
 * <br/>
 * This implementation is useful as temporary database or for testing.
 * 
 * 对于CustomerDao内存版本的实现，存在JVM的内存中，数据在应用退出后将消失。
 * 如需临时存储或者测试，这样比较方便。
 */
public class InMemoryCustomerDao implements CustomerDao{

	private Map<Integer,Customer> idToCustomer = new HashMap<>();
	
  /**
   * An eagerly evaluated stream of customers stored in memory.
   * eagerly evaluated应该是立刻求值的感觉
   * 补充查询
   * In eager evaluation, an expression is evaluated as soon as it is bound to a variable. 
   * An alternative to eager evaluation is lazy evaluation,
   * where expressions are evaluated only when a dependent expression is evaluated
   * from:https://en.wikipedia.org/wiki/Eager_evaluation
   * 
   * 也就是说eagerly当其被赋值时，就立刻计算出所需要的值，而lazy evaluation只会将表达式赋值，表达式还没有进行真正计算。
   * 将计算所所需要的值可以理解为执行真正的代码，不要侠义的理解。
   * 
   * 参考：http://stackoverflow.com/questions/5526059/what-is-call-by-need
   */
	@Override
	public Stream<Customer> getAll() throws Exception {
		// TODO Auto-generated method stub
		return idToCustomer.values().stream();
	}

	@Override
	public Optional<Customer> getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return Optional.ofNullable(idToCustomer.get(id));
	}

	@Override
	public boolean add(Customer customer) throws Exception {
		if(getById(customer.getId()).isPresent()){
			return false;
		}
		idToCustomer.put(customer.getId(), customer);
		return true;
	}

	@Override
	public boolean update(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return idToCustomer.replace(customer.getId(),customer)!=null;
	}

	@Override
	public boolean delete(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return idToCustomer.remove(customer.getId()) != null;
	}

}
