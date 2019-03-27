package cnps.RoleOfCharacter;

/**
 * スプリンタークラス
 * @author sumiryoutarou
 *
 */
public class Sprinter implements Role{
	private final String name = "スプリンター";
	
	/**
	 * ロールの名称を返す
	 */
	public String getRoleName(){
		return name;
	}

	@Override
	public void pressAndHoldScreen() {
		
	}
}
