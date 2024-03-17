## 좋은 아키텍처란?
기능적으로는 유저에게 그들이 원하는 기능을 제공하고 구조적으로는 기능의 변화에 따라 유연하게 변경되어 제공될 수 있어야 한다. 또한 최소한의 비용으로 가능하도록 하는 구성요소와 규칙의 모임이다.

---

### 클래스 작성하는 방법
SOLID의 목표는 __변경에 유연__, **이해하기 쉬움**, **재사용 쉬움** 이다.

S : Single Responsibility Principle / 단일 책임 원칙  
- 모든 클래스는 변경에 대해 오직 하나의 이유를 가져야 한다.

O : Open-Closed Principle / 개방-폐쇄 원칙  
- 확장에는 열려 있고, 변경에는 닫혀 있어야 한다.
- 기능 구현을 분리하고 개체가 기능을 직접 참조하지 않도록하는 것이 중요 -> 추상화를 통해

L : Liskov Substitution Principle / 리스코프 치환 원칙  
- 하위 클래스 객체는 상위 클래스 객체의 역할을 그대로 수행할 수 있어야 한다.
- 보통 중간 클래스를 만들어 구분하거나, 인터페이스로 기능 분리한다.

I : Interface Segregation Principle / 인터페이스 분리 원칙  
- 자신이 사용하지 않는 메소드에 의존하지 않아야 한다.
- 의존 범위를 줄여서 서로 연관없음을 분명히 하는 것이 중요하다.

D : Dependency Inversion Principle / 의존성 역전 원칙  
- 변경이 많은 부분이 변경이 적은 부분을 의존하도록 반전시킨다.
- 즉, 추상화에 의존해야 한다.(인터페이스)

--- 

### 안드로이드에서 아키텍처
- Presentation Layer
  - Activity: 앱의 화면을 구성하는 기본 요소이며, 사용자 상호 작용을 처리합니다.
  - Fragment: Activity 내에서 재사용 가능한 모듈형 UI 구성 요소입니다.
  - ViewModel: 데이터를 보관하고 UI 업데이트를 알리는 역할을 하며, 뷰와 로직을 연결해준다.
- Domain Layer
    - UseCase: 비즈니스 로직을 구현하는 단위이며, Repository와 상호 작용하여 데이터를 가져오거나 저장합니다.
    - Repository<Interface>: 데이터 소스에 대한 추상화 계층이며, 구체적인 데이터 소스를 숨깁니다.
    - Domain Model: 도메인 문제 영역을 나타내는 데이터 객체입니다.
- Data Layer
    - Repository<Class>: Repository 인터페이스를 구현하며, 실제 데이터 소스(DB, 네트워크)와 상호 작용하여 데이터를 가져오거나 저장합니다.
    - Data Model: 데이터베이스나 네트워크에서 사용되는 데이터 객체입니다.
    - Database DataSource: 로컬 데이터베이스를 사용하는 데이터 소스입니다.
    - NetWork DataSource: 네트워크를 통해 데이터를 가져오는 데이터 소스입니다.
    - Mapper: Domain Model과 Data Model 간의 변환을 수행합니다.
