import java.util.ArrayList;

public class Dictionary {
    public static ArrayList<Word> dic = new ArrayList<Word>();
    public static void add(Word w) {
        dic.add(w);
    }
    public static void sort() {
        Word[] a = new Word[dic.size()];
        sort(a,0, dic.size() - 1);
    }
    public static void sort(Word[] a,int min,int max){
        if(min >= max)
            return ;
        int mid = (min + max)/2;
        sort(a,min,mid);
        sort(a,mid + 1,max);
        merg(a,min,mid,max);
    }
    public static void merg(Word[] a,int min,int mid,int max){
        for(int x = min; x <= max; x++ ){
            a[x] = dic.get(x);
        }
        int i = min, j = mid + 1;
        for(int k = min; k < max + 1; k++){
            if(i > mid){
                dic.set(k,a[j]);
                j++;
            }
            else if(j > max){
                dic.set(k,a[i]);
                i++;
            }
            else if(a[i].word_target.compareTo(a[j].word_target) < 0) {
                dic.set(k, a[i]);
                i++;
            }
            else{
                dic.set(k, a[j]);
                j++;
            }
        }
    }
}
