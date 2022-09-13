package algorithm.c8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S811 {
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            List<String> list = new ArrayList<>(); //结果集
            Map<String, Integer> map = new HashMap<>(); //存储子域名及其出现次数

            for (int i = 0; i < cpdomains.length; i++) {
                String[] ss = cpdomains[i].split(" "); //将cpdomains数组中的每个字符串的出现字数和地址分隔开
                int count = Integer.parseInt(ss[0]); //count为地址出现次数

                String[] splits = ss[1].split("\\."); //将地址中的每个子域名分隔开
                String s = "";
                for (int j = splits.length - 1; j >= 0; j--) {
                    s = splits[j] + "." + s;
                    if (map.containsKey(s.substring(0, s.length() - 1))) { //如果map中存在这个子域名，就修改map中该子域名对应的数量为原有数量+该地址的次数
                        map.put(s.substring(0, s.length() - 1), map.get(s.substring(0, s.length() - 1)) + count);
                    } else { //如果map中不存在这个子域名，则将该子域名及出现次数存储至map中
                        map.put(s.substring(0, s.length() - 1), count);
                    }

                }
            }
            //遍历map，并将得到的结果存入list中
            for (String str : map.keySet()) {
                list.add(map.get(str) + " " + str);
            }

            return list;
        }
    }
}
