package cnps.Attribute;

/**
 * 水属性
 * @author sumiryoutarou
 *
 */
public class Water implements Attribute{
	private final String name = "水属性";

	@Override
	public String getRoleName() {
		return name;
	}

	@Override
	public Attribute getAttributeInstance() {
		return this;
	}
}
