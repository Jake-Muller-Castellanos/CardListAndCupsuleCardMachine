package cnps.CardDataBase;

import java.util.ArrayList;

/**
 * カードのランククラス
 * 木構造の節点となるクラス
 * @author sumiryoutarou
 *
 */
public class Edge extends Card{
	private String name;	//ランクの名称
	private ArrayList<Card> cardList;
	
	public Edge(String name){
		this.name = name;
		cardList = new ArrayList<Card>();
	}
	
	/**
	 * ランクにカードを追加する
	 * @param card
	 */
	public void addCard(Card card){
		cardList.add(card);
	}
	
	/**
	 * ランクのリストにある引数cardを削除する
	 * @param card
	 */
	public void remove(Card card){
		cardList.remove(card);
	}
	
	/**
	 * カードリストのi番目のカードを取得する
	 * @param i
	 */
	public Card getCard(int i){
		return cardList.get(i);
	}
	
	/**
	 * カードリストのi番目の節点を取得する
	 * @param i
	 */
	public Card getEdge(int i){
		return cardList.get(i);
	}
	
	/**
	 * ランクの名称を取得する
	 * @return
	 */
	public String getEdgeName(){
		return name;
	}
	
	/**
	 * カードリストをそのまま取得する
	 */
	public ArrayList<Card> getCardList(){
		return cardList;
	}
	
	
}
