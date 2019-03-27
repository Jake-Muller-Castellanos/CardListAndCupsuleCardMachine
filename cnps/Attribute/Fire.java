package cnps.Attribute;

/**
 * 火属性クラス
 * @author sumiryoutarou
 *
 */
public class Fire implements Attribute{
	private final String name = "火属性";

	@Override
	public String getRoleName() {
		return name;
	}

	@Override
	public Attribute getAttributeInstance() {
		return this;
	}
	
	
}
