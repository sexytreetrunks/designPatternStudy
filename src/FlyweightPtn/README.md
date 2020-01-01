# Flyweight pattern

## Flyweight 패턴이란?
flyweight는 권투에서 가장 체중이 가벼운 체급을 나타냄. 이 패턴은 객체를 가볍게 하기위한 패턴임. 객체가 무겁다/가볍다란 의미는 메모리사용량을 많이/적게 사용한다는 의미. flyweight패턴은 객체가 메모리를 적게 차지하도록 하기 위해 **인스턴스를 가능한대로 공유하여 쓸데없이 새로 객체가 생성되지 않도록** 함. 

## flyweight패턴의 구성
- Flyweight: 객체가 무거워서 필요할때마다 new로 생성하면 프로그램이 무거워지게 만드는 객체. BigChar클래스가 담당
- FlyweightFactory: flyweight객체의 인스턴스를 공유하기위해 사용되는 역할. client는 flyweightfactory를 통해 flyweight의 인스턴스를 얻음
- Client: FlyweightFactory로 flyweight를 만들고 그것을 이용하는 역할

## flyweight패턴 사용시 주의사항
flyweight패턴은 인스턴스를 공유함으로써 객체를 가능한 적게 만드는 방식. 이렇게 인스턴스를 공유할때 주의할점은 **공유하는 것을 변경하면 여러 장소에 영향을 미친다**는 것임. 즉 하나의 인스턴스를 변경하면 그 인스턴스를 사용하는 여러 장소에 영향을 끼침. 따라서 flyweight패턴을 적용할때 flyweight역할이 가지고 있는 정보는 신중하게 결정해야함. flyweight역할이 가지는 정보는 여러 장소에 공유시켜야하는 정보만 제공하는게 좋음  

## 공유하는 정보 vs 공유하지않는 정보
앞에서 인스턴스의 정보에 대해 이야기했는데 객체가 공유하는 정보를 intrinsic properties라하고 공유하지 않는 정보를 extrinsic properties라고 함.  

- intrinsic properties:  
공유시키는 정보를 intrinsic properties라고 함. intrinsic은 '고유한', '본질적인' 이란 뜻을 가짐. 즉 **인스턴스를 어디에서 가지고 있더라도, 어떠한 상황에서도 변하지않는 정보**를 뜻함. BigChar의 fontData필드의 데이터는 BigString의 어디에 등장하던 변하지않음. 따라서 BigChar의 fontData는 intrinsic property가 됨  

- extrinsic properties:  
공유하지않는 정보를 extrinsic properties라고 함. extrinsic은 '외부의'라는 뜻을 가짐. 이 정보는 두는 장소에 따라 변화하는 정보, 상황에따라 변하는 정보, 상태에 의존하는 정보임. 이렇게 **장소와 상황에 의존하는 정보는 공유할수 없음** 

## 인스턴스와 garbage collection
flyweight패턴 예제에서는 HashMap을 사용하여 객체의 인스턴스를 관리하고 있음. 프로그래밍을 하다보면 종종 객체로 이루어진 array, collection을 사용하게 되는데 이때 주의할점은 **참조되고있는 객체는 garbage collection 되지 않는다**는 점임.  

자바의 garbage collection은 메모리확보를 할때 더이상 사용하지않는 객체, 즉 **참조되지않은 객체를 찾아 수거**하는 방식임. 하지만 객체가 외부(array, collection)에서 참조되어 있으면 gc가 garbage로 판정하지 않아 메모리가 해제되지 않음(이러한 객체를 **loitering object**라고 함) 따라서 객체를 담는 array, collection을 사용할때 사용한 객체(getter, arr[i] 로 꺼내서 사용한 객체)는 null처리를 해주어야함. 혹은 HashMap으로 캐시를 구현할 경우에는 WeakHashMap으로 구현하는게 바람직함.


