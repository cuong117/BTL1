import java.util.ArrayList;
import java.util.Scanner;
public class DictionaryCommandline {
    DictionaryManagement dim = new DictionaryManagement();
    public void showAllWord(){
        System.out.printf("NO\t| %s\t\t| %s\n","English","Vietnamese");
        int m = Dictionary.dic.size();
        for (int i = 0; i < m; i++) {
            System.out.printf("%d\t| %s\t\t\t| %s\n",i + 1,Dictionary.dic.get(i).word_target
                    ,Dictionary.dic.get(i).word_explain);
        }
    }
    public void dictionnaryBasic(){
        this.dim.insertFromCommandline();
        this.showAllWord();
    }
    public void dictionaryAdvance(){
        this.dim.insertFromFile();
        this.showAllWord();
        //this.dim.dictionaryLookup();
    }
    public ArrayList<String> dictionarySearcher(String s) {
        String str = s.trim().toLowerCase();
        int m = Dictionary.dic.size();
        ArrayList<String> a = new ArrayList<String>();
        for(int i = 0; i < m; i++) {
            String st = Dictionary.dic.get(i).word_target;
            if(st.contains(str) && st.charAt(0) == str.charAt(0) )
                a.add(st);
        }
        return a;
    }
    public static void main(String[] args){
        DictionaryCommandline dcl = new DictionaryCommandline();
        dcl.dictionaryAdvance();
        //dcl.dim.management();
        //dcl.showAllWord();
        //dcl.dim.insertFromCommandline();
        //dcl.showAllWord();
        //dcl.dim.dictionaryExportToFile();
        ArrayList<String> a = dcl.dictionarySearcher("ab");
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
    }
}
