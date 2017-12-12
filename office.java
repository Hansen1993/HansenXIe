import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * 在这里给出对类 office 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class office
{
    private static SortedArrayList<Event> events = new SortedArrayList<Event>();
    private static SortedArrayList<Client> clients = new SortedArrayList<Client>();
    private static Scanner input = new Scanner(System.in);
    
    private static void printMenu()
    {
        System.out.println("############## Interactive System ##############");
        System.out.println("( f )- FINISH PROGRAM");
        System.out.println("( e )- DISPLAY ALL EVENTS");
        System.out.println("( c )- DISPLAY ALL CLIENTS");
        System.out.println("( b )- UPDATE DATA WHEN TICKETS ARE BOUGHT");
        System.out.println("( r )- UPDATE DATA WHEN TICKETS ARE RETURNED");   
    }
    private static Event getEObj(String str)
    {
        for (int i = 0; i < events.size(); i++)
        {
            if (events.get(i).getname().equals(str))
                return events.get(i);
        }
        return null;
    }
    private static Client getCObj(String cname)
    {
        for (int i = 0; i < clients.size(); i++)
        {
            String name = clients.get(i).getname();
            if (cname.equals(name))
            {
                return clients.get(i);
            }
        }
        return null;
    }
    
    public static void main(String[] args)throws Exception
    {
        loadFile();
        menuScreen();
    } 
    
    public static void menuScreen() throws Exception
    {
        String cName, eName;
        int num;
        Event eve;
        Client cli;
        //Scanner in = new Scanner(System.in);
        while(true)
        {
            printMenu();
            String decide = input.nextLine();
            switch(decide)
            {
                case "f": 
                    System.exit(0);
                    break;
                case "e":
                    for (int i = 0; i < events.size(); i++)
                    {
                        System.out.println(events.get(i).getname() + " " + events.get(i).getrestic());    
                    }
                    continue;
                case "c":
                    for (int i = 0; i < clients.size(); i++)
                    {
                        Client c = clients.get(i);
                        System.out.print(c.getname() + ":");
                        List<String> elist = c.getEvents();
                        List<Integer> ticNum = c.getTic();
                        if (elist.size() == 0)
                            System.out.println(" No ticket booked yet!");
                        else
                        {
                            System.out.println();
                            for (int j = 0; j < elist.size(); j++)
                            {
                                System.out.println(elist.get(j) + " " + ticNum.get(j));
                            }
                        }
                    }
                    continue;
                case "b":
                    System.out.println("Please Enter the information as Client Event numToBook for 3 lines");
                    cName = input.nextLine();
                    cli = getCObj(cName);
                    if (cli == null)
                    {
                        System.out.println("Wrong Client Name! Returning to Choosing Menu");
                        continue;
                    }
                    eName = input.nextLine();
                    eve = getEObj(eName);
                    if (eve == null) 
                    {
                        System.out.println("Wrong Event Name! Returning to Choosing Menu");
                        continue;
                    }
                    num = input.nextInt();
                    input.nextLine();
                
                    if (cli.ticBook(eve, num))
                    {
                        System.out.println("Book Success!");
                    }
                    break;
                case "r":
                    System.out.println("Please Enter the information as Client Event numToBook for 3 lines");
                    cName = input.nextLine();
                    cli = getCObj(cName);
                    if (cli == null)
                    {
                        System.out.println("Wrong Client Name! Returning to Choosing Menu");
                        continue;
                    }
                    eName = input.nextLine();
                    eve = getEObj(eName);
                    if (eve == null) 
                    {
                        System.out.println("Wrong Event Name! Returning to Choosing Menu");
                        continue;
                    }
                    num = input.nextInt();
                    input.nextLine();
                    if (cli.ticReturn(eve, num))
                    {
                        System.out.println("Return Success!");
                    }
                    break;
                default: 
                System.out.println("Wrong Input!");
        }
        }
    }
    
    public static void loadFile() throws Exception
    {
      //  Scanner in = new Scanner(new File("/Users/JohnsmithMBP/Desktop/input.txt"));
        Scanner in = new Scanner(new File("./input.txt"));
        int eNum = in.nextInt();
        in.nextLine();
        for (int i = 0; i < eNum; i++)
        {
            String eName = in.nextLine();
            int eRes = in.nextInt();
            in.nextLine();
            Event e = new Event(eName, eRes);
            events.add(e);
        }
        int cNum = in.nextInt();
        in.nextLine();
        for (int i = 0; i < cNum; i++)
        {
            String fname = in.next();
            String sname = in.next();
            Client c = new Client(fname, sname);
            clients.add(c);
        }
    }
}
