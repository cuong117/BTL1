public class DictionaryCommandline {
    DictionaryManagement dim = new DictionaryManagement();
    public void showAllWord(){
        System.out.printf("NO\t| %s\t\t| %s\n","English","Vietnamese");
        int m = dim.d.num;
        for (int i = 0; i < m; i++) {
            System.out.printf("%d\t| %s\t\t\t| %s\n",i + 1,dim.d.dic[i].word_target,dim.d.dic[i].word_explain);
        }
    }
    public void dictionnaryBasic(){
        this.dim.insertFromCommandline();
        this.showAllWord();
    }
    public static void main(String[] args){
        DictionaryCommandline dcl = new DictionaryCommandline();
        dcl.dictionnaryBasic();
    }
}
