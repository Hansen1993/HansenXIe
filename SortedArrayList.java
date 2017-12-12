import java.util.ArrayList;
/**
 * 在这里给出对类 SortedArrayList 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class SortedArrayList <E extends Comparable<E>> extends ArrayList<E>
{
    public boolean add(E e)
    {
        if (super.size() == 0)
        {
            return super.add(e);
        }
        else
        {
            int i;
            for(i = 0; i < super.size(); i++)
            {
                if (e.compareTo(super.get(i)) < 0)
                break;
            }
            super.add(i, e);
            return true;
        }
    }

 

}
