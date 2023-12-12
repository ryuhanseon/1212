package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main { //Main 클래스를 지정
    public static void main(String[] args) { //main 메서드를 지정
        Scanner sc = new Scanner(System.in); // 각 출력을 위한 Scanner를 실행
        List<WiseSaying> wiseSayings = new ArrayList<>();  //ArrayList를 이용해서 wiseSaying객체를 만들고 wiseSaying을 이용해서 명령들을 입출력하는 로직을 작성할 때 도움을 줍니다.
        System.out.println("==명언 앱==");  //"==명언 웹==" 이라는 것을 출력
        int id = 1;  // int 타입의 변수 id의 값을 1로 초기화
        while (true) {  //반복문 안에 true값을 이용해서 무한루프를 돌린다.
            System.out.print("명령: ");  //명령을 출력한다.
            String command = sc.nextLine();  //문자열 String를 command라 정하고 스캐너의 sc를 이용해서 바로위의 명령에 값을 넣을 수 있게끔한다.
            if (command.equals("등록")) {   // 명령으로 command의 값이 "등록"이라 입력하면 명언으로 이동한다.
                System.out.print("명언: ");  // 명언: 을 출력한다.
                String content = sc.nextLine();  //content를 지정해주고 바로 위 명언에 입력을 받을 수 있게끔 한다.
                System.out.print("작가: ");  // 작가: 를 출력한다.
                String author = sc.nextLine(); //author를 지정해주고 바로 위 작가에 값을 입력해줄수 있게끔 한다.
                System.out.println(id + "번 Id값을 출력합니다.");  // 반복문 밖에 있는 id의 값과 나머지 "번 명언이 등록 되었습니다.를 출력해준다.
                WiseSaying saying = new WiseSaying(id, author, content); // wiseSaying의 객체를 지정해주고 그 안에다 각 id, author, content의 값을 넣어준다.
                wiseSayings.add(saying);  // wiseSayings을 이용해서 saying의 값을 넣어준다.
                id++;  // id의 값이 늘어날 수 있게끔 ++를 붙여준다.
            } else if (command.equals("종료")) {  //반복문안에서 if문을 사용해서 종료를 만들어준다.
                break;  //종료를 입력하면 반복문에서 탈출할 수 있게 해준다.
            } else if (command.equals("목록")) {  // 종료나 등록 이외가 목록일 시
                System.out.println("번호 / 작가 / 명언");  // 번호 작가 명언을 출력한다.
                System.out.println("--------------");    //문자열  --------------를 출력한다.
                for (WiseSaying wiseSaying : wiseSayings) { //for each문안에서 WiseSaying을 이용해서 목록에 들어갈 값을 돌린다.
                    System.out.println(wiseSaying.getId() + "/" + wiseSaying.getContent() + "/" + wiseSaying.getAuthor());
                }   //목록의 값을 출력해주기 위해서 wiseSaying을 이용해서 각 getter의 값을 불러와준다.
            } else if (command.equals("삭제")) { //명령을 시행해서 삭제를 입력하면
                System.out.print("삭제할 Id값을 입력해주세요: "); //"삭제할 값을 입력해주세요: " 를 출력합니다.
                int deleteId = Integer.parseInt(sc.nextLine()); //정수의 값을 받는 deleteId 객체를 생성하고 문자열을 대신하는 정수형으로 형변환을 시켜준다.
                for (int i = 0; i < wiseSayings.size(); i++) { //삭제를 시행시 값을 for문을 이용해서 삭제에 들어갈 값을 확인합니다.
                    WiseSaying wiseSaying = wiseSayings.get(i); //wiseSaying 객체를 이용해서 for문을 이용할 수 있게 해줍니다.
                    if (wiseSaying.getId() == deleteId) { // if문을 사용해서 getterId의 값을 호출하고 deleteId의 값을 대입해줍니다.
                        wiseSayings.remove(wiseSaying); //arraylist를 사용해서 제거해줍니다.
                    }
                }
                System.out.println(deleteId + "번 명언은 삭제되었습니다."); //deleteId 값과 나머지 문자열을 출력해줍니다.
            } else if (command.equals("수정")) { //명령으로 수정을 시행합니다.
                System.out.print("수정할 Id값을 입력해주세요: "); //"수정할 값을 입력해주세요: " 를 출력합니다.
                int modifyId = Integer.parseInt(sc.nextLine()); //정수의 값을 받는 modifyId 객체를 지정하고 정수타입으로 형변환을 시켜줍니다.

                for (int j = 0; j < wiseSayings.size(); j++) { //for문을 사용해서 수정값에 들어갈 값을 돌려봅니다.
                    WiseSaying awiseSaying = wiseSayings.get(j); //awiseSaying 객체를 이용해서 for문을 도와줍니다.
                    System.out.printf("기존명언: %s \n", awiseSaying.getContent()); //기존명언 정수와 줄바꿈을 넣어주고 명언의 getter값을 가져옵니다.
                    String content = sc.nextLine(); //기존에 정했던 명언객체와 바로 위의 기존명언에 입력할 수 있게 해줍니다.
                    awiseSaying.setContent(content); //기존에 있던 명언을 고쳐주기 위해서 setter를 이용해줍니다.

                    System.out.printf("기존작가: %s \n", awiseSaying.getAuthor()); //기존작가 정수, 줄바꿈을 하고 작가의 getter를 가져옵니다.
                    String author = sc.nextLine(); //기존에 정했던 작가객체와 바로 위의 기존작가에 입력을 할 수 있게끔 해줍니다.
                    awiseSaying.setAuthor(author); //기존에 있던 작가를 고쳐주기 위해서 setter를 이요해줍니다.
                }
                System.out.println( modifyId+ "Id값이 수정되었습니다."); //modifyId값과 나머지 문자열을 출력해줍니다.

            }
        }
        sc.close(); //반복문을 닫습니다.
    }
}