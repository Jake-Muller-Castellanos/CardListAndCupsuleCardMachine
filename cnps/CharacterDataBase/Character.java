package cnps.CharacterDataBase;

import cnps.RoleOfCharacter.Role;

public abstract class Character {
	protected String name;	//名前
	protected Role role;	//役（スプリンター、アタッカー、ガンナー等が入る）
	
	protected double attackMagnification;	//攻撃倍率
	protected double deffenceMagnification;	//防御倍率
	protected double hitPointMagnification;	//体力倍率
	
	
	
	//バトル中関連
	protected double speed;											//移動速度
	protected double attackSpeedMagnification;						//攻撃速度倍率（調整用）
	
	//カードモーション
	protected double attackScope;									//攻撃範囲
	protected double motionMagnificationOfShotRangeAttack;			//近距離攻撃のモーション倍率
	protected double motionMagnificationOfLongRangeAttack;			//遠距離攻撃のモーション倍率
	protected double motionMagnificationOfConsecutiveAttack;			//連続攻撃のモーション倍率
	protected double motionMagnificationOfAmbientAttack;			//周囲攻撃のモーション倍率
	protected double motionMagnificationOfRecovery;			//回復のモーション倍率
	protected double motionMagnificationOfGuard;			//ダメージカットカードのモーション倍率
	protected double motionMagnificationOfEnhancement;			//強化のモーション倍率
	protected double motionMagnificationOfWeakening;			//弱化のモーション倍率
	protected double motionMagnificationOfTrap;			//罠のモーション倍率
	
	
	
	
	protected String heroAction;	//ヒーローアクション（ヒーローごとに固有のアクションを持つ）
	protected String heroSkill;		//ヒーロースキル（ヒーローごとに固有のスキルを持つ）
	protected String heroAbility;	//ヒーローアビリティ（ヒーローごとに固有のアビリティを持つ）
	
	protected String backGroundBGM;			//ヒーローごとにBGMを用意する
	

}
