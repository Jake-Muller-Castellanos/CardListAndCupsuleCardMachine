package cnps.test;

import cnps.CardDataBase.CardMaker;
import cnps.Gacha.Card.CupsuleCardMachineOperator;

/**
 * ガチャのテストクラス
 * @author sumiryoutarou
 *
 */
public class GachaTest {
	private static CardMaker cardMaker;
	
	private static void makeCardLists(){
		cardMaker = new CardMaker();		//カード制作会社を作成
		cardMaker.makeCardLists();			//カードの制作を依頼する
		//cardMaker.showList();
	}
	
	public static void main(String[] args){
		//カードを制作
		makeCardLists();
		
		//ガチャを回す仲介者を作成し、引数に現在のカードリストを渡す。
		CupsuleCardMachineOperator ccmo = new CupsuleCardMachineOperator(cardMaker.getCardList());
		
		//有料ガチャ60連を回す
		System.out.println("回すガチャは[" + ccmo.getCupsuleCardMachineList().get(0).getCupsuleCardMachineName() + "] です");
		ccmo.outLootBox(ccmo.getCupsuleCardMachineList().get(0).getCupsuleCardMachineName(), 5000);
		ccmo.printCardList();//結果を表示
		
		//無料ガチャを1回回す
		System.out.println("回すガチャは[" + ccmo.getCupsuleCardMachineList().get(1).getCupsuleCardMachineName() + "] です");
		ccmo.outLootBox(ccmo.getCupsuleCardMachineList().get(1).getCupsuleCardMachineName(), 0);
		ccmo.printCardList();//結果を表示
		
	}
	
}
