//import java.util.*;
//
//public class FullCountSortNM {
//
//    public static void countSort(List<List<String>> arr) {
//        int size = arr.size();
//        Collections.sort(arr);
//        int max = ; // collection
//
//        List<List<String>> list = new ArrayList<>();
//        // create output list
//        for (int j = 0; j < max+1; j++){ // O(
//            list.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < size; i++){
//            if (i < size/2) list.get(Integer.valueOf(arr.get(i).get(0))).add("-");
//            else {
//                list.get(Integer.valueOf(arr.get(i).get(0))).add(arr.get(i).get(1));
//            }
//        }
//
////        Iterator<List<String>> outerIter = list.iterator();
//
////        while(outerIter.hasNext()) {
////            Iterator<String> innerIterator = outerIter.next().iterator();
////            while (innerIterator.hasNext()){
////                System.out.print(innerIterator.next());
////                System.out.print(" ");
////            }
////        }
//
//    }
//
//
//    public static void main(String[] args) {
//            List<String> innerlist1= new ArrayList<>();
////        List<Integer> innerlist1= new ArrayList<>();
//            List<String> innerlist2= new ArrayList<>();
//            List<String> innerlist3= new ArrayList<>();
//            List<String> innerlist4= new ArrayList<>();
//            List<String> innerlist5= new ArrayList<>();
//            List<String> innerlist6= new ArrayList<>();
//            List<String> innerlist7= new ArrayList<>();
//            List<String> innerlist8= new ArrayList<>();
//            List<String> innerlist9= new ArrayList<>();
//            List<String> innerlist10= new ArrayList<>();
//
//            innerlist1.add("1");
//            innerlist1.add("e");
//
//            innerlist2.add("2");
//            innerlist2.add("a");
//
//            innerlist3.add("1");
//            innerlist3.add("b");
//
//            innerlist4.add("3");
//            innerlist4.add("a");
//
//            innerlist5.add("4");
//            innerlist5.add("f");
//
//            innerlist6.add("1");
//            innerlist6.add("f");
//
//            innerlist7.add("2");
//            innerlist7.add("a");
//
//            innerlist8.add("1");
//            innerlist8.add("e");
//
//            innerlist9.add("1");
//            innerlist9.add("b");
//
//            innerlist10.add("1");
//            innerlist10.add("c");
//
//            List<List<String>> outer = new ArrayList<>();
//            outer.add(innerlist1);
//            outer.add(innerlist2);
//            outer.add(innerlist3);
//            outer.add(innerlist4);
//            outer.add(innerlist5);
//            outer.add(innerlist6);
//            outer.add(innerlist7);
//            outer.add(innerlist8);
//            outer.add(innerlist9);
//            outer.add(innerlist10);
//
//            long startTime = System.nanoTime();
//            countSort(outer);
//            long endTime   = System.nanoTime();
//            long totalTime = endTime - startTime;
//            System.out.println(totalTime/1000);
//        }
//
//    }
//
