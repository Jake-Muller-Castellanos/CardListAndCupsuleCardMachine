package cnps.RoleOfCharacter;

public interface Role {
	/**
	 * ロールの名称を返す
	 * @return
	 */
	public String getRoleName();
	
	/**
	 * 画面を長押しした時の振る舞い
	 */
	public void pressAndHoldScreen();
}