package cnps.Gacha.Card;

import java.util.ArrayList;

import cnps.CardDataBase.Card;
import cnps.CardDataBase.Edge;

/**
 * カードガチャにおいて運営側が選定した規則を実装したクラス
 * @author sumiryoutarou
 *
 */
public class DetailOfCupsuleCardMachine{
	/**
	 * カードリストのランク別の節点を削除したリストを返す
	 * @param cardList　節点を削除したいリスト
	 * @return	節点を削除したリスト
	 */
	protected ArrayList<Card> condenseCardList(ArrayList<Card> cardList){
		ArrayList<Card> temporaryCardList = new ArrayList<Card>();
		temporaryCardList.add(new Edge("N"));
		temporaryCardList.add(new Edge("R"));
		temporaryCardList.add(new Edge("SR"));
		temporaryCardList.add(new Edge("UR"));
		
		//ランクのループ
		for(int i=0;i<cardList.size();i++){
			//レアリティのループ
			for(int j=0;j<cardList.get(i).getCardList().size();j++){
				//カードのループ
				for(int k=0;k<cardList.get(i).getEdge(j).getCardList().size();k++){
					temporaryCardList.get(j).addCard(cardList.get(i).getEdge(j).getCard(k));
				}
			}
		}
		return temporaryCardList;
	}
	/**
	 * ガチャの価格あたりの枚数をセットする
	 */
	protected ArrayList<Integer> setThePriceOfNumberSheet(){
		ArrayList<Integer> TheNumberSheetOfPrice = new ArrayList<Integer>();
		for(int i=0;i<5000;i++){
			TheNumberSheetOfPrice.add(null);
		}
		TheNumberSheetOfPrice.add(0,1);	//無料1回用
		TheNumberSheetOfPrice.add(100,1);
		TheNumberSheetOfPrice.add(1000,11);
		TheNumberSheetOfPrice.add(2000,23);
		TheNumberSheetOfPrice.add(3000,35);
		TheNumberSheetOfPrice.add(4000,47);
		TheNumberSheetOfPrice.add(5000,60);

		return TheNumberSheetOfPrice;
	}
}
