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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.sql.DataSource;
/**
 * 
 * An implementation of {@link CustomerDao} that persists customers in RDBMS.
 * 一种CustomerDao的实现，
 * 他将customers数据持久化到RDBMS（Relational database management system）中。
 */
public class DbCustomerDao implements CustomerDao {
	private final DataSource dataSource;
	
	/**
	   * Creates an instance of {@link DbCustomerDao} which uses provided <code>dataSource</code>
	   * to store and retrieve customer information.
	   *
	   * <p>
	   * 使用dataSource创建一个DbCustomerDao对象，用于存储和读取customer的信息。
	   * @param dataSource a non-null dataSource.
	   */
	public DbCustomerDao(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.dataSource = dataSource;
	}
	/**
	 * lazily populated可以理解为延迟加载把
	 * 应该和InMemoryCustomerDao的eagerly evaluated相对应。
	 * 注意返回的stream必须关闭，这样才能释放所有获取的资源。
	 * stream会保持一个与数据库的链接，知道stream完成或者被手动关闭。
	 * 
	 * @return a lazily populated stream of customers. Note the stream returned must be closed to
	 *     free all the acquired resources. The stream keeps an open connection to the database till
	 *     it is complete or is closed manually.
	 *     
	 */
	@Override
	public Stream<Customer> getAll() throws Exception {
		// TODO Auto-generated method stub
		Connection connection;
		try{
			//涉及java的领域知识了，我就不一句一句敲了。
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM CUSTOMERS");
			ResultSet resultSet = statement.executeQuery();
			return StreamSupport.stream(new Spliterators.AbstractSpliterator<Customer>(Long.MAX_VALUE,
			          Spliterator.ORDERED) {

			        @Override
			        public boolean tryAdvance(Consumer<? super Customer> action) {
			          try {
			            if (!resultSet.next()) {
			              return false;
			            }
			            action.accept(createCustomer(resultSet));
			            return true;
			          } catch (SQLException e) {
			            throw new RuntimeException(e);
			          }
			        }

					
			      }, false).onClose(() -> mutedClose(connection));
			    } catch (SQLException e) {
			      throw new Exception(e.getMessage(), e);
			    }
	}
	
	private void mutedClose(Connection connection) {
		try {
		      connection.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
	}
	
	private Customer createCustomer(ResultSet resultSet) throws SQLException {
	    return new Customer(resultSet.getInt("ID"),
	            resultSet.getString("FNAME"),
	            resultSet.getString("LNAME"));
	}
	
	private Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return dataSource.getConnection();
	}
	/**
	   * {@inheritDoc}
	   */
	  @Override
	  public Optional<Customer> getById(int id) throws Exception {
	    try (Connection connection = getConnection();
	        PreparedStatement statement =
	            connection.prepareStatement("SELECT * FROM CUSTOMERS WHERE ID = ?")) {

	      statement.setInt(1, id);
	      ResultSet resultSet = statement.executeQuery();
	      if (resultSet.next()) {
	        return Optional.of(createCustomer(resultSet));
	      } else {
	        return Optional.empty();
	      }
	    } catch (SQLException ex) {
	      throw new Exception(ex.getMessage(), ex);
	    }
	  }

	  /**
	   * {@inheritDoc}
	   */
	  @Override
	  public boolean add(Customer customer) throws Exception {
	    if (getById(customer.getId()).isPresent()) {
	      return false;
	    }

	    try (Connection connection = getConnection();
	        PreparedStatement statement =
	            connection.prepareStatement("INSERT INTO CUSTOMERS VALUES (?,?,?)")) {
	      statement.setInt(1, customer.getId());
	      statement.setString(2, customer.getFirstName());
	      statement.setString(3, customer.getLastName());
	      statement.execute();
	      return true;
	    } catch (SQLException ex) {
	      throw new Exception(ex.getMessage(), ex);
	    }
	  }

	  /**
	   * {@inheritDoc}
	   */
	  @Override
	  public boolean update(Customer customer) throws Exception {
	    try (Connection connection = getConnection();
	        PreparedStatement statement =
	            connection.prepareStatement("UPDATE CUSTOMERS SET FNAME = ?, LNAME = ? WHERE ID = ?")) {
	      statement.setString(1, customer.getFirstName());
	      statement.setString(2, customer.getLastName());
	      statement.setInt(3, customer.getId());
	      return statement.executeUpdate() > 0;
	    } catch (SQLException ex) {
	      throw new Exception(ex.getMessage(), ex);
	    }
	  }

	  /**
	   * {@inheritDoc}
	   */
	  @Override
	  public boolean delete(Customer customer) throws Exception {
	    try (Connection connection = getConnection();
	        PreparedStatement statement =
	            connection.prepareStatement("DELETE FROM CUSTOMERS WHERE ID = ?")) {
	      statement.setInt(1, customer.getId());
	      return statement.executeUpdate() > 0;
	    } catch (SQLException ex) {
	      throw new Exception(ex.getMessage(), ex);
	    }
	  }

}
