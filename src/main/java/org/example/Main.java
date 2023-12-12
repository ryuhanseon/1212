package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<WiseSaying> wiseSayings = new ArrayList<>();
        System.out.println("==명언 앱==");
        int id = 1;
        while (true) {
            System.out.print("명령: ");
            String command = sc.nextLine();
            if (command.equals("등록")) {
                System.out.print("명언: ");
                String content = sc.nextLine();
                System.out.print("작가: ");
                String author = sc.nextLine();
                System.out.println(id + "번 값을 출력합니다.");
                WiseSaying saying = new WiseSaying(id, author, content);
                wiseSayings.add(saying);
                id++;
            } else if (command.equals("종료")) {
                break;
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("--------------");
                for (WiseSaying wiseSaying : wiseSayings) {
                    System.out.println(wiseSaying.getId() + "/" + wiseSaying.getContent() + "/" + wiseSaying.getAuthor());
                }
            } else if (command.equals("삭제")) {   //만약에 command의 값이 삭제라면
                System.out.print("삭제할 Id값을 입력해주세요: "); //"삭제할 Id값을 입력해주세요: " 라는 값을 출력한다.
                int deleteId = Integer.parseInt(sc.nextLine()); //정수형 변수에 deleteId라는 객체를 지정해주고 nextLine이 문자열이기 때문에 형변환을 위해 Interfer.parseInt를 이용한다.
                for (int i = 0; i < wiseSayings.size(); i++) { //for문을 이용해서 for문안에 int형의 i라는 객체에 0을 대입하고 i의 값을 증가시키고 삭제할 값을 넣어줘서
                    WiseSaying wiseSaying = wiseSayings.get(i); //wiseSaying
                    if (wiseSaying.getId() == deleteId) {
                        wiseSayings.remove(wiseSaying);
                    }
                }
                System.out.println(deleteId + "번 명언은 삭제되었습니다.");
            } else if (command.equals("수정")) {
                System.out.print("수정할 Id값을 입력해주세요: ");
                int modifyId = Integer.parseInt(sc.nextLine());

                for (int j = 0; j < wiseSayings.size(); j++) {
                    WiseSaying awiseSaying = wiseSayings.get(j);
                    System.out.printf("기존명언: %s \n", awiseSaying.getContent());
                    String content = sc.nextLine();
                    awiseSaying.setContent(content);

                    System.out.printf("기존작가: %s \n", awiseSaying.getAuthor());
                    String author = sc.nextLine();
                    awiseSaying.setAuthor(author);
                }
                System.out.println( modifyId+ "값이 수정되었습니다.");

            }
        }
        sc.close();
    }
}









