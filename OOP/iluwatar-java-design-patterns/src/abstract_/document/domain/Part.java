package abstract_.document.domain;

import java.util.Map;

import abstract_.document.AbstractDocument;
/**
 * Part entity
 * 部件实体
 */
public class Part extends AbstractDocument implements HasType,HasModel,HasPrice{
	  public Part(Map<String, Object> properties) {
		    super(properties);
	  }
}
