
public class VariableScope {

	public static void main(String[] args) {
		Monster1 mon1 = new Monster1();
		Monster2 mon2 = new Monster2();
		Monster3 mon3 = new Monster3();
		
		
		mon1.raisehealth(3);
		mon2.lowerhealth(4);
		mon3.lowerhealth(6);
		
		System.out.println(mon1.gethp());
		System.out.println(mon2.gethp());
		System.out.println(mon3.gethp());
	}
	
}

class Monster1 {
	private int hp = 10;
	Monster1(){}
	
	int gethp(){
		return(this.hp);
	}
	void lowerhealth(int num){
		this.hp -= num;
	}
	void raisehealth(int num){
		this.hp -= num;
	}
}

class Monster2 {
	private int hp = 10;
	Monster2(){}
	int gethp(){
		return(this.hp);
	}
	void lowerhealth(int num){
		this.hp -= num;
	}
	void raisehealth(int num){
		this.hp -= num;
	}
}

class Monster3 {
	private int hp = 10;
	Monster3(){}
	int gethp(){
		return(this.hp);
	}
	void lowerhealth(int num){
		this.hp -= num;
	}
	void raisehealth(int num){
		this.hp -= num;
	}
}