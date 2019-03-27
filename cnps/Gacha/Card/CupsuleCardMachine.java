package cnps.Gacha.Card;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

import cnps.CardDataBase.*;

/**
 * ガチャ共通の抽象クラス
 * @author sumiryoutarou
 *
 */
public abstract class CupsuleCardMachine {
	private String name;								//ガチャ名
	private SecureRandom sRandom = new SecureRandom();	//乱数発生器(偏り小)
	private Random random = new Random();				//乱数発生器(偏り大)
	private DetailOfCupsuleCardMachine detailOfCupsuleCardMachine;			//ガチャの詳細クラスの参照型変数
	
	/**
	 * ガチャの価格
	 * [要素]枚の時の価格がリストの値である
	 */
	private ArrayList<Integer> TheNumberSheetOfPrice;		//ガチャの価格
	
	private ArrayList<Card> wonCardList;					//排出されたカードリスト
	
	
	public CupsuleCardMachine(String name){
		this.name = name;
		detailOfCupsuleCardMachine = new DetailOfCupsuleCardMachine();			//ガチャの詳細クラスのインスタンス
		TheNumberSheetOfPrice = detailOfCupsuleCardMachine.setThePriceOfNumberSheet();	//価格の設定						//価格をセット
	}
	
	/**
	 * ガチャを回す
	 * 振る舞いは各実装によって変化する
	 * (TemplateMethod)
	 * ※ガチャの値段が合わない場合やカードリストが無い場合はエラーを出力する
	 * @param price 価格
	 * @param CardList 抽選するカードリスト
	 * @return 選定されたカードリスト
	 */
	public ArrayList<Card> outLootBox(int price,ArrayList<Card> cardList){
		wonCardList = new ArrayList<Card>();
		if(cardList == null){
			System.out.println("カードリストがありません");
			return null;
		}
		if(TheNumberSheetOfPrice.get(price) == null){
			System.out.printf("%dBM(ビットマネー)ではガチャを回すことができません",price);
			return null;
		}
		cardList = detailOfCupsuleCardMachine.condenseCardList(cardList);
		for(int i=0;i<TheNumberSheetOfPrice.get(price);i++){
			//排出されるカードを選定カードリストに追加する
			wonCardList.add(selectWinCard(getAndCheckSumProbability(),cardList));
		}
		return wonCardList;
	}
	
	/**
	 * 引数で渡された確率とリストから抽選を行い、
	 * １枚だけカードを選定し、それを返すメソッド
	 * @param cardList
	 * @return
	 */
	protected Card selectWinCard(int sumProbability,ArrayList<Card> cardList){
		//1~10000の中で乱数を発生させる
		int winNumber = getRandomNumber(sumProbability * 100);
		//Nカードの時
		if(0 <= winNumber && winNumber < getNormalProbability()*100){
			int cardNumber = getRandomNumber(cardList.get(0).getCardList().size());
			return cardList.get(0).getCard(cardNumber);
		}
		
		//Rカードの時
		else if(getNormalProbability()*100 <= winNumber && 
				winNumber < (getNormalProbability()+getRareProbability())*100){
			int cardNumber = getRandomNumber(cardList.get(1).getCardList().size());
			return cardList.get(1).getCard(cardNumber);
		}
		
		//SRカードの時
		else if((getNormalProbability()+getRareProbability())*100 <= winNumber && 
				winNumber < (getNormalProbability()+getRareProbability()+getSuperRareProbability())*100){
			int cardNumber = getRandomNumber(cardList.get(2).getCardList().size());
			return cardList.get(2).getCard(cardNumber);
		}
		
		//URカードの時
		else if(((getNormalProbability()+getRareProbability()+getSuperRareProbability())*100 <= winNumber && 
				winNumber < (getNormalProbability()+getRareProbability()+getSuperRareProbability()+getUltraRareProbability())*100)){
			int cardNumber = getRandomNumber(cardList.get(3).getCardList().size());
			return cardList.get(3).getCard(cardNumber);
		}
		//その他
		else {
			System.out.println("エラー");
			return null;
		}
	}
	
	/**
	 * 各レアリティの排出率を確認し、合計を取得する
	 * ただし、CupsuleCardMachineクラスの実装クラスでの
	 * 各レアリティの排出率の合計が100でない場合は0を返す。
	 */
	protected int getAndCheckSumProbability(){
		int sumProbability = (int) (getNormalProbability() + 
				getRareProbability() + 
				getSuperRareProbability() + 
				getUltraRareProbability());
		
		if(sumProbability != 100){
			System.out.printf("確率が正しくセット出来ていません。[%d]",sumProbability);
			return 0;
		}
		else return sumProbability;
	}
	
	/**
	 * ガチャの名称を取得する
	 */
	public String getCupsuleCardMachineName(){
		return name;
	}
	
	/**
	 * Nカードの排出率（％）
	 * @return
	 */
	public abstract double getNormalProbability();
	
	/**
	 * Rカードの排出率（％）
	 * @return
	 */
	public abstract double getRareProbability();
	
	/**
	 * SRカードの排出率（％）
	 * @return
	 */
	public abstract double getSuperRareProbability();
	
	/**
	 * URカードの排出率（％）
	 * @return
	 */
	public abstract double getUltraRareProbability();
	
	/**
	 * 引数の整数未満の乱数を取得する(0~)
	 * 現在のナノ秒が偶数奇数で乱数の発生方法が変化する
	 * @return
	 */
	public int getRandomNumber(int sum){
		if(System.nanoTime() % 2.0 == 0)
			return sRandom.nextInt(sum);
		else 
			return random.nextInt(sum);
	}
	
	/**
	 * 排出されたカードのリストを取得
	 * @return
	 */
	public ArrayList<Card> getWonCardList(){
		return wonCardList;
	}
	
	/**
	 * 排出されたカードを取得
	 * @return
	 */
	public Card getWonCard(int cardNumber){
		return wonCardList.get(cardNumber);
	}
	
	/**
	 * （デバッグ用）ガチャの価格を表示
	 */
	public void printPrice(){
		for(int i=0;i<TheNumberSheetOfPrice.size();i++){
			if(TheNumberSheetOfPrice.get(i) != null)System.out.println(i + "BMで　" + TheNumberSheetOfPrice.get(i) + "回 回せる");
		}
	}
	
	/**
	 * (デバッグ用)引数のリストをレアリティ別に表示
	 */
	public void printCardList(ArrayList<Card> cardList){
		cardList = detailOfCupsuleCardMachine.condenseCardList(cardList);
		//レアリティのループ
				for(int i=0;i<cardList.size();i++){
					System.out.printf("ランク[%s]　一覧\n",cardList.get(i).getEdgeName());
					//カードのループ
					for(int j=0;j<cardList.get(i).getCardList().size();j++){
						System.out.printf("- %s × %d\n",cardList.get(i).getCard(j).getCardName(),
								cardList.get(i).getCard(j).getSheetNumber());
					}
					System.out.println();
				}
	}
	/**
	 * (デバッグ用)排出されたカードを表示
	 */
	public void printCard(ArrayList<Card> cardList){
		//レアリティのループ
		for(int i=0;i<cardList.size();i++){
			System.out.printf("- %s × %d\n",cardList.get(i).getCardName(),cardList.get(i).getSheetNumber());
		}
	}
	
}
