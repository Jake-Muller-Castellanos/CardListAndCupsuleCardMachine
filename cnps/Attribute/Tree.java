package cnps.Attribute;

/**
 * 木属性
 * @author sumiryoutarou
 *
 */
public class Tree implements Attribute{
	private final String name = "木属性";

	@Override
	public String getRoleName() {
		return name;
	}

	@Override
	public Attribute getAttributeInstance() {
		return this;
	}
}
