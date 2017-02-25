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
import java.util.Optional;
import java.util.stream.Stream;
/**
 * In an application the Data Access Object (DAO) is a part of Data access layer. It is an object
 * that provides an interface to some type of persistence mechanism. By mapping application calls
 * to the persistence layer, DAO provides some specific data operations without exposing details
 * of the database. This isolation supports the Single responsibility principle. It separates what
 * data accesses the application needs, in terms of domain-specific objects and data types
 * (the public interface of the DAO), from how these needs can be satisfied with a specific DBMS,
 * database schema, etc.
 *
 * <p>Any change in the way data is stored and retrieved will not change the client code as the
 * client will be using interface and need not worry about exact source.
 *
 * @see InMemoryCustomerDao
 * @see DbCustomerDao
 * 
 * zhangyang27翻译：
 * 在应用中DAO属于数据接入层的一部分，DAO对不同持久化方案的统一的接口。
 * 通过将应用的请求映射的数据数据持久层，DAO在不暴露数据库细节的情况下提供了一些特殊的操作。
 * 这种分离符合单一责任原则。
 * 在当前应用所需对象和数据类型方面（就是DAO规定的统一的接口），
 * DAO将 应用所需数据的形式 和 将这些所需数据从不同的数据库管理系统或者数据库表中获得 分离 开了。
 * 
 * ·上面一段话很绕哈，但是带来的好处是：
 * 在数据存储和读取方面的改变不会影响到客户端的代码，
 * 因为客户端面向接口编程，所以完全不在乎数据的读取方面的事。
 */
public interface CustomerDao {
	/**
	   * @return all the customers as a stream. The stream may be lazily or eagerly evaluated based
	   *     on the implementation. The stream must be closed after use.
	   * @throws Exception if any error occurs.
	   */
	  Stream<Customer> getAll() throws Exception;

	  /**
	   * @param id unique identifier of the customer.
	   * @return an optional with customer if a customer with unique identifier <code>id</code>
	   *     exists, empty optional otherwise.
	   * @throws Exception if any error occurs.
	   */
	  Optional<Customer> getById(int id) throws Exception;

	  /**
	   * @param customer the customer to be added.
	   * @return true if customer is successfully added, false if customer already exists.
	   * @throws Exception if any error occurs.
	   */
	  boolean add(Customer customer) throws Exception;

	  /**
	   * @param customer the customer to be updated.
	   * @return true if customer exists and is successfully updated, false otherwise.
	   * @throws Exception if any error occurs.
	   */
	  boolean update(Customer customer) throws Exception;

	  /**
	   * @param customer the customer to be deleted.
	   * @return true if customer exists and is successfully deleted, false otherwise.
	   * @throws Exception if any error occurs.
	   */
	  boolean delete(Customer customer) throws Exception;
}
