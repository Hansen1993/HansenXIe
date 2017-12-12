
/**
 * 在这里给出对类 Event 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Event implements Comparable<Event>
{
    // 实例变量 - 用你自己的变量替换下面的例子
    private int id;
    private int restic;
    private String name;
    
    Event(String name, int restic)
    {
        this.name = name;
        this.restic = restic;
    }
    
    public String getname()
    {
        return name;
    }
    
    public int getrestic()
    {
        return restic;
    }
    
    public boolean adjust(int num)
    {
        int tic = restic + num;
/*        if (tic < 0)
            return false;
        else 
        {
            restic = tic;  */
        restic = tic;
        return true;
        
    }
    
    @Override
    public int compareTo(Event e)
    {
        return this.name.compareTo(e.name);
    }

}


