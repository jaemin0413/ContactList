import java.util.ArrayList;
import java.util.Scanner;


class Contact {
    private String name, group, number;
    // Contact 클래스의 인스턴스 변수들. 외부에서의 변수 접근을 막기 위해 접근제어자 private 사용하여 캡슐화
    // 캡슐화란? 접근제어자를 통해 변수의 직접적인 접근을 막고 메서드로의 간접적인 통제만 하게 하는 것.

    Contact (Builder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.group = builder.group;
    }
    // 참조변수 this 사용
    // 클래스의 인스턴스 변수와 매개변수가 같을 경우, 둘을 구별하기 위해 인스턴스 변수에 자기 자신을 의미하는 this를 붙인다.

    static class Builder {
        private String name,group,number;

        Builder() {}

        Builder setName(String name) {
            this.name=name;
            return this;
        }

        Builder setNumber(String number) {
            this.number=number;
            return this;
        }

        Builder setGroup(String group) {
            this.group=group;
            return this;
        }

        /* builder 클래스의 메서드들은 자기 자신. 즉 this를 반환하게 되어 있다.
           이렇게 해서 한 번의 메서드 호출로 여러 속성을 설정할 수 있게, 즉 메서드 체이닝을 하는 것이다.
           또한  메서드 체이닝을 통해 여러 메서드들을 연속해서 호출할 수 있기 때문에 객체 생성 과정이 눈에 들어오며, 
           필요한 메서드만 선택적으로 호출하여 불팔요한 값 설정을 하지 않아도 된다.*/ 

        Contact build() {
            return new Contact(this);
        }
    }

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
    // builder class에는 클래스의 객체를 생성하는 것으로 목적을 다했기에, setter 메서드와 달리 getter 메서드는 삭제하지 않고 유지했다.
    
    @Override
    public String toString() {
        return "Name: " + getName() + System.lineSeparator() +
               "Number: " + getNumber() + System.lineSeparator() +
               "Group: " + getGroup() + System.lineSeparator() ;

    // 오버라이딩을 통해 객체를 출력해도 객체의 주소 대신 이 형식의 문장이 나오게 했다.
    }

}


public class ContactManagement {

    ArrayList <Contact> contactList = new ArrayList<>();
    // addContact 메서드를 통해 추가한 연락처들을 저장하는데 사용할 어레이리스트를 정의했다.
    // 배열은 크기를 변경할 수 없다는 단점이 있어 배열 기반의 List 구현 클래스인 arrayList를 선택했다.




    public static void main(String[] args) throws Exception {

        ContactManagement CM = new ContactManagement();
        // 인스턴스 변수 및 메서드는 인스턴스 생성 전에는 존재하지 않는다. 따라서 같은 클래스 안에 있는 메서드를 호출하고자 할 때에도 꼭 인스턴스 생성이 필요하다.
        // main 메서드에서 addContact 메서드를 사용하고 싶었으나 같은 클래스에 있음에도 불구하고 호출할 수가 없어 알게 되었다.



        Scanner sc = new Scanner(System.in);
        
        System.out.println("#######################");
        System.out.println("#       주소록        #");
        
        while (true) {
            
            System.out.println("#######################");
            System.out.println("# 1. 연락처 추가      #");
            System.out.println("# 2. 연락처 검색      #");
            System.out.println("# 3. 연락처 수정      #");
            System.out.println("# 4. 연락처 삭제      #");
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
                        CM.addContact();
                        break;

                case 2 : System.out.println(System.lineSeparator()+ "연락처를 검색합니다."+System.lineSeparator());
                        CM.searchContact();        
                        break;

                case 3 : System.out.println(System.lineSeparator()+ "연락처를 수정합니다.."+System.lineSeparator());   
                        CM.modifyContact();  
                        break;

                case 4 : System.out.println(System.lineSeparator()+ "연락처를 삭제합니다."+System.lineSeparator());
                        CM.deleteContact();
                        break;

                case 5: System.out.println(System.lineSeparator()+ "연락처를 출력합니다."+System.lineSeparator());
                        CM.printContact();
                        break;

                case 6 : System.out.println(System.lineSeparator()+ "연락처를 정렬합니다."+System.lineSeparator());
                        CM.sortContact();
                        break;

                case 7 : System.out.println(System.lineSeparator()+ "연락처를 그룹별로 출력합니다."+System.lineSeparator());
                        CM.groupContact();
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
        


    // CM 클래스에서 호출할 메서드들



    void addContact() {
    // 주소록에 추가

    Scanner sc = new Scanner(System.in);

    String name, number, group;
    // 이는 contact 클래스의 private 변수와는 다른 변수이다. 
    // setter 활용을 통해 private 변수들을 변경하기 전 값을 임시로 저장하기 위해 만들어진 변수이다.

    boolean invalidname = true;
    boolean invalidnumber = true;

    System.out.println("이름: ");
    name= sc.nextLine();
    while (invalidname) {
        if (name.isBlank() ) {
            System.out.println("이름을 다시 입력해 주세요.");
            break;
            // 이름 중복검사 또한 만들어야 함.
    
        } else {
            invalidname=false;
        }
    }
    /* 먼저 scanner를 통해 입력받은 값을 name 변수에 임시로 저장하고, ~~~~~
     * while 문을 돌려 입력한 값이 올바른지 검사한다.
     * 입력한 값이 올바른 값이라면 invaildname을 true로 바꿔 while문을 종료하고, 
     * 올바르지 않은 값이라면 다시 질문한다.
     */

    System.out.println("전화번호: ");
    number=sc.nextLine();
    while (invalidnumber) {
        if (number.startsWith("010") && number.length()==11) {
            invalidnumber=false;
        } else {
            System.out.println("전화번호를 다시 입력해 주세요.");
            System.out.println("전화번호: ");
            number=sc.nextLine();
            
        }
    }

    System.out.println("그룹: ");
    group=sc.nextLine();


    Contact contact = new Contact.Builder()
                        .setName(name)
                        .setNumber(number)
                        .setGroup(group)
                        .build();
        

    contactList.add(contact);
    System.out.println(contact);

    }

    // ! main 메서드에서 직접 호출하기 위해 static 메서드로 바꿔야 함.
    // 근데 이렇게 하니 static 메서드라 setter를 통해 private화 된 변수에 접근할 수가 없음. 어떻게 해야 하는지?
    // this는 인스턴스의 참조를 가리키고 static 메서드는 인스턴스 멤버에 접근할 수 없기에 setter 메서드를 static화 하지는 못 한다. 

    // String toString 은 객체를 출력할 때 사용한다. 냅다 객체에 println 먹이면 객체의 주소만 뜨는데, 이렇게 오버라이딩 하면 객체를 풀어준다.


    //주소록 검색
    void searchContact() {
        
        System.out.println("찾고자 하는 이름을 검색해주세요");
        Scanner sc = new Scanner(System.in);
        String searchName= sc.nextLine();
        System.out.println(searchName);

        int index=-1;
        
        for (int i=0; i<contactList.size(); i++) {
            if (contactList.get(i).getName().equals(searchName)) {
                index = i;
                break;
            } 
        }

        if (index == -1) {
            System.out.println("연락처에 존재하지 않는 이름입니다.");
        } else {
            System.out.println(contactList.get(index));
        }

        //if (contactList.indexOf(searchName) == -1) {
        //    System.out.println("연락처에 존재하지 않는 이름입니다.");
        //} else {
        //    System.out.println(contactList.get(contactList.indexOf(searchName)));
        //}
        

        }
        
    


    void modifyContact() {}

    void deleteContact() {}

    //연락처 출력
    void printContact() {
        for (int i=0; i<contactList.size(); i++) {
            System.out.println(contactList.get(i));
        }
    }

    void sortContact() {}

    void groupContact() {}

    /* main 클래스에서는 선택한 옵션에 맞게 contactMethod 클래스에 속한 메서드를 호출하려 하고 있다.
     * 다만 다른 클래스에 속한 메서드들은 해당 클래스의 인스턴스 생성 없이는 호출이 불가능하다.
     * 따라서 ContactMethod를 인스턴스화하거나, 객체 생성 없이 작업할 수 있는 static 메서드로 변환해야 한다.
     * 이 경우에, main 메서드에서 호출하려는 메서드들을 각각 static 메서드로 바꿔, 인스턴스의 생성 없이 호출할 수 있게 했다. 
     */



}



