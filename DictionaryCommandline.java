public class DictionaryCommandline {
    public void showAllWord(){
        System.out.printf("NO\t| %s\t\t| %s\n","English","Vietnamese");
        Dictionary d = new Dictionary();
        Word w1 = new Word("Hello","Xin chao");
        Word w2 = new Word("Hi","Chao");
        d.add(w1);
        d.add(w2);
        int m = d.num;
        for (int i = 0; i < m; i++) {
            System.out.printf("%d\t| %s\t\t\t| %s\n",i + 1,d.dic[i].word_target,d.dic[i].word_explain);
        }
    }
    public void dictionnaryBasic(){
        DictionaryManagement di = new DictionaryManagement();
        di.insertFromCommandline();
        this.showAllWord();
    }
    public static void main(String[] args){
        DictionaryCommandline dcl = new DictionaryCommandline();
        dcl.showAllWord();
       // dcl.dictionnaryBasic();


    }
}
