package cnps.Attribute;

/**
 * 属性を示すインタフェース
 * @author sumiryoutarou
 *
 */
public interface Attribute {
	/**
	 * 属性の名称を返す
	 * @return
	 */
	public String getRoleName();
	
	/**
	 * 属性のインスタンスを返す
	 */
	public Attribute getAttributeInstance();
}
