package Exercises.dsaProblems;

import java.util.*;

public class CountMentionPerUser {
    public static void main(String[] args) {
        List<List<String>> e = new ArrayList<>(List.of(new ArrayList<>(List.of("MESSAGE","2","HERE")),new ArrayList<>(List.of("OFFLINE","2","1")),new ArrayList<>(List.of("OFFLINE","1","0"))
                ,new ArrayList<>(List.of("MESSAGE","61","HERE"))));
        int[] res = countMentions(3, e);
        for (int i = 0; i < res.length ; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
//        Map<Integer, Integer> hm = new HashMap<>();
//        int[] men = new int[numberOfUsers];
//        Collections.sort(events, (a, b) -> {
//            int timeA = Integer.parseInt(a.get(1));
//            int timeB = Integer.parseInt(b.get(1));
//            if (timeA != timeB) {
//                return Integer.compare(timeA, timeB);
//            } else {
//                return a.get(0).equals("OFFLINE") ? -1 : 1;
//            }
//        });
//        System.out.println(events);
//        for (int i = 0; i < numberOfUsers; i++) {
//            hm.put(i,0);
//        }
//        for (int i = 0; i < events.size(); i++) {
//            switch (events.get(i).get(0)){
//                case "MESSAGE":
//                    switch (events.get(i).get(2)) {
//                        case "HERE":
//                            for (Map.Entry<Integer,Integer> e:hm.entrySet()){
//                                if (e.getValue()==0)
//                                    men[e.getKey()]++;
//                                else if (e.getValue()<= Integer.parseInt(events.get(i).get(1))) {
//                                    men[e.getKey()]++;
//                                }
//                            }
//                            break;
//                        case "ALL":
//                            for (Map.Entry<Integer,Integer> e:hm.entrySet()){
//                                men[e.getKey()]++;
//                            }
//                            break;
//                        default:
//                            String[] str = events.get(i).get(2).split(" ");
//                            for (String s: str){
//                                if (s.startsWith("id")) {
//                                    int userId = Integer.parseInt(s.substring(2));
//                                    men[userId]++;
////                                    mentionedUsers.add(userId);
//                                }
//                            }
//
//                    }
//                    break;
//                case "OFFLINE":
//                    int t = Integer.parseInt(events.get(i).get(2));
//                    hm.put(t,hm.get(t)+(Integer.parseInt(events.get(i).get(1))+60));
//                    break;
//            }
//        }
//        return men;
//    }
        int[] mentions=new int[numberOfUsers];
        int[] offTime=new int[numberOfUsers];

        Collections.sort(events, (a,b)->Integer.parseInt(a.get(1))==Integer.parseInt(b.get(1))? b.get(0).compareTo(a.get(0)): Integer.parseInt(a.get(1))-Integer.parseInt(b.get(1))
        );

        for(int i=0; i<events.size(); i++){
            if(events.get(i).get(0).equals("MESSAGE")){
                messageFunc(events.get(i), mentions, offTime);
            }
            else if(events.get(i).get(0).equals("OFFLINE")){
                offlineFunc(events.get(i), mentions, offTime);
            }
        }

        return mentions;
    }

    static void messageFunc(List<String> event, int[] mentions, int[] offTime){
        int time=Integer.parseInt(event.get(1));
        String[] str=event.get(2).split(" ");

        for(String s:str){
            if(s.equals("ALL")){
                for(int i=0; i<mentions.length; i++){
                    mentions[i]+=1;
                }
            }
            else if(s.equals("HERE")){
                for(int i=0; i<mentions.length; i++){
                    if(offTime[i]==0){ //Only online
                        mentions[i]+=1;
                    }
                    else if(offTime[i]+60<=time){
                        mentions[i]+=1;
                        offTime[i]=0;
                    }
                }
            }
            else{
                int idx=Integer.parseInt( s.substring("id".length()) );
                mentions[idx]+=1;
            }
        }
    }

    static void offlineFunc(List<String> event, int[] mentions, int[] offTime){
        int time=Integer.parseInt(event.get(1));
        String[] str=event.get(2).split(" ");

        for(String s:str){
            int idx=Integer.parseInt(s);
            offTime[idx]=time;
        }
    }
}
