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

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
/**
 * Document接口的抽象实现
 */
public abstract class AbstractDocument implements Document {
	private final Map<String,Object> properties;
	public AbstractDocument(Map<String,Object> properties) {
		// TODO Auto-generated constructor stub
		this.properties = Objects.requireNonNull(properties, "properties map is required...");
	}
	
	@Override
	public void put(String key, Object value) {
		// TODO Auto-generated method stub
		properties.put(key, value);
	}

	@Override
	public Object get(String key) {
		return properties.get(key);
	}

	@Override
	public <T> Stream<T> children(String key,
			Function<Map<String, Object>, T> constructor) {
		// TODO Auto-generated method stub
		Optional<List<Map<String, Object>>> any = Stream.of(get(key)).filter(el -> el != null)
		        .map(el -> (List<Map<String, Object>>) el).findAny();
		    return any.isPresent() ? any.get().stream().map(constructor) : Stream.empty();
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName()).append("[");
		properties.entrySet()
			.forEach(e -> builder.append("[").append(e.getKey()).append(" : ").append(e.getValue()).append("]"));
		builder.append("]");
		return builder.toString();
	}

}