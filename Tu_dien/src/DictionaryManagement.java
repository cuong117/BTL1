import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
public class DictionaryManagement {
    public void insertFromCommandline(){
        Scanner s = new Scanner(System.in);
        int d;

        System.out.println("Nhap so tu: ");
        d=s.nextInt();
        s.nextLine();
        for(int i = 0; i < d; i++){
            Word w = new Word();
            System.out.println("nhập từ tiếng anh: ");
             w.word_target = s.nextLine();
             System.out.println("nhập giải nghĩa: ");
             w.word_explain = s.nextLine();
             Dictionary.add(w);
        }
        Dictionary.sort();
    }
    public void insertFromFile(){
        Scanner s = null;
        File text = new File("dictionaries.txt");
        try {
             s = new Scanner(text);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(s.hasNext()){
            Word w = new Word();
            w.word_target = s.next();
            w.word_explain = s.nextLine().trim();
            Dictionary.add(w);
        }
    }
    public String dictionaryLookup(String s){

        String st = s.trim().toLowerCase();
        for (int i = 0; i < Dictionary.dic.size(); i++) {
            if (st.equals(Dictionary.dic.get(i).word_target)) {
                return Dictionary.dic.get(i).word_explain;
            }
        }
        return "Không Tìm Thấy Dữ Liệu";
    }

    public void management() {
        System.out.println("Bạn muốn thêm từ (nhập 1)");
        System.out.println("Bạn muốn sửa từ (nhập 2)");
        System.out.println("Bạn muốn xóa từ (nhập 3)");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            this.insertFromCommandline();
        }
        else if(n == 2) {
            System.out.println("nhập từ tiếng anh cần sửa nghĩa: ");
            String str = sc.next();
            System.out.println("nhập giải nghĩa mới: ");
            String str1 = sc.next();
            for(int i = 0; i < Dictionary.dic.size(); i++){
                if(str.compareTo(Dictionary.dic.get(i).word_target) == 0) {
                    Dictionary.dic.get(i).word_explain = str1;
                }
            }
        }
        else if(n == 3) {
            System.out.println("nhập từ cần xóa");
            String str = sc.next();
            for(int i = 0; i < Dictionary.dic.size(); i++){
                if(str.equals(Dictionary.dic.get(i).word_target)){
                    Dictionary.dic.remove(i);
                    break;
                }
            }
        }
        else
            System.out.println("nhập lại: ");
    }

    public void dictionaryExportToFile() {
        int m = Dictionary.dic.size();
        try {
            File f = new File("a.txt");
            FileWriter fw = new FileWriter(f);
            for(int i = 0; i < m ; i++) {
                fw.write(Dictionary.dic.get(i).word_target + " " + Dictionary.dic.get(i).word_explain + "\n");
            }
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }
}
