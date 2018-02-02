import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUImain {
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUImain");
        frame.setContentPane(new GUImain().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,600);
        frame.setVisible(true);
    }

    private JButton startButton;
    private JButton saveButton;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public GUImain() {

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*创建词法分析类*/
                TestLexer testLexer = new TestLexer("./src/input.txt");
                //FileUtil.clearFile();//清空文件
                testLexer.analyse();
                textArea1.setText(TestLexer.buffer.toString());
                textArea2.setText("");
                textArea2.append(TestLexer.result);
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                SaveFile sf = new SaveFile();
//                sf.saveFile(this, TestLexer.result);
            }
        });
    }
}
