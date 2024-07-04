package com.oop.ex_interface.car;

/**
 *  oop/ex09/g 참조
 *
 *  Abstract 와 Interface 응용
 */

public interface CarCheckInfo {
    // Car Check 요소들
    static boolean validate(CarCheckInfo carInfo){
        // 모든 검사에서 하나라도 0이 된다면 false를 반환
        // 아니라면 true를 반환한다.
        return carInfo.getBreakOil() != 0 && carInfo.getEngineOil() != 0 && carInfo.getGas() != 0;
    }

    // 차량에 필요한 요소들
    int getGas();

    int getBreakOil();

    int getEngineOil();


}
