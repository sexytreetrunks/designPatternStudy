package PrototypePtn;

import java.util.ArrayList;

public class CloneTest implements Cloneable{
    public int[] arr = new int[1];
    public int field;
    public CloneTest obj2;
    public CloneTest obj1;
    public static void main(String[] args) {
        CloneTest a = new CloneTest();
        a.arr[0] = 300;
        a.field = 4;
        a.obj1 = new CloneTest();
        a.obj2 = new CloneTest();

        try {
            CloneTest b = (CloneTest) a.clone();
            
            System.out.println("compare a.clone and a " + (b==a)); //false
            System.out.println("is equal a.clone and a "+ b.equals(a)); //false
            System.out.println("compare a.clone's class and a's class " + (b.getClass()== a.getClass())); //true
            /* clone()은 해당 클래스의 크기만큼 메모리영역을 할당하여 그안의 값(필드)을 복사하는 것이기 때문에 
             * 서로 class는 같아도 인스턴스는 같지않음(인스턴스의 내용만 같음)
             */
            System.out.println("compare field " +(a.field == b.field)); //true
            System.out.println("compare arr " + (a.arr == b.arr)); //true
            System.out.println("compare arr value " +(a.arr[0] == b.arr[0])); //true
            System.out.println("compare object "+(a.obj2 == b.obj2));
            /* 인스턴스의 내용을 복사하므로 field 비교시 true인걸 볼수있음  
             * 여기서 유의할점은 array의 포인터끼리 비교했을때도 true라는 점인데 이는 clone이 array값이 아닌 포인터를 복사하기때문
             */
            a.field = 5;
            a.arr[0] = 3;
            
            System.out.println("compare field. "+(a.field== b.field)); //false
            System.out.println("compare arr. " + (a.arr[0]==b.arr[0])); //true
            /* 이렇게 original instance의 field값을 바꿔도 clone한 인스턴스의 field값은 바뀌지않지만 array의 값은 바뀌지않음
             * 따라서 original 인스턴스와 clone한 인스턴스가 서로 독립적으로 동작해야한다면
             * clone()을 override하여 array값이 복사될수있도록 구현해야함
             */
            a.obj1.field = 9;
            a.obj2 = new CloneTest();
            System.out.println("compare object. " +(a.obj1.field==b.obj1.field)); // true
            System.out.println("compare object. " +(a.obj2==b.obj2)); // false
            /* object또한 해당 인스턴스의 포인터를 반환하기 때문에 obj1처럼 a의 필드값을바꾸면 b의 필드값또한 바뀌게됨 
             * 하지만 obj2처럼 새 인스턴스를 할당하게되면 a.obj2가 가리키는 인스턴스와 b.obj2가 가리키는 인스턴스가 달라지기때문에 다른값이됨
             * object도 array처럼 값만 완전히 복사하려면 clone()을 override해서 구현해야함
             */
            
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
