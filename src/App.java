import java.util.*;


class Contact {
    private String name, group, number;
    // Contact 클래스의 인스턴스 변수들. 외부에서의 변수 접근을 막기 위해 접근제어자 private 사용하여 캡슐화
    // 캡슐화란? 접근제어자를 통해 변수의 직접적인 접근을 막고 메서드로의 간접적인 통제만 하게 하는 것.

    Contact (String name, String number, String group) {
        this.name = name;
        this.number = number;
        this.group = group;
    }
    // 참조변수 this 사용
    // 클래스의 인스턴스 변수와 매개변수가 같을 경우, 둘을 구별하기 위해 인스턴스 변수에 자기 자신을 의미하는 this를 붙인다.

    void setName(String name) {
        if (name=="") {
            System.out.println("이름으로 공백을 입력할 수는 없습니다.");
        } else {
            this.name=name;
        }
    }

    void setNumber(String number) {
        if (number.startsWith("010") && number.length()==11 ) {
            this.number=number;
        } else {
            return;
        }
    }

    void setGroup(String group) {
        this.group=group;
    }
    // private로 캡슐화되어 보호받는 인스턴스 변수들을 정의하기 위해 setter 메서드를 사용했다.
    // 이 메서드 사용을 통해 조건에 맞지 않는 입력값을 걸러내어 변수를 안전하게 정의할 수 있다.

    String getName() {
        return name;
    }

    String getNumber() {
        return number;
    }

    String getGroup() {
        return group;
    }
    // private로 캡슐화된 변수들의 입력값을 외부로 꺼내기 위해 getter 메서드를 사용했다.
    // 이 메서드 사용을 통해 값을 읽어올 때도 안전하게 읽을 수 있다.



    static void addContact() {
        Scanner sc = new Scanner(System.in);

        System.out.println("이름: ");
        String name = sc.next();

        System.out.println("전화번호: ");
        String number = sc.next();

        System.out.println("그룹: ");
        String group = sc.next();

        Contact t = new Contact(name, number, group);

        System.out.println(t);
        
        
    }

    // ! main 메서드에서 직접 호출하기 위해 static 메서드로 바꿔야 함.
    // 근데 이렇게 하니 static 메서드라 setter를 통해 private화 된 변수에 접근할 수가 없음. 어떻게 해야 하는지?
    // this는 인스턴스의 참조를 가리키고 static 메서드는 인스턴스 멤버에 접근할 수 없기에 setter 메서드를 static화 하지는 못 한다. 

    static void deleteContact() {}

    static void searchContact() {}

    static void modifyContact() {}

    static void printContact() {}

    static void sortContact() {}

    static void groupContact() {}

    /* main 클래스에서는 선택한 옵션에 맞게 contactMethod 클래스에 속한 메서드를 호출하려 하고 있다.
     * 다만 다른 클래스에 속한 메서드들은 해당 클래스의 인스턴스 생성 없이는 호출이 불가능하다.
     * 따라서 ContactMethod를 인스턴스화하거나, 객체 생성 없이 작업할 수 있는 static 메서드로 변환해야 한다.
     * 이 경우에, main 메서드에서 호출하려는 메서드들을 각각 static 메서드로 바꿔, 인스턴스의 생성 없이 호출할 수 있게 했다. 
     */

}


public class App {
    ArrayList <Contact> List = new ArrayList<>();
    // addContact 메서드를 통해 추가한 연락처들을 저장하는데 사용할 어레이리스트를 정의했다.
    // 배열은 크기를 변경할 수 없다는 단점이 있어 배열 기반의 List 구현 클래스인 arrayList를 선택했다.



    public static void main(String[] args) throws Exception {

        Scanner sc= new Scanner(System.in);
        System.out.println("#######################");
        System.out.println("#       주소록        #");
        
        while (true) {
            
            System.out.println("#######################");
            System.out.println("# 1. 연락처 추가      #");
            System.out.println("# 2. 연락처 삭제      #");
            System.out.println("# 3. 연락처 검색      #");
            System.out.println("# 4. 연락처 수정      #");
            System.out.println("# 5. 연락처 출력      #");
            System.out.println("# 6. 연락처 정렬      #");
            System.out.println("# 7. 연락처 그룹 정렬 #");
            System.out.println("# 8. 프로그램 종료    #");
            System.out.println("#######################");

            System.out.println("옵션을 선택해주세요 >> ");
            int selectNum= sc.nextInt();
            // 입력받은 숫자에 따라 옵션을 실행시킨다.

            switch(selectNum) {
                
                case 1 : System.out.println(System.lineSeparator()+ "연락처를 추가합니다."+System.lineSeparator());
                        Contact.addContact();
                        break;

                case 2 : System.out.println(System.lineSeparator()+ "연락처를 삭제합니다."+System.lineSeparator());
                        // Contact.deleteContact();
                        break;

                case 3 : System.out.println(System.lineSeparator()+ "연락처를 검색합니다."+System.lineSeparator());
                        //Contact.searchContact();
                        break;

                case 4 : System.out.println(System.lineSeparator()+ "연락처를 추가합니다."+System.lineSeparator());
                        //Contact.modifyContact();
                        break;

                case 5: System.out.println(System.lineSeparator()+ "연락처를 출력합니다."+System.lineSeparator());
                        //Contact.printContact();
                        break;

                case 6 : System.out.println(System.lineSeparator()+ "연락처를 정렬합니다."+System.lineSeparator());
                        //Contact.sortContact();
                        break;

                case 7 : System.out.println(System.lineSeparator()+ "연락처를 그룹별로 출력합니다."+System.lineSeparator());
                        //Contact.groupContact();
                        break;

                case 8 : System.out.println(System.lineSeparator()+ "프로그램을 종료합니다."+System.lineSeparator());
                        return;

                default : System.out.println("존재하지 않는 옵션입니다. 다시 선택해주세요.");

                /* 다른 클래스의 메서드를 가져오기 위해서는 해당 클래스 이름.메서드() 의 형태로 호출해야 한다.
                 * 이 클래스에는 addContact()와 같은 메서드는 없으므로, 어디 클래스에 있는 메서드인지 명시하는 것이 규칙이다.
                */


            }





            


        }







    }



}



