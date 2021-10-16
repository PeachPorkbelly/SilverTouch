package school;

import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class EngList {

    public ArrayList<String> kioskBook = new ArrayList<>();
    public ArrayList<String> itBook = new ArrayList<>();
    public ArrayList<String> everydayBook = new ArrayList<>();
    public ArrayList<Integer> kioskAudio = new ArrayList<>();
    public ArrayList<Integer> itAudio = new ArrayList<>();
    public ArrayList<Integer> dailyAudio = new ArrayList<>();


    public EngList(String bookName){

        if(bookName.equals("kiosk")){
            kioskBook.add("메뉴(Menu)\n차림표");
            kioskBook.add("윙(Wing)\n날개");
            kioskBook.add("드럼스틱(DrumStick)\n다리");
            kioskBook.add("프렌치프라이(FrenchFries)\n감자튀김");
            kioskBook.add("포테이토(Potato)\n감자");
            kioskBook.add("피클(Pickle)\n절임");
            kioskBook.add("디카페인(DeCaffeine)\n카페인이 없는");
            kioskBook.add("어니언(Onion)\n양파");
            kioskBook.add("제로음료수(ZeroDrink)\n설탕이 없는 음료수");
            kioskBook.add("드링크(Drink)\n음료수");

        }else if(bookName.equals("it")){
            itBook.add("와이파이(Wifi) : 무선 인터넷");

        }else if(bookName.equals("everyday")){
            everydayBook.add("토일렛(Toilet) : 화장실, 변기");
        }

    }
}
