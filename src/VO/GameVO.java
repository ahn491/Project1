package VO;

public class GameVO { // Java에 Data를 저장하고 DB에서 Data 불러오는 Class(member_score 테이블)
	String id;
	int game1;
	int game2;
	int sum;

	public GameVO() {
		
	}
	
	public GameVO(String id, int sum) {
		super();
		
		this.id = id;
		this.sum = sum;
	}

	public GameVO(String id, int game1, int game2) {
		super();
		
		this.id = id;
		this.game1 = game1;
		this.game2 = game2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGame1() {
		return game1;
	}

	public void setGame1(int game1) {
		this.game1 = game1;
	}

	public int getGame2() {
		return game2;
	}

	public void setGame2(int game2) {
		this.game2 = game2;
	}
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}