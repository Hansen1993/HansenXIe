package coursework2;

import java.io.BufferedReader;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;  
import java.util.Iterator;
import java.util.List;
import java.util.Map;  
import java.util.Set;  
import java.util.StringTokenizer;  
import java.util.TreeMap;  
import java.util.TreeSet;  
import wordcont.WordEntity;
 
public class WordCont {
	 public void displayWordCount(String fileName){  
	        //字符统计  
	        try {  
	            BufferedReader reader = new BufferedReader(new FileReader(fileName));  
	            String line = null;  
	            TreeMap<String,Integer> tm = new TreeMap<String,Integer>();  
	              
	               line=reader.readLine();
	                line = line.toLowerCase();  
//	                String str[] = line.split("[ .]|, "); 
	                String str[] = line.split("[ .]|, ");  
	               ArrayList<String> list=new ArrayList<String>(Arrays.asList(str));
	                list.removeIf(n-> n.matches("[0-9]*"));
	                TreeMap< String, Integer> map=new TreeMap<String,Integer>();
	                for (String string : list) {
	                	if (!map.containsKey(string)) {
							map.put(string, 1);
						}
	                	else {
		                	map.put(string, map.get(string)+1);
						}
	                }
	                for (String string : map.keySet()) {
						System.out.println(String.format("%-30s", string)+map.get(string));
					}
	                
	                //	                for(int i = 0; i<str.length; i++){  
//	                    String word = str[i].trim();  
//	                    if(tm.containsKey(word)){  
//	                        tm.put(word, tm.get(word)+1);  
//	                    }else{  
//	                        tm.put(word, 1);  
//	                    }  
//	                }  
//	            }  
//	            //输出我们想要的字符串格式  
//	            System.out.println("按字典序输出为：");  
//	            Iterator iterator=tm.entrySet().iterator();  
//	            while(iterator.hasNext())  
//	            {  
//	                System.out.println(iterator.next());  
//	            }  
	            
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        }catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	      
//	    public void displayFrequencyWord(String fileName){  
//	        //显示输出  
//	        try {  
//	            BufferedReader br = new BufferedReader(new FileReader(fileName));  
//	            String s;  
//	            StringBuffer sb = new StringBuffer();  
//	            while ((s = br.readLine()) != null) {  
//	                sb.append(s);  
//	            }  
//	              
//	            Map<String,Integer> map = new HashMap<String, Integer>();  
//	            StringTokenizer st = new StringTokenizer(sb.toString(),",.! \n");  
//	            while (st.hasMoreTokens()) {  
//	                String letter = st.nextToken().trim();  
//	                int count;  
//	                if (!map.containsKey(letter)) {  
//	                    count = 1;  
//	                } else {  
//	                    count = map.get(letter).intValue() + 1;  
//	                }  
//	                map.put(letter,count);  
//	            }  
//	              
//	            Set<WordEntity> set = new TreeSet<WordEntity>();  
//	            for (String key : map.keySet()) {  
//	                set.add(new WordEntity(key,map.get(key)));  
//	            }  
//	  
//	            System.out.println("出现频率最高的单词：");  
//	            Iterator<WordEntity> it1 = set.iterator();  
//	            int count=it1.next().getCount();  
//	            for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {  
//	                WordEntity w = it.next();  
//	                  
//	                if (w.getCount()==count)// 当输出3个后跳出循环  
//	                    //break;  
//	                  
//	                System.out.println(w.getKey() + " 出现的次数为： "+ w.getCount());  
//	                  
//	            }  
//	        } catch (FileNotFoundException e) {  
//	            System.out.println("文件未找到~！");  
//	        } catch (IOException e) {  
//	            System.out.println("文件读异常~！");  
//	        }  
//	  
//	    } 
}
