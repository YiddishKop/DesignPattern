// Test innerClass
public class TestInnter{
    public class pubClass{}
    protected class protClass{}
    private class priClass{}
    public void testInner1(){
        class Method_pub_Class{}
        class Method_prot_Class{}
        class Method_pri_Class{}
    }
    public void testInner2(){
        class Method_pub_Class{}
        class Method_prot_Class{}
        class Method_pri_Class{}
    }
}