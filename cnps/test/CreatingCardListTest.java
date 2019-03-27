package cnps.test;

import cnps.CardDataBase.CardMaker;

/**
 * カードリスト作成をカード制作会社に依頼して
 * @author sumiryoutarou
 *
 */
public class CreatingCardListTest {
	
	/**
	 * メイン
	 * @param args
	 */
	public static void main(String[] args){
		CardMaker cardMaker = new CardMaker();		//カード制作会社を作成
		cardMaker.makeCardLists();						//カードの制作をお願いする
		cardMaker.showList();						//カード一覧を表示する
	}

}
