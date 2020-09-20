public class Dictionary {
    public static Word[] dic = new Word[100];
    public int num = 0;
    public void add(Word w) {
        if (num < 100) {
            dic[num] = w;
            num++;
        }
    }


}
