import java.util.ArrayList;

public class Sprint {
	private String sprintName;
	private int sprintNumber;
	private int totalValue;

	public Sprint(int num, int value) {
		num = sprintNumber;
		value = totalValue;
	}

	public String getName() {
		return sprintName;
	}

	public String setName() {
		return sprintName;
	}

	public int getSprintNumber() {
		return sprintNumber;
	}

	public int setSprintNumber() {
		return sprintNumber;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public int setTotalValue() {
		return totalValue;
	}
	//use toString to notify user
	public String toString(){
		return "Sprint "+sprintNumber+" has been created.";
	}
}
