import java.util.*;
/**
 * 在这里给出对类 Client 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Client implements Comparable <Client>
{
    // 实例变量 - 用你自己的变量替换下面的例子
    private String firstname;
    private String surname;
    private int id;
    private List<String> elist;
    private List<Integer> ticNum;
    
    Client(String firstname, String surname)
    {
        this.firstname = firstname;
        this.surname = surname;
        elist = new ArrayList<String>();
        ticNum = new ArrayList<Integer>();
    }
    
    public String getname()
    {
        String name = firstname + ' ' + surname;
        return name;
    }
    
    public List<String> getEvents()
    {
        return elist;
    }
    
    public List<Integer> getTic()
    {
        return ticNum;
    }
    
    @Override
    public int compareTo(Client c)
    {
        int r1 = surname.compareTo(c.surname);
        if (r1 != 0)
            return firstname.compareTo(c.firstname);
        else 
            return r1;
    }

    public boolean ticBook(Event e, int num) 
    {
        int restic = e.getrestic();
        String eName = e.getname();
        if (restic < num)
        {
            System.out.println("No enough tickets left!");
            return false;
        }
        else
        {
            e.adjust(-num);
            int k = elist.indexOf(eName);
            if (k < 0)
            {
                elist.add(eName);
                ticNum.add(num);
            }
            else
            {
                ticNum.set(k, ticNum.get(k) + num);
            }
            return true;
        }
    }
    
    public boolean ticReturn(Event e, int num)
    {
        String eName = e.getname();
        int k = elist.indexOf(eName);
        if (k < 0 || (ticNum.get(k) < num))
        {
            System.out.println("Haven't book those tickets");
            return false;
        }
        else
        {
            e.adjust(num);
            ticNum.set(k, ticNum.get(k) - num);
            return true;
        }
    }
    
}



    

