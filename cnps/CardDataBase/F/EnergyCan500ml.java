package cnps.CardDataBase.F;

import cnps.Attribute.*;
import cnps.CardDataBase.Card;

/**
 * N　エナジー缶　500ml
 * @author sumiryoutarou
 *
 */
public class EnergyCan500ml extends Card{
	public EnergyCan500ml(){
		super(0,"エナジー缶 500ml",0,1,new Water(),
				"ライフ６０％回復でスタート位置に戻る",10.0,13.0,
				14.0,20,"短",0);
	}
}
