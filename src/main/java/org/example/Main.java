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
            System.out.println("명령: ");
            String command = sc.nextLine();
            if (command.equals("등록")) {
                System.out.println("명언: ");
                String content = sc.nextLine();
                System.out.println("작가: ");
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
                    System.out.println(wiseSaying.getId() + wiseSaying.getContent() + wiseSaying.getAuthor());
                }
            } else if (command.equals("삭제")) {
                System.out.println("삭제할 값을 입력해주세요: ");
                int delete = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < wiseSayings.size(); i++) {
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    if (wiseSaying.getId() == delete) {
                        wiseSayings.remove(wiseSaying);
                    }
                }
                System.out.println(delete + "번 명언은 삭제되었습니다.");
            }
            else if (command.equals("수정")) {
                System.out.println("수정할 값을 입력해주세요: ");
                int modify = Integer.parseInt(sc.nextLine());
                for (int j = 0; j < wiseSayings.size(); j++) {
                    WiseSaying awiseSaying = wiseSayings.get(j);
                    System.out.printf("기존명언: %s \n", awiseSaying.getContent());
                    String content = sc.nextLine();
                    awiseSaying.setContent(content);

                    System.out.printf("기존작가: %s \n", awiseSaying.getAuthor());
                    String author = sc.nextLine();
                    awiseSaying.setAuthor(author);

                }
                System.out.println(id + "값이 수정되었습니다.");
            }
        }sc.close();
    }
}









