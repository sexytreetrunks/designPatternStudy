# Proxy pattern

## proxy패턴이란?
proxy는 '대리인'이라는 뜻. 대리인은 '본인'이 해야할 일을 대신 처리하는 역할. proxy패턴에서는 '본인'에 해당되는 객체가 해야할일을 '대리인'에 해당되는 객체가 대신 처리해줌. 하지만 대리인은 어디까지나 대리인이기 때문에 해야할 일에 한계가 있음. 따라서 대리인은 자신이 허락된 범위내에서 본인을 대신하여 일을 처리하고, 허용범위를 벗어나는 일이 발생하면 본인 객체를 호출하여 일을 처리하도록 함  

## proxy패턴의 구성
- Subject: Proxy와 RealSubject를 동일시하기위한 인터페이스를 결정. Subject역할 덕분에 client는 proxy와 realsubject간의 차이를 의식할 필요가 없음. Printable인터페이스가 해당 역할  
- Proxy: client의 요구를 가능한 만큼 처리. 자신만으론 처리할수없으면 realsubject에게 처리를 맡김. 이때 realsubject의 역할이 필요할때에 realsubject의 인스턴스를 생성함. 
- RealSubject: proxy에서 감당할수없는 일이 발생했을때 생성되는 클래스. Printer클래스가 해당 역할
- Client: proxy패턴을 사용

## proxy패턴 왜 사용함?
proxy패턴의 예제에선 proxy역할을 사용해서 일반적인 처리를 맡기고 print같은 무거운 처리가 호출되면 realsubject에게 맡기고 있음. 또한 이렇게 realsubject가 직접 필요하지 않는한 realsubject의 인스턴스를 만들지 않음. 이는 초기화에 시간이 걸리는 기능이 많은 대규모 시스템을 생각해보면 유용한 패턴임. 어플리케이션이 시작할때 당장 필요하지않은 기능들을 모두 초기화 시키게되면 초기 가동시간이 너무 오래걸려 사용자의 불편을 초래함. 


