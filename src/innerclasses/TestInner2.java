public class TestInner2{
    public static void main(String[] args) {
        TestInnter ti = new TestInnter();
        TestInnter.pubClass pc = ti.new pubClass();
        Method_pub_Class mpc = ti.new Method_pub_Class();
        System.out.println("ti" + ti);
        System.out.println("pc" + pc);
        System.out.println("mpc" + mpc);
    }
}