package cnps.Gacha.Card;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import cnps.CardDataBase.Card;

/**
 * ガチャを管理するクラス
 * 全てのカードガチャのインスタンスを管理し、
 * ユーザからの命令を受け取るクラス
 * @author sumiryoutarou
 *
 */
public class CupsuleCardMachineOperator {
	private static ArrayList<CupsuleCardMachine> cupsuleCardMachineList;	//ガチャのリスト
	private final int MAX_GACHA = 100;										//管理可能なガチャの数
	
	private ArrayList<Card> cardHistory;									//取得カードの履歴
	private ArrayList<Card> userCardList;									//ユーザが持つカードリスト
	
	/**
	 * コンストラクタ
	 * @param cardList　ユーザが持つカードリスト
	 */
	public CupsuleCardMachineOperator(ArrayList<Card> cardList){
		cupsuleCardMachineList = getCupsuleCardMachineInstance();
		setCupsuleCardMachine();
		cardHistory = new ArrayList<Card>();
		userCardList = cardList;
	}
	
	/**
	 * ここで指定したガチャ名と値段が合致するガチャに対して
	 * その指定した値段とユーザが持つ現在のカードリストを委譲する
	 * @param machineName ガチャ名
	 * @param price		　値段
	 */
	public void outLootBox(String machineName,int price){
		for(int i=0;i<cupsuleCardMachineList.size();i++){
			if(cupsuleCardMachineList.get(i).getCupsuleCardMachineName().equals(machineName)){
				cupsuleCardMachineList.get(i).outLootBox(price, userCardList);
				for(int j=0;j<cupsuleCardMachineList.get(i).getWonCardList().size();j++){
					cardHistory = cupsuleCardMachineList.get(i).getWonCardList();
				}
			}
		}
		//ここでUserのカードリストの枚数を加算する
		//履歴のループ
		for(int l=0;l<cardHistory.size();l++){
			//ランクのループ
			for(int i=0;i<userCardList.size();i++){
				//レアリティのループ
				for(int j=0;j<userCardList.get(i).getCardList().size();j++){
					//カードのループ
					for(int k=0;k<userCardList.get(i).getEdge(j).getCardList().size();k++){
						if(cardHistory.get(l).equals(userCardList.get(i).getEdge(j).getCard(k))){
								userCardList.get(i).getEdge(j).getEdge(k).increaseSheetNumber();
						}
					}
				}
			}
		}
	}
	
	
	
	/**
	 * カードガチャのVarietyパッケージ下にあるクラス全てをインスタンス化して
	 * ガチャリストに追加する
	 */
	private void setCupsuleCardMachine(){
		//ガチャの具象クラスが格納されているパッケージパス
		String packagePass = "cnps.Gacha.Card.Variety";	
		
		//"."を"/"に置換する
		String packagePass2 = packagePass.replace(".", "/");
		
		//ファイルシステム上のパスを取得
		URL packageUrl = getClass().getClassLoader().getResource(packagePass2);
		
		//Fileオブジェクトにパッケージを追加
		File packageFile = new File(packageUrl.getFile());
		
		//ファイル下のクラスリストを取得
		File[] fileNameList = new File[MAX_GACHA];
		fileNameList = packageFile.listFiles();
		
		/* 取得したFileオブジェクトからファイル名を取得し、
		 * 拡張子".class"を除いたファイル名と、最初に指定したパッケージ名を結合し、
		 * インスタンス化するクラスの完全指定名を取得する
		 * その後、インスタンス化してCupsuleCardMachineListに追加する。
		 */
		for (int i = 0; i < fileNameList.length; i++) {	
			String sFileName = fileNameList[i].getName();
			// 拡張子".class"を除いたファイル名と、パッケージ名を結合する。
			String sClassName = packagePass + "." + sFileName.substring(0, sFileName.indexOf(".class"));
			// 取得した完全指定されたクラス名にてクラスをインスタンス化する。
			
				try {
					//インスタンスをリストに追加する
					cupsuleCardMachineList.add((CupsuleCardMachine) Class.forName(sClassName).newInstance());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * ガチャリストのゲッター
	 * @return
	 */
	public ArrayList<CupsuleCardMachine> getCupsuleCardMachineList(){
		return cupsuleCardMachineList;
	}
	
	
	/**
	 * ガチャリストのインスタンスがなければ、
	 * そのインスタンスを返す
	 * (singleton)
	 * @return
	 */
	public static ArrayList<CupsuleCardMachine> getCupsuleCardMachineInstance(){
		if(cupsuleCardMachineList == null){
			cupsuleCardMachineList = new ArrayList<CupsuleCardMachine>();
		}
		return cupsuleCardMachineList;
	}
	
	public void printCardList(){
		cupsuleCardMachineList.get(0).printCardList(userCardList);
	}
	
	
}
