package chaptor15_exam.Exam;
public enum Weekday {
	monday("周一","不爽"),
	tuesday("周一","不爽"),
	wednesday("周一","不爽"),
	thursday("周一","不爽"),
	friday("周一","不爽"),
	saturday("周一","不爽"),
	sunday("周一","不爽");
	
	private final String name;
	private final String desc;
	private Weekday(String name,String desc){
		this.name = name;
		this.desc =desc;
	}
}
