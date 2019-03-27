package cnps.Gacha.Card.Variety;

import cnps.Gacha.Card.CupsuleCardMachine;

/**
 * 通常のカードガチャ
 * Rカード以上確定
 * @author sumiryoutarou
 *
 */
public class NormalCupsuleCardMachine extends CupsuleCardMachine{

	public NormalCupsuleCardMachine() {
		super("カードガチャ");
	}

	@Override
	public double getNormalProbability() {
		return 0;
	}

	@Override
	public double getRareProbability() {
		return 90;
	}

	@Override
	public double getSuperRareProbability() {
		return 9;
	}

	@Override
	public double getUltraRareProbability() {
		return 1;
	}

}
