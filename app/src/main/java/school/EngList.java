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
            itBook.add("와이파이(Wifi) : 무료\n인터넷");
            itBook.add("데이터(Data) : 유료\n인터넷");
            itBook.add("로그아웃(Logout)\n내 계정 접속 끊기");
            itBook.add("로그인(Login)\n내 계정으로 접속하기");
            itBook.add("사인업(Sign Up)\n회원가입");
            itBook.add("사인인(Sign In)\n내 계정으로 접속하기");
            itBook.add("플래시 라이트(Flash Light)\n손전등");
            itBook.add("페이(Pay)\n지불,돈을 내다");
            itBook.add("월렛(Wallet)\n지갑");
            itBook.add("랩탑(Laptop)\n노트북");
            itBook.add("어그리(Agree)\n동의하다");
            itBook.add("디스어그리(Disagree)\n비동의하다");
            itBook.add("인스톨(Install)\n설치하다");
            itBook.add("캔슬(Cancle)\n취소하다");
            itBook.add("업로드(Upload)\n인터넷 공간에 자료를 보낸다");
            itBook.add("다운로드(Download)\n인터넷에서 자료를 가져온다");

        }else if(bookName.equals("daily")){
            everydayBook.add("토일렛(Toilet)\n화장실, 변기");
            everydayBook.add("북(Book)\n책");
            everydayBook.add("토일렛페이퍼(Toilet Paper)\n휴지");
            everydayBook.add("프라이스(Price)\n가격");
            everydayBook.add("헤어(Hair)\n머리카락");
            everydayBook.add("커트러리");
            everydayBook.add("컬쳐");
            everydayBook.add("에듀케이션");
            everydayBook.add("캐쉬");
            everydayBook.add("시트");
            everydayBook.add("머신");
            everydayBook.add("오피스");
            everydayBook.add("일렉션");
            everydayBook.add("배틀");
            everydayBook.add("시즌");
        }

    }
}
