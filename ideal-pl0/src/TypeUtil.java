import java.util.*;
/**
 * 对读取字符分类相关操作,父类
 * @author mfl
 */
public class TypeUtil {
    //dec new add by mfl:
    private final String keyWords[] = {"begin","call","const","do","end","if","odd","procedure","read",
            "then","var","while","write"}; // 关键字数组
    public final static Map<String,String> map = new HashMap();     
    public final String keyWordsEncoding[]={"beginsym","callsym","constsym","dosym","endsym",
    "ifsym","oddsym","proceduresym","readsym","thensym","varsym","whilesym","writesym"};
    public final String operatorsEncoding[]={"plus","minus","times","slash","eql","neq","lss",
    "leq","gtr","geq","becomes",":"};
    public final String separatorsEncoding[]={"Lparen","rparen","comma","semicolon","period"};
    private final String operators[] = {"+","-","*","/","=","<>","<","<=",">",">=",":=",":"};
    public final String separtors[]={"(", ")", ",", ";", "."};

    /**
     * 构造函数,init
     */
    public TypeUtil(){
        initialize();
    }

    /**
     * 初始化map，建立映射编码
     */
    public void initialize(){
        map.clear();
        for(int i=0;i<keyWords.length;i++){
            map.put(keyWords[i], keyWordsEncoding[i]);
        }
        for(int i=0;i<operators.length;i++){
            map.put(operators[i], operatorsEncoding[i]);
        }
        for(int i=0;i<separtors.length;i++){
            map.put(separtors[i], separatorsEncoding[i]);
        }
    }

    /**
     * 获取map  value
     * @param str map key
     * @return map value
     */
    public String getValue(String str){
        return map.get(str);
    }
    /**
     * 判断是否为字母
     * @param ch 需判断的字符
     * @return boolean
     */
    public boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    /**
     * 判断是否为数字
     * @param ch 需判断的字符
     * @return boolean
     */
    public boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }
    /**
     * 判断是否为关键字
     * @param s 需判断的字符串
     * @return boolean
     */
    public boolean isKeyWord(String s) {
        for (int i = 0; i < keyWords.length; i++) {
            if (keyWords[i].equals(s))
                return true;
        }
        return false;
    }

    /**
     * 判断是否为运算符
     * @param ch 需判断的字符
     * @return boolean
     */
    public boolean isOperator(char ch) {
        for (int i = 0; i < operators.length; i++) {
            if (Character.toString(ch).equals(operators[i]))
                return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为操作符
     * @param ch 字符串
     * @return boolean
     */
    public boolean isOperator1(String ch) {
        for (int i = 0; i < operators.length; i++) {
            if (ch.equals(operators[i]))
                return true;
        }
        return false;
    }

    /**
     * 判断是否为分隔符
     * @param ch 需判断的字符
     * @return boolean
     */
    public boolean isSeparators(char ch) {
        for (int i = 0; i < separtors.length; i++) {
            if (Character.toString(ch).equals(separtors[i]))
                return true;
        }
        return false;
    }
}
