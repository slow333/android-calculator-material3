# android-calculator-material3

## using Material3 , sealed class, data class, hoisting, jetpack compose ...
> 프로젝트를 정의하고, 구성하는 순서(흐름)을 잡기가 좀 어려움..
>
## 순서
1. 프로젝트 생성
2. 프로젝트에 대한 이해(구성, 변수, 클래스 등 정의)
3. 전체 화면 및 입출력에 대한 이해
4. sealed class 정의 : data class 로 입력받는 숫자, 계산 방식을 받음
+  object로 다른 내용을 정의
+ 계산 방식: data class로 정의 -> +,-,*,/ (초기화 필요)
+ 화면에 대한 렌더링을 위한 viewModel 정의
5. viewModle 구성
  + 실제 수행에 필요한 계산 및 데이터 처리에 대해 정의함
  + MainActivity에서 click event에 대해 viweModel::onAation 을 정의해줌
## 화면 구성
> 많이 사용하는 button에 대한 component 생성
> 입력받는 창에 대한 component 생성
> 전체 화면 layout 구성

## main 화면
> 개별 화면에서 hoisting 된 값을 가지고 실제 수행할 내용을 정의

## 애러 처리
