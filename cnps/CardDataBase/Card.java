package cnps.CardDataBase;

import java.util.ArrayList;

import cnps.Attribute.Attribute;

/**
 * カードクラス
 * 木構造の葉となるクラス
 * @author sumiryoutarou
 *
 */
public abstract class Card{
	/**
	 * 0:N , 1:R , 2:SR , 3:UR
	 */
	protected int rarelityNumber;	//カードのレア度
	protected String cardName;		//カード名称
	protected int sheetNumber;		//カード枚数
	protected int level;			//カードレベル
	protected Attribute attribute;	//カードの属性
	protected String explanation;	//カードの説明
	
	/**
	 * カードのステータスの上昇量は全部で６パターン
	 * 攻撃寄り/防御寄り/体力寄り/攻撃・防御寄り/防御・体力寄り/攻撃・体力寄り
	 * これはLvアップするメソッドを追加時に実装する
	 */
	protected double attackValue;	//攻撃値
	protected double deffenceValue;	//防御値
	protected double hitPointValue;	//体力値
	protected int coolTime;			//クールタイム
	protected String activationTime;//発動時間（無/短/長のどれか）
	
	/**
	 * 0:近距離,1:遠距離,2:連続,3:周囲,4:回復,5:ガード,
	   6:強化,7:弱体化,8:移動,9:罠,10:その他
	 */
	protected int type;	//カード効果	
	
	public Card(){}
	public Card(int rarelity,String cardName,int sheetNumber,int level,Attribute attribute,
					String explanation,double attackValue,double deffenceValue,
					double hitPointValue,int coolTime,String activationTime,
					int type){
		this.rarelityNumber = rarelity;
		this.cardName = cardName;
		this.sheetNumber = sheetNumber;
		this.level = level;
		this.attribute = attribute;
		this.explanation = explanation;
		this.attackValue = attackValue;
		this.deffenceValue = deffenceValue;
		this.hitPointValue = hitPointValue;
		this.coolTime = coolTime;
		this.activationTime = activationTime;
		this.type = type;
		
	}
	
	/**
	 * カードの所持枚数を+1する
	 */
	public void increaseSheetNumber(){
		sheetNumber++;
	}
	
	
	/**
	 * 各種ゲッター
	 */
	public int getRarelityNumber(){
		return rarelityNumber;
	}
	public String getCardName(){
		return cardName;
	}
	public int getSheetNumber(){
		return sheetNumber;
	}
	public int getLevel(){
		return level;
	}
	public Attribute getAttribute(){
		return attribute;
	}
	public String getExplanation(){
		return explanation;
	}
	public double getAttackValue(){
		return attackValue;
	}
	public double getDeffenceValue(){
		return deffenceValue;
	}
	public double getHitPointValue(){
		return hitPointValue;
	}
	public int getCoolTime(){
		return coolTime;
	}
	public String getActivationTime(){
		return activationTime;
	}
	public int getType(){
		return type;
	}
	
	/**
	 * カードを追加する
	 * @param card
	 */
	public void addCard(Card card){
		throw new UnsupportedOperationException();
	}
	/**
	 * レアリティのリストにある引数cardを削除する
	 * @param card
	 */
	public void remove(Card card){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * カードリストのi番目のカードを取得する
	 * @param i
	 */
	public Card getCard(int i){
		return null;
	}
	/**
	 * カードリストのi番目の節点を取得する
	 * @param i
	 */
	public Card getEdge(int i){
		return null;
	}
	/**
	 * レアリティの名称を取得する
	 * @return
	 */
	public String getEdgeName(){
		throw new UnsupportedOperationException();
	}
	/**
	 * カードリストをそのまま取得する
	 */
	public ArrayList<Card> getCardList(){
		throw new UnsupportedOperationException();
	}
	
	
	
}
