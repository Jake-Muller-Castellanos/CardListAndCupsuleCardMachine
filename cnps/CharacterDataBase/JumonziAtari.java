package cnps.CharacterDataBase;

import cnps.RoleOfCharacter.Sprinter;

public class JumonziAtari extends Character{
	public JumonziAtari(){
		name = "十文字アタリ";
		role = new Sprinter();	//役（スプリンター、アタッカー、ガンナー等が入る）
		
		
		attackMagnification = 1.00;
		deffenceMagnification = 1.00;
		hitPointMagnification  = 1.00;
		
		//バトル中関連
		 speed = 1;											//移動速度
		 attackSpeedMagnification = 1;						//攻撃速度倍率（調整用）
		
		//カードモーション
		 attackScope = 1;									//攻撃範囲
		 motionMagnificationOfShotRangeAttack = 1;			//近距離攻撃のモーション倍率
		 motionMagnificationOfLongRangeAttack = 1;			//遠距離攻撃のモーション倍率
		 motionMagnificationOfConsecutiveAttack = 1;			//連続攻撃のモーション倍率
		 motionMagnificationOfAmbientAttack = 1;			//周囲攻撃のモーション倍率
		 motionMagnificationOfRecovery = 1;			//回復のモーション倍率
		 motionMagnificationOfGuard = 1;			//ダメージカットカードのモーション倍率
		 motionMagnificationOfEnhancement = 1;			//強化のモーション倍率
		 motionMagnificationOfWeakening = 1;			//弱化のモーション倍率
		 motionMagnificationOfTrap = 1;			//罠のモーション倍率
		
		heroAction = "ダッシュアタック";
		heroSkill = "モンスターサーカス";
		heroAbility = "そっこーリスタート";
		backGroundBGM = "レトロマニア狂想曲";
		
	}
}
