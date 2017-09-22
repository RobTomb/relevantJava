import java.awt.*;  
import javax.swing.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class two2eigthAndSixteen extends JFrame{  

    two2sixteen ttb = new two2sixteen();
    two2eight ttw = new two2eight();


    //-----------my self
    
    JPanel titleJP;
    JLabel title;

    JTextField input;
    JPanel inputJP;

    JPanel chooseJP;
    JLabel choose;
    JRadioButton weight , base;
    ButtonGroup btnGroup;

    JPanel transformJP;
    JLabel transformInfo;

    JTextField output;
    JPanel outputJP;

    JButton transformBtn;
    JButton resetBtn;
    JPanel transformjp;



    public static void main(String[] args) {  
        two2eigthAndSixteen win=new two2eigthAndSixteen();  
    }  
      
    //构造函数  
    public two2eigthAndSixteen(){  

        //设置布局管理  
        this.setLayout(new GridLayout(10, 1));//网格式布局  

        //-----1 
        title = new JLabel("请输入要转化的二进制数：");
        titleJP = new JPanel();
        titleJP.add(title);
        this.add(titleJP);        

        //-----2
        input = new JTextField(15);
        inputJP = new JPanel();
        inputJP.add(input);
        this.add(inputJP);

        //------3
        choose = new JLabel("选择使用的方法：");
        weight = new JRadioButton("ba jin zhi ");
        base = new JRadioButton("shi liu jin zhi");
        btnGroup = new ButtonGroup();
        btnGroup.add(weight);
        btnGroup.add(base);
        base.setSelected(true);
        chooseJP = new JPanel();
        chooseJP.add(choose);
        chooseJP.add(weight);
        chooseJP.add(base);
        this.add(chooseJP);

        //-------4
        transformInfo = new JLabel("转化的结果");
        transformJP = new JPanel();
        transformJP.add(transformInfo);
        this.add(transformJP);        
    
        //-------5
        output = new JTextField(15);
        outputJP = new JPanel();
        outputJP.add(output);
        this.add(outputJP);

        //------6
        transformBtn = new JButton("转化");
        resetBtn = new JButton("chongzhi");

        transformBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(weight.isSelected()){
                    output.setText(ttw.input(input.getText()));
                }else if(base.isSelected()){
                    output.setText(ttb.input(input.getText()));
                }
            }
        });
        resetBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clear();
            }
        });

        transformjp = new JPanel();
        transformjp.add(transformBtn);
        transformjp.add(resetBtn);
        this.add(transformjp);
                  
        //设置窗体  
        this.setTitle("进制转换");//窗体标签  
        this.setSize(500, 600);//窗体大小  
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出关闭JFrame  
        this.setVisible(true);//显示窗体  
          
        //锁定窗体  
        this.setResizable(false);  
    }  

    public void clear(){
        input.setText("");
        output.setText("");
    }
}  