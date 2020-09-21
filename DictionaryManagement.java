import java.util.Scanner;
public class DictionaryManagement {
    public Dictionary d = new Dictionary();
    public void insertFromCommandline(){
        Scanner s = new Scanner(System.in);
        int d;

        System.out.println("Nhap so tu: ");
        d=s.nextInt();
        s.nextLine();
        for(int i = 0; i < d; i++){
            Word w = new Word();
             w.word_target = s.nextLine();
             w.word_explain = s.nextLine();
             this.d.add(w);
        }
    }
}
