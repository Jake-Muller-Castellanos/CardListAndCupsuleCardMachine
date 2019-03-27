package cnps.CardDataBase;

import java.util.ArrayList;

/**
 * カードを作るクラス
 * 細かい作業は下請けのSubcontractOfCardMakerクラスに委譲する
 * @author sumiryoutarou
 *
 */
public class CardMaker{
	private static ArrayList<Card> cardLists;	//カードのリスト
	
	private SubcontractOfCardMaker subcontractOfCardMaker;	//子カード会社
	/**
	 * カードを製造する
	 */
	public void makeCardLists(){
		cardLists = getCardListInstance();
		//カードリストにランク別の節点を追加
		addCardList(new Edge("F"));
		addCardList(new Edge("E"));
		addCardList(new Edge("D"));
		addCardList(new Edge("C"));
		addCardList(new Edge("B"));
		addCardList(new Edge("A"));
		addCardList(new Edge("S1"));
		
		//各ランクの節点の下位にレアリティの節点を追加
		addCardRarelityNode();
		
		/*
		 * SubcontractOfCardMakerクラスのインスタンスを生成し、
		 * カードの組み立てを委譲する
		 * 各レアリティの節点の下位にカード（葉）を追加
		 */
		subcontractOfCardMaker = new SubcontractOfCardMaker(cardLists);
		
		//subcontractOfCardMakerクラスから完成したカードリストを取得する
		cardLists = subcontractOfCardMaker.getFinishedProduct();
	}
	/**
	 * カードのレアリティのノードを追加する
	 */
	private void addCardRarelityNode(){
		for(int i=0;i<cardLists.size();i++){
			cardLists.get(i).addCard(new Edge("N"));
			cardLists.get(i).addCard(new Edge("R"));
			cardLists.get(i).addCard(new Edge("SR"));
			cardLists.get(i).addCard(new Edge("UR"));
		}
	}
	
	/**
	 * カードのランク別のノードを追加する
	 */
	private void addCardList(Card card){
		cardLists.add(card);
	}

	/**
	 * カードリストのインスタンスがないなら、
	 * そのインスタンスを返す
	 * （singleton)
	 */
	public static ArrayList<Card> getCardListInstance(){
		if(cardLists == null){
			cardLists = new ArrayList<Card>();
		}
		return cardLists;
	}
	
	/**
	 * 全てのレアリティの全てのカードを表示する
	 */
	public void showList(){
		//ランクのループ
		for(int i=0;i<cardLists.size();i++){
			System.out.printf("ランク[%s]以上で入手可能\n",cardLists.get(i).getEdgeName());
			//レアリティのループ
			for(int j=0;j<cardLists.get(i).getCardList().size();j++){
				//カードのループ
				for(int k=0;k<cardLists.get(i).getEdge(j).getCardList().size();k++){

					System.out.printf("- [%s]%s × %d\n",cardLists.get(i).getEdge(j).getEdgeName(),
							cardLists.get(i).getEdge(j).getEdge(k).getCardName(),
							cardLists.get(i).getEdge(j).getEdge(k).getSheetNumber());
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * カードリストのゲッター
	 */
	public ArrayList<Card> getCardList(){
		return cardLists;
	}
}
