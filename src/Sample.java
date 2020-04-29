public class Sample {
    public int v = 1;

    public Sample() {
        System.out.println("Sample is loaded by :" + this.getClass().getClassLoader());
        //System.out.println("Sample  :" + Code02_Sample.class.getClassLoader());
        //new Dog();
    }

}
