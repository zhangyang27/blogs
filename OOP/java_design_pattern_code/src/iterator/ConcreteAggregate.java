package iterator;

public class ConcreteAggregate extends Container {

	@Override
	public Iterator createIterator() {
		Iterator iter = new pageIterator(this.container);
		return iter;

	}

}
