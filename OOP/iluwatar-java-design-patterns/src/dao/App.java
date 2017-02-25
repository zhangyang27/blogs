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

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.sqlite.SQLiteDataSource;
/**
 * Data Access Object (DAO) is an object that provides an abstract interface to some type of
 * database or other persistence mechanism. By mapping application calls to the persistence layer,
 * DAO provide some specific data operations without exposing details of the database. This
 * isolation supports the Single responsibility principle. It separates what data accesses the
 * application needs, in terms of domain-specific objects and data types (the public interface of
 * the DAO), from how these needs can be satisfied with a specific DBMS.
 *
 * <p>With the DAO pattern, we can use various method calls to retrieve/add/delete/update data
 * without directly interacting with the data source. The below example demonstrates basic CRUD
 * operations: select, add, update, and delete.
 *
 * 第一段和Customer类的一样。
 * 第二段：
 * 使用DAO模式，我们可以在客户端使用各种各样的方式对数据进行查询、添加、删除、更新，但是不用直接与数据源交互。
 * 下面将证明演示基本的CRUD操作
 *
 */
public class App {
	private static final String DB_URL = "jdbc:sqlite:test.db";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---直接使用内存---");
		final CustomerDao inMemoryDao = new InMemoryCustomerDao();
		performOperationUsing(inMemoryDao);
		System.out.println("---sqlite数据库---");
		
		final DataSource dataSource = createDataSource();
		createSchema(dataSource);
		final CustomerDao dbDao = new DbCustomerDao(dataSource);
		performOperationUsing(dbDao);
		deleteSchema(dataSource);
	}

	private static void deleteSchema(DataSource dataSource) throws SQLException {
		try (Connection connection = dataSource.getConnection();
		        Statement statement = connection.createStatement()) {
		        statement.execute(CustomerSchemaSql.DELETE_SCHEMA_SQL);
		}
		
	}

	private static void createSchema(DataSource dataSource) throws SQLException {
		try (Connection connection = dataSource.getConnection();
		        Statement statement = connection.createStatement()) {
		      statement.execute(CustomerSchemaSql.CREATE_SCHEMA_SQL);
		    }
		
	}

	private static DataSource createDataSource() {
		SQLiteDataSource dataSource = new SQLiteDataSource();
	    dataSource.setUrl(DB_URL);
	    return dataSource;
	}

	private static void performOperationUsing(final CustomerDao customerDao) throws Exception{
		// TODO Auto-generated method stub
		addCustomers(customerDao);
		System.out.println("下面打印所有用户:");
		try( Stream<Customer> cusStream = customerDao.getAll()){
			cusStream.forEach((customer)->System.out.println(customer));
		}
		System.out.println("customerDao.getCustomerById(2): " + customerDao.getById(2));
		final Customer customer = new Customer(4, "Dan","Danson");
		customerDao.add(customer);
		customer.setFirstName("Daniel");
		customer.setLastName("Danielson");
		customerDao.update(customer);
		System.out.println("下面打印所有用户:");
		try( Stream<Customer> cusStream = customerDao.getAll()){
			cusStream.forEach((cus)->System.out.println(cus));
		}
		customerDao.delete(customer);
		
	}

	private static void addCustomers(CustomerDao customerDao) throws Exception{
		// TODO Auto-generated method stub
		for(Customer cus : generateSampleCustomers()){
			customerDao.add(cus);
		}
		
	}

	private static List<Customer> generateSampleCustomers() {
		final Customer customer1 = new Customer(1, "Adam", "Adamson");
	    final Customer customer2 = new Customer(2, "Bob", "Bobson");
	    final Customer customer3 = new Customer(3, "Carl", "Carlson");
	    final List<Customer> customers = new ArrayList<>();
	    customers.add(customer1);
	    customers.add(customer2);
	    customers.add(customer3);
	    return customers;
	}

}
