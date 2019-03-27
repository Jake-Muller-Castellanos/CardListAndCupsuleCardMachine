package cnps.CardDataBase;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;



/**
 * 細かいカードの組み立てを行うクラス
 * 各レアリティのパッケージ内のクラスを全てインスタンスとして生成してカードリストに追加する
 * @author sumiryoutarou
 *
 */
public class SubcontractOfCardMaker {
	private final int MAX_CARD = 1000;			//一つのレアリティに収納される最大枚数
	
	private ArrayList<Card> cardLists;	//カードのレアリティのリスト
	private ArrayList<String> packagePass; 	//カードリストに追加するレアリティのパッケージパスのリスト
	private ArrayList<String> packagePass2; 	//カードリストに追加するレアリティのパッケージパスのリスト
	private ArrayList<URL> packageUrl;		//ファイルシステム上のパスのリスト
	private ArrayList<File> packageFile;	//ファイルシステム上のパスを利用して作ったFileオブジェクトのリスト
	
	private File[] F_FileNameList;			//パッケージ配下のファイル名リスト
	private File[] E_FileNameList;			//パッケージ配下のファイル名リスト
	private File[] D_FileNameList;			//パッケージ配下のファイル名リスト
	private File[] C_FileNameList;			//パッケージ配下のファイル名リスト
	private File[] B_FileNameList;			//パッケージ配下のファイル名リスト
	private File[] A_FileNameList;			//パッケージ配下のファイル名リスト
	private File[] S1_FileNameList;			//パッケージ配下のファイル名リスト
	
	
	public SubcontractOfCardMaker(ArrayList<Card> cardLists){
		this.cardLists = cardLists;
		packagePass = new ArrayList<String>();
		packagePass2 = new ArrayList<String>();
		packageUrl = new ArrayList<URL>();
		packageFile = new ArrayList<File>();
		
		F_FileNameList = new File[MAX_CARD];			//パッケージ配下のファイルのFileオブジェクト
		E_FileNameList= new File[MAX_CARD];			//パッケージ配下のファイルのFileオブジェクト
		D_FileNameList= new File[MAX_CARD];			//パッケージ配下のファイルのFileオブジェクト
		C_FileNameList= new File[MAX_CARD];			//パッケージ配下のファイルのFileオブジェクト
		B_FileNameList= new File[MAX_CARD];			//パッケージ配下のファイルのFileオブジェクト
		A_FileNameList= new File[MAX_CARD];			//パッケージ配下のファイルのFileオブジェクト
		S1_FileNameList= new File[MAX_CARD];			//パッケージ配下のファイルのFileオブジェクト
		
		prepare();
		replace();
		setUrl();
		setFile();
		
		getCardInstance(F_FileNameList,0);
		getCardInstance(E_FileNameList,1);
		getCardInstance(D_FileNameList,2);
		getCardInstance(C_FileNameList,3);
		getCardInstance(B_FileNameList,4);
		getCardInstance(A_FileNameList,5);
		getCardInstance(S1_FileNameList,6);
		
	}
	
	/**
	 * 完成したカードリストを取得する
	 * @return
	 */
	public ArrayList<Card> getFinishedProduct(){
		return cardLists;
	}
	
	/**
	 * 取得したFileオブジェクトからファイル名を取得して、
	 * 拡張子".class"を除いたファイル名と、最初に指定したパッケージ名を結合し、
	 * インスタンス化するクラスの完全指定名を取得する
	 * 第一引数にパッケージ配下のリスト
	 * 第二引数にパッケージの番号を入れる
	 */
	private void getCardInstance(File[] fileNameList,int number){
		for (int i = 0; i < fileNameList.length; i++) {	
			String sFileName = fileNameList[i].getName();
			// 拡張子".class"を除いたファイル名と、パッケージ名を結合する。
			String sClassName = packagePass.get(number) + "." + sFileName.substring(0, sFileName.indexOf(".class"));
			// 取得した完全指定されたクラス名にてクラスをインスタンス化する。
			
				try {
					addCard((Card) Class.forName(sClassName).newInstance(),number);
				} catch (InstantiationException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//map.put(sClassName, (Card) Class.forName(sClassName).newInstance());
				//addCard(map.get(sClassName));		//ここでカードを追加する
			
		}
		
		
	}
	
	/**
	 * ファイルシステム上のパスを利用し、
	 * Fileオブジェクトを生成してパッケージの下にあるクラスのリストを取得する
	 * ※最後にArrayListに変換しているが、途中で変換できるかもしれない（改善の余地あり）
	 */
	private void setFile(){
		//packageFileリストの要素[*][0]にFileオブジェクトを追加していく
		for(int i=0;i<packageUrl.size();i++){
			packageFile.add(new File(packageUrl.get(i).getFile()));
		}
		
		//パッケージの下にあるクラスのリストを取得する
		F_FileNameList = packageFile.get(0).listFiles();
		E_FileNameList = packageFile.get(1).listFiles();
		D_FileNameList = packageFile.get(2).listFiles();
		C_FileNameList = packageFile.get(3).listFiles();
		B_FileNameList = packageFile.get(4).listFiles();
		A_FileNameList = packageFile.get(5).listFiles();
		S1_FileNameList = packageFile.get(6).listFiles();
	}
	
	/**
	 * ファイルシステム上のパスを取得し、
	 * リストにセットする
	 */
	private void setUrl(){
		for(int i=0;i<packagePass2.size();i++){
			packageUrl.add(getClass().getClassLoader().getResource(packagePass2.get(i)));
		}
	}
	
	/**
	 * パッケージパスの"."を"/"に変換する
	 * 
	 */
	private void replace(){
		for(int i=0;i<packagePass.size();i++){
			packagePass2.add(i,packagePass.get(i).replace(".", "/"));
		}
	}
	
	/**
	 * 前準備として、読み込むパッケージのパスをリストに追加する
	 */
	private void prepare(){
		packagePass.add("cnps.CardDataBase.F");
		packagePass.add("cnps.CardDataBase.E");
		packagePass.add("cnps.CardDataBase.D");
		packagePass.add("cnps.CardDataBase.C");
		packagePass.add("cnps.CardDataBase.B");
		packagePass.add("cnps.CardDataBase.A");
		packagePass.add("cnps.CardDataBase.S1");
	}
	
	
	
	/**
	 * カードを追加する
	 * （カードの追加先は、各カードが持つrarelityパラメータにより決定する）
	 * @param card
	 */
	private void addCard(Card card,int n){
		cardLists.get(n).getEdge(card.getRarelityNumber()).addCard(card);
	}
}
