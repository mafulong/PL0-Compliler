import java.io.*;
import java.util.ArrayList;

public class exp2 {
    public int index;//list index
    String sym;//当前单元值
    ArrayList<d> dataList=new ArrayList<d>();//存储语法分析的源内容
    boolean res;
    /**
     * MAIN
     * @param args
     * @throws IOException
     */
    public static void main(String [] args) throws IOException {
        exp2 ta=new exp2();
        ta.init();
        ta.analyze();
    }

    /**
     * 初始化，读取词法分析结果，并转为List
     * @throws IOException
     */
    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./src/output.txt")));
        String data = null;
        while((data = br.readLine())!=null)
        {
//            System.out.println(data);
            int i;//获取“，”的位置,截取
            for(i=0;i<data.length();i++){
                if(data.charAt(i)==',')
                    break;
            }
            dataList.add(new d(data.substring(1,i),data.substring(i+1,data.length()-1)));
        }

        dataList.remove(dataList.size()-1);
//        for(int i=0;i<dataList.size();i++){
//            dataList.get(i).print();
//        }
    }

    /**
     * 语法分析
     */
    public void analyze(){
        res=false;
        index=-1;
        getsym();
        expression();
        if(res==true){
            System.out.println("right");
        }else{
            System.out.println("error");
        }
    }
    /**
     * 表达式
     */
    public void expression(){
//        System.out.println("expression:--------------");
        if (sym.equals("+") || sym.equals("-")) {
            getsym();
            term();
        }else{
            term();
        }
        while (sym.equals("+") || sym.equals("-")){
            getsym();
            term();
        }
    }

    /**
     * 项
     */
    public void term() {
//        System.out.println("term:--------------");
        factor();
        while(sym.equals("*") || sym.equals("/")){
            getsym();
            factor();
        }
    }

    /**
     * 因子
     */
    public void factor(){
//        System.out.println("factor:--------------");
        if(!dataList.get(index).a.equals("ident")) {
            if (!dataList.get(index).a.equals("number")) {
                if (sym.equals("(")) {
                    getsym();
                    expression();
                    if (sym.equals(")")) {
                        getsym();
                    } else
                        Rerror();
                } else
                    Rerror();
            } else
                getsym();
        }else
            getsym();

    }

    /**
     * 语法分析错误
     */
    public void Rerror(){
//        System.out.println("Error");
        res=false;
    }

    /**
     * 语法分析正确
     */
    public void Rright(){
//        System.out.println("Right");
        res=true;
    }

    /**
     * 获取d的第二位，index++
     * @return
     */
    public void getsym(){
        index=index+1;
        if(index==dataList.size()){
            Rright();
        }else{
            sym=dataList.get(index).b;
            System.out.println(sym);
        }
    }
}

/**
 * 数据单元：(a,b)，转为list单元
 */
class d{
    public d(String a,String b){
        this.a=a;
        this.b=b;
    }
    String a;
    String b;

    /**
     * 打印
     */
    public void print(){
        System.out.println("("+a+","+b+")");
    }
}