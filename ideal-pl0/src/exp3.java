public class exp3 {
    public static void main(String[]args) throws Exception{
        /*创建词法分析类*/
        TestLexer testLexer = new TestLexer("./src/input.txt");
        //FileUtil.clearFile();//清空文件
        testLexer.analyse();
        exp2 ta=new exp2();
        ta.init();
        ta.analyze();
    }
}
