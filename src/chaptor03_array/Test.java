//package chaptor03_array;
//public class Test {
//	public static void main(String[] args) {
////		Phone com = new Phone();
////		com.setMemery(4);
////		com.setScreen(5.5);
////		Person p = new Person("张三",com);
////		p.chiken();
////		p.qq();
////		int num = (int)(Math.random() * (70 - 20)) + 20;
////		System.out.println(num);
//
//		String[] firstName = new String[]{"张","王","李","赵","周","吴","司马","欧阳"};
//		String[] lastName = new String[]{"飞","强","明月","娟","阳","浩然","长风","懿","梅"};
//		Student[] arr = new Student[8];
//
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = new Student();
//			arr[i].id = i + 1;
//			int index1 =(int)(Math.random() * firstName.length );
//			int index2 =(int)(Math.random() * firstName.length );
//			arr[i].name = firstName[index1] + lastName[index2];
//
//			arr[i].grade = (int)(Math.random() * (6 - 1 +1)) + 1;
//
//			int score = (int)(Math.random() * (100 - 0 + 1)) + 0;
//			arr[i].setScore(score);
//		}
//
//
//		//遍历
//		for(Student stu : arr){
//			System.out.println(stu.say());
//		}
//		System.out.println("**********************************");
//
//
//
//		/*for (int i = 0; i < arr.length; i++) {
//			if(arr[i].getGrade() == 3){
//				System.out.println(arr[i].say());
//			}
//		}
//		System.out.println("**********************************");*/
//
//
////		int sum = 0;
////		int count = 0;
////		for (int i = 0; i < arr.length; i++) {
////			if(arr[i].getScore() < 60){
////				System.out.println(arr[i].say());
////				sum +=arr[i].getScore();
////				count++;
////			}
////		}
////
////		System.out.println("不及格学生的总分："+sum);
////		if(count == 0){
////			System.out.println("所有人都及格了");
////		}else{
////			int avg = sum /count;
////			System.out.println("不及格人数"+count);
////			System.out.println("不及格学生的平均分："+avg);
////		}
//
//
////		int minScore = arr[0].getScore();
////		int index1 = 0;
////		int maxScore = arr[0].getScore();
////		int index2 = 0;
////		for (int i = 0; i < arr.length; i++) {
////			if(arr[i].getScore() < minScore){
////				minScore = arr[i].getScore();
////				index1 = i;
////			}
////			if(arr[i].getScore() > maxScore){
////				maxScore = arr[i].getScore();
////				index2 = i;
////			}
////		}
//						/*System.out.println("最小成绩是："+minScore);
//							System.out.println(arr[index1].say());
//															System.out.println();
//					System.out.println("最大成绩是："+maxScore);
//															System.out.println(arr[index2].say());
//
//					new HashMap();*/
//
//		/*int minScore = 101;          //0x7fffffff;
//		int index1 = 0;
//		int maxScore = -1;           //0x80000000;
//		int index2 = 0;
//		//找成绩最小的三年级的学生
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i].getGrade() == 3){
//				if(arr[i].getScore() < minScore){
//					minScore = arr[i].getScore();
//					index1 = i;
//
//				}
//			}
//			if(arr[i].getGrade() == 3 && arr[i].getScore() > maxScore){
//				maxScore = arr[i].getScore();
//				index2 = i;
//			}
//		}
//		if(minScore == 101 ){
//			System.out.println("没有3年级的学生");
//		}else{
//			System.out.println("最小成绩是："+minScore);
//			System.out.println(arr[index1].say());
//		}
//		if(maxScore == -1){
//			System.out.println("没有3年级的学生");
//		}
//		else{
//			System.out.println("最大成绩是："+maxScore);
//			System.out.println(arr[index2].say());
//		}*/
//
//
//
//		/*for(int i = 0;i < arr.length / 2;++i){
//			Student stu = arr[i];
//			arr[i] = arr[arr.length - 1 - i];
//			arr[arr.length - 1 -i] = stu;
//		}*/
//
//		/*for(int i = 0,j = arr.length - 1;i < j;++i,--j){
//			Student stu = arr[i];
//			arr[i] = arr[j];
//			arr[j] = stu;
//		}*/
//
//		/*//减半
//		Student[] newArr = new Student[arr.length /2];
//		for (int i = 0; i < newArr.length; i++) {
//			newArr[i] = arr[i];
//		}
//		arr = newArr;
//		*/
//		/*//扩容
//		Student[] newArr = new Student[arr.length * 3 / 2];
//		for (int i = 0; i < arr.length; i++) {
//			newArr[i] = arr[i];
//		}
//		arr = newArr;
//		//遍历
//		for(Student stu : arr){
//			if(stu != null){
//				System.out.println(stu.say());
//			}else{
//				System.out.println(stu);
//			}
//
//		}
//		System.out.println("**********************************");
//		*/
//
//		//三年级学生的对象数组
//		Student[] arr2 = new Student[arr.length];
//		int elems = 0;
//
//		//取出符合条件的数据，放在数组arr2中
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i].getGrade() == 3){
//				arr2[elems] = arr[i];
//				elems++;
//			}
//		}
//
//		//创建最终数组
//		Student[] arr3 = new Student[elems];
//		for (int i = 0; i < arr3.length; i++) {
//			arr3[i] = arr2[i];
//		}
//
//		//遍历最终数组
//		for(Student stu : arr3){
//				System.out.println(stu.say());
//		}
//	}
//}
