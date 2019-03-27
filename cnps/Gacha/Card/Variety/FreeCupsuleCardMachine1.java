package cnps.Gacha.Card.Variety;

import cnps.Gacha.Card.CupsuleCardMachine;

/**
 * 無料単発ガチャ
 * ４時間に１度回せる
 * @author sumiryoutarou
 *
 */
public class FreeCupsuleCardMachine1 extends CupsuleCardMachine{

	public FreeCupsuleCardMachine1() {
		super("無料カードガチャ");
	}

	@Override
	public double getNormalProbability() {
		return 70;
	}

	@Override
	public double getRareProbability() {
		return 28;
	}

	@Override
	public double getSuperRareProbability() {
		return 1.8;
	}

	@Override
	public double getUltraRareProbability() {
		return 0.2;
	}

}
