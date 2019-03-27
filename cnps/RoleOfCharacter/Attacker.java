package cnps.RoleOfCharacter;

/**
 * アタッカークラス
 * @author sumiryoutarou
 *
 */
public class Attacker implements Role{
	private final String name = "アタッカー";
	
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
